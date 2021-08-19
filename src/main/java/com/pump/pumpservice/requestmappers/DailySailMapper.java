package com.pump.pumpservice.requestmappers;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DailySailMapper {

    private Long id;
    private String name;
    private String fuelType;
    private double rate;
    private double opening;
    private double closing;
    private Long dailySaleId;
    private Long nozzleId;
    private Timestamp entryDate;

}
