package com.pump.pumpservice.api;

import com.pump.pumpservice.requestmappers.DateMapper;
import com.pump.pumpservice.responses.StockRateHistoryUpcoming;
import com.pump.pumpservice.stockrate.StockRate;
import com.pump.pumpservice.stockrate.StockRateRepository;
import com.pump.pumpservice.stocktype.StockType;
import com.pump.pumpservice.stocktype.StockTypeRepository;
import com.pump.pumpservice.responses.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StockService {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StockTypeRepository stockTypeRepository;
    @Autowired
    private StockRateRepository stockRateRepository;

    public DefaultResponse addStockType(StockType stockType) {
        LOGGER.info("Adding Stock Type");
        stockTypeRepository.save(stockType);
        return new DefaultResponse("S001","success", stockType.getId());
    }

    public List<StockType> getStockTypes() {
        LOGGER.info("Returning all stocks");
        return stockTypeRepository.findAll();
    }

    public DefaultResponse addStockRate(StockRate stockRate) {

        LOGGER.info("Adding Stock Rate : active date" + stockRate.getActiveDate());
        LOGGER.info("Entry Date : " + stockRate.getEntryDate());
        Date activeDate = stockRate.getActiveDate();
//        activeDate.setHours(0);
//        activeDate.setMinutes(0);
//        activeDate.setSeconds(0);
        stockRate.setActiveDate(activeDate);
        stockRate.setId(null);
        stockRateRepository.save(stockRate);

        return new DefaultResponse("S001","success");
    }

    public List<StockRate> getStockRates(Date date) {

        LOGGER.info("Get Stock Rate");

        List<StockType> stockTypes = stockTypeRepository.findAll();
        List<StockRate> stockRates = new ArrayList<>();

        for(int index = 0; index < stockTypes.size() ; index++) {
            stockRates.add(getStockRateByDate(stockTypes.get(index), date));
        }
        return stockRates;

    }

    public StockRate getStockRateByDate(StockType stockType, Date date){

       List<StockRate> stockRates = stockRateRepository.findByActiveDate(stockType.getId(), date, PageRequest.of(0,1));
       LOGGER.info("Size : " + stockRates.size());
       if(stockRates.size() > 0) {
           stockRates.get(0).setStockTypeName(stockType.getName());
           return stockRates.get(0);
       }else {
           return null;
       }

    }

    public StockRateHistoryUpcoming getStockRateHistoryAndUpcoming(DateMapper dateMapper, Long stockTypeId) {
        List<StockRate> stockRatesHistory = getSockRatesHistory(dateMapper.getDate(), stockTypeId);
        List<StockRate> stockRatesUpcoming = getStockRateUpcoming(dateMapper.getDate(), stockTypeId);
        return new StockRateHistoryUpcoming(stockRatesHistory, stockRatesUpcoming);
    }

    public List<StockRate> getSockRatesHistory(Date currentDate, Long stockTypeId) {
        return stockRateRepository.getStockRateHistory(stockTypeId, currentDate);
    }

    public List<StockRate> getStockRateUpcoming(Date currentDate, Long stockTypeId) {
        return stockRateRepository.getStockRateUpcoming(stockTypeId, currentDate);
    }
}
