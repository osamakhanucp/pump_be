package com.pump.pumpservice.responses;

import com.pump.pumpservice.bankledger.BankLedger;
import com.pump.pumpservice.bankledgercreditdebit.BankLedgerCreditDebit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankLedgerDetail {

    private Long id;
    private String accountName;
    private String accountNumber;
    private String  accountTitle;
    private String contact;
    private String branchAddress;
    private Date createdAt;
    private double balance;

    private List<BankLedgerCreditDebit> bankLedgerCreditDebits = new ArrayList<>();

    public BankLedgerDetail() {//empty
    }

    public BankLedgerDetail(BankLedger bankLedger) {
        this.id = bankLedger.getId();
        this.accountName = bankLedger.getAccountName();
        this.accountNumber = bankLedger.getAccountNumber();
        this.accountTitle = bankLedger.getAccountTitle();
        this.contact = bankLedger.getContact();
        this.branchAddress = bankLedger.getBranchAddress();
        this.createdAt = bankLedger.getCreatedAt();
        this.balance = bankLedger.getBalance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<BankLedgerCreditDebit> getBankLedgerCreditDebits() {
        return bankLedgerCreditDebits;
    }

    public void setBankLedgerCreditDebits(List<BankLedgerCreditDebit> bankLedgerCreditDebits) {
        this.bankLedgerCreditDebits = bankLedgerCreditDebits;
    }
}
