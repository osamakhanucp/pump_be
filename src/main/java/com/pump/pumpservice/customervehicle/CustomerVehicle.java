package com.pump.pumpservice.customervehicle;

import javax.persistence.*;

@Entity
@Table(name = "t_customer_vehicle")
public class CustomerVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String number;
    private String type;
    private Long stockTypeId;
    private String dateAdded;
    private String imageUuid;

    private Long customerLedgerId;

    public CustomerVehicle() {//empty
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getImageUuid() {
        return imageUuid;
    }

    public void setImageUuid(String imageUuid) {
        this.imageUuid = imageUuid;
    }

    public Long getCustomerLedgerId() {
        return customerLedgerId;
    }

    public void setCustomerLedgerId(Long customerLedgerId) {
        this.customerLedgerId = customerLedgerId;
    }

    public Long getStockTypeId() {
        return stockTypeId;
    }

    public void setStockTypeId(Long stockTypeId) {
        this.stockTypeId = stockTypeId;
    }
}
