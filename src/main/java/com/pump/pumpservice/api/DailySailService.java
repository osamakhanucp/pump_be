package com.pump.pumpservice.api;

import com.pump.pumpservice.dailysalenozzles.DailySaleNozzle;
import com.pump.pumpservice.dailysalenozzles.DailySaleNozzleRepository;
import com.pump.pumpservice.nozzles.Nozzle;
import com.pump.pumpservice.nozzles.NozzleRepository;
import com.pump.pumpservice.requestmappers.DateMapper;
import com.pump.pumpservice.responses.MeterReadingTemplate;
import com.pump.pumpservice.responses.DefaultResponse;
import com.pump.pumpservice.stockrate.StockRate;
import com.pump.pumpservice.stockrate.StockRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DailySailService {

    @Autowired
    private DailySaleNozzleRepository dailySaleNozzleRepository;
    @Autowired
    private NozzleRepository nozzleRepository;
    @Autowired
    private StockRateRepository stockRateRepository;

    public DefaultResponse setMeterReading(List<DailySaleNozzle> dailySaleNozzleList, Date entryDate) {
        entryDate.setMinutes(0);
        entryDate.setHours(0);
        entryDate.setSeconds(0);
        for(int index = 0 ; index < dailySaleNozzleList.size(); index++) {
            DailySaleNozzle dailySaleNozzle = dailySaleNozzleList.get(index);
            dailySaleNozzle.setEntryDate(entryDate);
            dailySaleNozzleRepository.save(dailySaleNozzle);
        }
        return new DefaultResponse();
    }

    public MeterReadingTemplate getMeterReadingTemplate(DateMapper dateMapper) throws ParseException {


        Date currentDate = dateMapper.getDate();
        currentDate.setMinutes(0);
        currentDate.setHours(0);
        currentDate.setSeconds(0);
        //initializing
        MeterReadingTemplate meterReadingTemplate = new MeterReadingTemplate();
        List<DailySaleNozzle> dailySaleNozzles = dailySaleNozzleRepository.findAllByEntryDate(currentDate);
        if(dailySaleNozzles != null && dailySaleNozzles.size() > 0) {
            meterReadingTemplate.setDailySaleNozzles(dailySaleNozzles);
            return meterReadingTemplate;
        }else {
            Date previousDate = getPreviousDate(currentDate);
            List<DailySaleNozzle> dailySaleNozzlesPreviousDay = dailySaleNozzleRepository.findAllByEntryDate(previousDate);
            List<Nozzle> nozzles = nozzleRepository.findAll();

            for(int index = 0 ; index < nozzles.size() ; index++ ){
                double openingForNozzle = getNozzleOpening(nozzles.get(index), dailySaleNozzlesPreviousDay);
                DailySaleNozzle dailySaleNozzle = new DailySaleNozzle(nozzles.get(index),nozzles.get(index).getRate(), openingForNozzle);
                StockRate stockRate = stockRateRepository.findStockByActiveDate(nozzles.get(index).getStockTypeId(), currentDate);
                if(stockRate != null) {
                    dailySaleNozzle.setRate(stockRate.getsRate());
                    meterReadingTemplate.getDailySaleNozzles().add(dailySaleNozzle);
                }
            }
        }

        return meterReadingTemplate;
    }

    private Date getPreviousDate(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, -1);
        Date previousDate = calendar.getTime();
        System.out.println(previousDate);
        return previousDate;
    }

    private double  getNozzleOpening(Nozzle nozzle, List<DailySaleNozzle> dailySaleNozzlesPreviousDay) {
        for(int index = 0 ; index < dailySaleNozzlesPreviousDay.size() ; index++) {
            if(nozzle.getId().equals(dailySaleNozzlesPreviousDay.get(index).getNozzleId())) {
                return dailySaleNozzlesPreviousDay.get(index).getClosing();
            }
        }
        return nozzle.getOpening();
    }
}
