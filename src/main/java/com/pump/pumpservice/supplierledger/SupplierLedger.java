package com.pump.pumpservice.supplierledger;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_supplier_ledger")
public class SupplierLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String supplierName;
    private String address;
    private Date registrationDate;
}
