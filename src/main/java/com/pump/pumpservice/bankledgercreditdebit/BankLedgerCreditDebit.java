package com.pump.pumpservice.bankledgercreditdebit;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_bank_ledger_credit_debit")
public class BankLedgerCreditDebit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date entryDate;
    private String description;
    private double debit;
    private double credit;
    private String type;

    private Long customerLedgerId;

    private Long bankLedgerId;

    public BankLedgerCreditDebit() {//empty
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBankLedgerId() {
        return bankLedgerId;
    }

    public void setBankLedgerId(Long bankLedgerId) {
        this.bankLedgerId = bankLedgerId;
    }

    public Long getCustomerLedgerId() {
        return customerLedgerId;
    }

    public void setCustomerLedgerId(Long customerLedgerId) {
        this.customerLedgerId = customerLedgerId;
    }
}
