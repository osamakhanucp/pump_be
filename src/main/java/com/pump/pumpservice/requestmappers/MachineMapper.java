package com.pump.pumpservice.requestmappers;

import com.pump.pumpservice.nozzles.Nozzle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MachineMapper {

    private Long id;
    private String name;
    private String type;
    private Date installationDate;
    private int numberOfNozzles;

    List<Nozzle> nozzles = new ArrayList<>();

    public MachineMapper() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public int getNumberOfNozzles() {
        return numberOfNozzles;
    }

    public void setNumberOfNozzles(int numberOfNozzles) {
        this.numberOfNozzles = numberOfNozzles;
    }

    public List<Nozzle> getNozzles() {
        return nozzles;
    }

    public void setNozzles(List<Nozzle> nozzles) {
        this.nozzles = nozzles;
    }
}
