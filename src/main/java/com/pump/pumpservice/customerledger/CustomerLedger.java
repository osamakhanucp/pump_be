package com.pump.pumpservice.customerledger;

import com.pump.pumpservice.requestmappers.CustomerLedgerMapper;

import javax.persistence.*;

@Entity
@Table(name = "t_customer_ledger")
public class CustomerLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerName;
    private String status;
    private String contactPerson;
    private String contactNo;
    private String address;
    private String dateCreated;
    private String dateClosed;

    public CustomerLedger() {//empty
    }

    public CustomerLedger(CustomerLedgerMapper customerLedgerMapper) {
        this.customerName = customerLedgerMapper.getCustomerName();
        this.status = customerLedgerMapper.getStatus();
        this.contactPerson = customerLedgerMapper.getContactPerson();
        this.contactNo = customerLedgerMapper.getContactNo();
        this.address = customerLedgerMapper.getAddress();
        this.dateCreated = customerLedgerMapper.getDateCreated();
        this.dateClosed = customerLedgerMapper.getDateClosed();
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
}
