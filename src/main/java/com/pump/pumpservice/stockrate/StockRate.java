package com.pump.pumpservice.stockrate;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "t_stock_rate")
public class StockRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date entryDate;
    private double pRate;
    private double sRate;
    private String status;

    private Date activeDate;

    @Transient
    private String stockTypeName;

    private Long stockTypeId;

    public StockRate() {
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

    public double getpRate() {
        return pRate;
    }

    public void setpRate(double pRate) {
        this.pRate = pRate;
    }

    public double getsRate() {
        return sRate;
    }

    public void setsRate(double sRate) {
        this.sRate = sRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStockTypeId() {
        return stockTypeId;
    }

    public void setStockTypeId(Long stockTypeId) {
        this.stockTypeId = stockTypeId;
    }

    public String getStockTypeName() {
        return stockTypeName;
    }

    public void setStockTypeName(String stockTypeName) {
        this.stockTypeName = stockTypeName;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}
