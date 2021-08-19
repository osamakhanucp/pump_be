package com.pump.pumpservice.responses;

import com.pump.pumpservice.dailysalenozzles.DailySaleNozzle;

import java.util.ArrayList;
import java.util.List;

public class DailySaleTemplate {

    private Long id;
    private boolean canEdit = true;
    private List<DailySaleNozzle> dailySaleNozzles = new ArrayList<>();

    public DailySaleTemplate() {//empty
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
}
