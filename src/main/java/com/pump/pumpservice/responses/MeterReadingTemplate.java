package com.pump.pumpservice.responses;

import com.pump.pumpservice.dailysalenozzles.DailySaleNozzle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeterReadingTemplate {

    private Long id;
    private boolean canEdit = true;
    private Date entryDate;
    private List<DailySaleNozzle> dailySaleNozzles = new ArrayList<>();

    public MeterReadingTemplate() {//empty
    }

    public List<DailySaleNozzle> getDailySaleNozzles() {
        return dailySaleNozzles;
    }

    public void setDailySaleNozzles(List<DailySaleNozzle> dailySaleNozzles) {
        this.dailySaleNozzles = dailySaleNozzles;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
