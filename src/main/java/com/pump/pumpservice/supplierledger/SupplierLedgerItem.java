package com.pump.pumpservice.supplierledger;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_supplier_ledger_item")
public class SupplierLedgerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long supplierLedgerId;
    private Long stockId;
    private double quantity;
    private double totalPrice;
    private double perLiterPrice;
    private Date entryDate;

    public SupplierLedgerItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierLedgerId() {
        return supplierLedgerId;
    }

    public void setSupplierLedgerId(Long supplierLedgerId) {
        this.supplierLedgerId = supplierLedgerId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPerLiterPrice() {
        return perLiterPrice;
    }

    public void setPerLiterPrice(double perLiterPrice) {
        this.perLiterPrice = perLiterPrice;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
