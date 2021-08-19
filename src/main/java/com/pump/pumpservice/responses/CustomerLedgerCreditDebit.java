package com.pump.pumpservice.responses;

import com.pump.pumpservice.bankledgercreditdebit.BankLedgerCreditDebit;
import com.pump.pumpservice.sales.Sale;

import java.util.Date;

public class CustomerLedgerCreditDebit {

    private Long id;
    private Date date;
    private String description;
    private Double debit;
    private Double credit;

    public CustomerLedgerCreditDebit(Sale sale) {
        this.id = sale.getId();
        this.date = sale.getDateCreated();
        this.description = sale.getDescription();
        this.debit = null;
        this.credit = sale.getAmount();
    }

    public CustomerLedgerCreditDebit(BankLedgerCreditDebit bankLedgerCreditDebit) {
        this.id = bankLedgerCreditDebit.getId();
        this.date = bankLedgerCreditDebit.getEntryDate();
        this.description = bankLedgerCreditDebit.getDescription();
        this.debit = bankLedgerCreditDebit.getDebit();
        this.credit = null;
    }


    public CustomerLedgerCreditDebit() {//empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }
}
