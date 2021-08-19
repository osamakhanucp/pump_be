package com.pump.pumpservice.dailysalenozzles;

import com.pump.pumpservice.nozzles.Nozzle;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_daily_sale_nozzle")
public class DailySaleNozzle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String fuelType;
    private double rate;
    private double opening;
    private double closing;

    private Long dailySaleId;

    private Long nozzleId;

    private Date entryDate;

    public DailySaleNozzle() {
    }

    public DailySaleNozzle(Nozzle nozzle, double rate, double opening) {

        this.name = nozzle.getName();
        this.fuelType = nozzle.getType();
        this.rate = rate;
        this.opening = opening;
        this.nozzleId = nozzle.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getOpening() {
        return opening;
    }

    public void setOpening(double opening) {
        this.opening = opening;
    }

    public double getClosing() {
        return closing;
    }

    public void setClosing(double closing) {
        this.closing = closing;
    }

    public Long getNozzleId() {
        return nozzleId;
    }

    public void setNozzleId(Long nozzleId) {
        this.nozzleId = nozzleId;
    }

    public Long getDailySaleId() {
        return dailySaleId;
    }

    public void setDailySaleId(Long dailySaleId) {
        this.dailySaleId = dailySaleId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
