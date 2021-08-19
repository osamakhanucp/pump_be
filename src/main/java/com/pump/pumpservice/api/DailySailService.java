package com.pump.pumpservice.api;

import com.pump.pumpservice.dailysalenozzles.DailySaleNozzle;
import com.pump.pumpservice.dailysalenozzles.DailySaleNozzleRepository;
import com.pump.pumpservice.dailysales.DailySale;
import com.pump.pumpservice.responses.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class DailySailService {

    @Autowired
    private DailySaleNozzleRepository dailySaleNozzleRepository;

    public DefaultResponse setDailySale(List<DailySaleNozzle> dailySaleNozzleList, Date entryDate) {
        for(int index = 0 ; index < dailySaleNozzleList.size(); index++) {
            DailySaleNozzle dailySaleNozzle = dailySaleNozzleList.get(index);
            dailySaleNozzle.setEntryDate(entryDate);
            dailySaleNozzleRepository.save(dailySaleNozzle);
        }
        return new DefaultResponse();
    }
}
