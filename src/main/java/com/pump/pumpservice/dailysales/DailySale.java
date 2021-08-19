package com.pump.pumpservice.dailysales;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_daily_sale")
public class DailySale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date entryDate;

    public DailySale() {
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
