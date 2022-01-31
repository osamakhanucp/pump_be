package com.pump.pumpservice.supplierledger;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "t_supplier_ledger")
public class SupplierLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String supplierName;
    private String address;
    private Date registrationDate;

    public SupplierLedger() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
