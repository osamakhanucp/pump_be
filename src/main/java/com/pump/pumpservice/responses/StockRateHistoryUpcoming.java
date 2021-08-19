package com.pump.pumpservice.responses;

import com.pump.pumpservice.stockrate.StockRate;
import lombok.Data;

import java.util.List;

@Data
public class StockRateHistoryUpcoming {
    List<StockRate> stockRatesHistory;
    List<StockRate> stockRatesUpcoming;

    public StockRateHistoryUpcoming(List<StockRate> stockRatesHistory, List<StockRate> stockRatesUpcoming) {
        this.stockRatesHistory = stockRatesHistory;
        this.stockRatesUpcoming = stockRatesUpcoming;
    }
}
