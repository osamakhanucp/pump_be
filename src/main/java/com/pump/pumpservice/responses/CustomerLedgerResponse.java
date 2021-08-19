package com.pump.pumpservice.responses;

import com.pump.pumpservice.customerledger.CustomerLedger;
import com.pump.pumpservice.customervehicle.CustomerVehicle;

import java.util.ArrayList;
import java.util.List;

public class CustomerLedgerResponse {

    private Long id;
    private String customerName;
    private String status;
    private String contactPerson;
    private String contactNo;
    private String address;
    private String dateCreated;
    private String dateClosed;

    List<CustomerVehicle> customerVehicles = new ArrayList<>();

    public CustomerLedgerResponse() {//constructor
    }

    public CustomerLedgerResponse(CustomerLedger customerLedger) {
        this.id = customerLedger.getId();
        this.customerName = customerLedger.getCustomerName();
        this.status = customerLedger.getStatus();
        this.contactPerson = customerLedger.getContactPerson();
        this.contactNo = customerLedger.getContactNo();
        this.address = customerLedger.getAddress();
        this.dateCreated = customerLedger.getDateCreated();
        this.dateClosed = customerLedger.getDateClosed();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
