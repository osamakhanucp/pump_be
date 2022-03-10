package com.pump.pumpservice.api;


import com.pump.pumpservice.dailysalenozzles.DailySaleNozzle;
import com.pump.pumpservice.dailysalenozzles.DailySaleNozzleRepository;
import com.pump.pumpservice.dailysales.DailySale;
import com.pump.pumpservice.dailysales.DailySaleRepository;
import com.pump.pumpservice.nozzles.Nozzle;
import com.pump.pumpservice.nozzles.NozzleRepository;
import com.pump.pumpservice.requestmappers.DateMapper;
import com.pump.pumpservice.responses.MeterReadingTemplate;
import com.pump.pumpservice.responses.DefaultResponse;
import com.pump.pumpservice.stockrate.StockRate;
import com.pump.pumpservice.stockrate.StockRateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MachineService {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NozzleRepository nozzleRepository;
    @Autowired
    private DailySaleRepository dailySaleRepository;
    @Autowired
    private DailySaleNozzleRepository dailySaleNozzleRepository;
    @Autowired
    private StockRateRepository stockRateRepository;


    DefaultResponse addNozzle(Nozzle nozzle)
    {
        LOGGER.info("Adding nozzel  :" + nozzle.getName());
        nozzleRepository.save(nozzle);
        return new DefaultResponse("201","success");

    }

    DefaultResponse editNozzles(Nozzle nozzle)
    {
        LOGGER.info("Editing nozzel  :" + nozzle.getName());
        Optional<Nozzle> storedNozzel = nozzleRepository.findById(nozzle.getId());
        if(storedNozzel.isPresent()) {
            storedNozzel.get().setName(nozzle.getName());
            nozzleRepository.save(storedNozzel.get());
            return new DefaultResponse("201","success");
        }

        return new DefaultResponse("400","Bad Request");

    }

    DefaultResponse deleteNozzles(Nozzle nozzle)
    {
        LOGGER.info("Deleting nozzle  :" + nozzle.getName());
        Optional<Nozzle> storedNozzel = nozzleRepository.findById(nozzle.getId());
        if(storedNozzel.isPresent()) {
            int count = dailySaleNozzleRepository.getDailySaleNozzleCount(storedNozzel.get().getId());
            if(count <= 0) {
                nozzleRepository.delete(storedNozzel.get());
                return new DefaultResponse("200","success");
            }
            return new DefaultResponse("400","Can not delete, nozzle is being used in Meter reading");
        }
        return new DefaultResponse("500","not found");


    }

    List<Nozzle> getNozzles() {
        return nozzleRepository.findAll();
    }

    MeterReadingTemplate getDailySaleTemplate(DateMapper dateMapper) throws ParseException {

        Date currentDate = dateMapper.getDate();
        //initializing
        MeterReadingTemplate meterReadingTemplate = new MeterReadingTemplate();

        DailySale dailySale = dailySaleRepository.findByEntryDateAfterOrEntryDate(currentDate, currentDate);
        if(dailySale != null){
            List<DailySaleNozzle> dailySaleNozzles = dailySaleNozzleRepository.findAllByDailySaleId(dailySale.getId());
            meterReadingTemplate.getDailySaleNozzles().addAll(dailySaleNozzles);
            meterReadingTemplate.setCanEdit(false);
            return meterReadingTemplate;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, -1);
        Date yesterdayDate = calendar.getTime();
        System.out.println(yesterdayDate);

        DailySale dailySaleForPreviousDay = dailySaleRepository.findByEntryDateAfterOrEntryDate(yesterdayDate, yesterdayDate);
        List<DailySaleNozzle> dailySaleNozzlesPreviousDay = new ArrayList<>();

        if(dailySaleForPreviousDay != null){
            dailySaleNozzlesPreviousDay = dailySaleNozzleRepository.findAllByDailySaleId(dailySaleForPreviousDay.getId());
        }


        //Setting daily nozzle entry from current active nozzles
        List<Nozzle> nozzles = nozzleRepository.findAll();
        for(int index = 0 ; index < nozzles.size() ; index++) {

            double openingForNozzle = getNozzleOpening(nozzles.get(index), dailySaleNozzlesPreviousDay);
            DailySaleNozzle dailySaleNozzle = new DailySaleNozzle(nozzles.get(index),nozzles.get(index).getRate(), openingForNozzle);
            System.out.println("Datetemp : " + dateMapper.getDate());
            StockRate stockRate = stockRateRepository.findStockByActiveDate(nozzles.get(index).getStockTypeId(), dateMapper.getDate());
            if(stockRate != null) {
                dailySaleNozzle.setRate(stockRate.getsRate());
                meterReadingTemplate.getDailySaleNozzles().add(dailySaleNozzle);
            }
        }

        return meterReadingTemplate;
    }

    private double  getNozzleOpening(Nozzle nozzle, List<DailySaleNozzle> dailySaleNozzlesPreviousDay) {
        for(int index = 0 ; index < dailySaleNozzlesPreviousDay.size() ; index++) {
            if(nozzle.getId().equals(dailySaleNozzlesPreviousDay.get(index).getNozzleId())) {
                return dailySaleNozzlesPreviousDay.get(index).getClosing();
            }
        }
        return nozzle.getOpening();
    }

    DefaultResponse addDailySale(@RequestBody MeterReadingTemplate meterReadingTemplate)
    {
        DailySale dailySale = new DailySale();
        dailySale.setId(meterReadingTemplate.getId());
        Date date = new Date();
//        date.setMinutes(0);
//        date.setHours(0);
//        date.setSeconds(0);
        dailySale.setEntryDate(date);
        dailySaleRepository.save(dailySale);

        for(int index = 0; index < meterReadingTemplate.getDailySaleNozzles().size() ; index++ ) {
            DailySaleNozzle dailySaleNozzle = meterReadingTemplate.getDailySaleNozzles().get(index);
            dailySaleNozzle.setDailySaleId(dailySale.getId());
            dailySaleNozzleRepository.save(dailySaleNozzle);
        }

        return new DefaultResponse("201","success");

    }

    MeterReadingTemplate getDailySaleByDate(String dateParam) throws ParseException {

        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = new SimpleDateFormat("dd-mm-yyyy").parse(dateParam);

//        date.setHours(05);
//        date.setMinutes(0);
//        date.setSeconds(0);

        MeterReadingTemplate meterReadingTemplate = new MeterReadingTemplate();
        System.out.println("Get By Date" + date);

        Date newDate = new Date();
//        newDate.setDate(date.getDate());
//        newDate.setMinutes(0);
//        newDate.setHours(0);
//        newDate.setSeconds(0);

        DailySale dailySale = dailySaleRepository.findByEntryDate(newDate);
        if(dailySale != null){
            List<DailySaleNozzle> dailySaleNozzles = dailySaleNozzleRepository.findAllByDailySaleId(dailySale.getId());
            meterReadingTemplate.getDailySaleNozzles().addAll(dailySaleNozzles);
            meterReadingTemplate.setCanEdit(false);
            return meterReadingTemplate;
        }

        return meterReadingTemplate;
    }

}
