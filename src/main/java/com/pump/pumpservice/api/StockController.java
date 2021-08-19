package com.pump.pumpservice.api;


import com.pump.pumpservice.responses.StockRateHistoryUpcoming;
import com.pump.pumpservice.stockrate.StockRate;
import com.pump.pumpservice.stocktype.StockType;
import com.pump.pumpservice.requestmappers.DateMapper;
import com.pump.pumpservice.responses.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stocks")
@CrossOrigin
public class StockController {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StockService stockService;

    @RequestMapping(method = RequestMethod.POST,value="/types")
    public @ResponseBody
    DefaultResponse addRate(@RequestBody StockType stockType) {
        return stockService.addStockType(stockType);
    }

    @RequestMapping(method = RequestMethod.GET,value="/types")
    public @ResponseBody
    List<StockType> getRate() {
        return stockService.getStockTypes();
    }

    @RequestMapping(method = RequestMethod.POST,value="/rates")
    public @ResponseBody DefaultResponse addStockRate(@RequestBody StockRate stockRate) {
        return stockService.addStockRate(stockRate);
    }

    @RequestMapping(method = RequestMethod.POST,value="/rates/bydate")
    public @ResponseBody List<StockRate> getStockRates(@RequestBody DateMapper dateMapper) {
        return stockService.getStockRates(dateMapper.getDate());
    }

    @PostMapping("/{stockTypeId}/rates/record")
    public StockRateHistoryUpcoming getStockRateHistoryAndUpcoming(@RequestBody DateMapper dateMapper, @PathVariable("stockTypeId") Long stockTypeId) {

        dateMapper.getDate().setMinutes(0);
        dateMapper.getDate().setHours(0);
        dateMapper.getDate().setSeconds(0);
        return stockService.getStockRateHistoryAndUpcoming(dateMapper, stockTypeId);
    }
}
