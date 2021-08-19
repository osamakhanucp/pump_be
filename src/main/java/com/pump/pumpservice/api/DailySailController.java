package com.pump.pumpservice.api;

import com.pump.pumpservice.dailysalenozzles.DailySaleNozzle;
import com.pump.pumpservice.responses.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class DailySailController {

    @Autowired
    private DailySailService dailySailService;

    public DefaultResponse setDailySale(List<DailySaleNozzle> dailySaleNozzleList) {
        return dailySailService.setDailySale(dailySaleNozzleList, new Date());
    }
}
