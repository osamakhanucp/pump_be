package com.pump.pumpservice.requestmappers;

import com.pump.pumpservice.customervehicle.CustomerVehicle;

import java.util.ArrayList;
import java.util.List;

public class CustomerLedgerMapper {

    private String customerName;
    private String status;
    private String contactPerson;
    private String contactNo;
    private String address;
    private String dateCreated;
    private String dateClosed;

    List<CustomerVehicle> customerVehicles = new ArrayList<>();

    public CustomerLedgerMapper() {//empty constructor
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public List<CustomerVehicle> getCustomerVehicles() {
        return customerVehicles;
    }

    public void setCustomerVehicles(List<CustomerVehicle> customerVehicles) {
        this.customerVehicles = customerVehicles;
    }
}
