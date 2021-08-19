package com.pump.pumpservice.bankledger;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_bank_ledger")
public class BankLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountName;
    private String accountNumber;
    private String  accountTitle;
    private String contact;
    private String branchAddress;
    private Date createdAt;
    private double balance;

    public BankLedger() {//empty
    }

    public BankLedger(Long id, String accountName, String accountNumber, String accountTitle, String contact, String branchAddress, Date createdAt, double balance) {
        this.id = id;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountTitle = accountTitle;
        this.contact = contact;
        this.branchAddress = branchAddress;
        this.createdAt = createdAt;
        this.balance = balance;
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
}
