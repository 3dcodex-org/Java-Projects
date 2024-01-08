package com.bankmanagement.bankmanagement.model;

import com.bankmanagement.bankmanagement.helper.status.TransactionStatus;
import com.bankmanagement.bankmanagement.helper.status.TransactionType;
import jakarta.persistence.*;

import java.util.Date;

@Entity @SuppressWarnings("unused")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "transaction_type")
    private TransactionType transactionType;
    @ManyToOne
    private Account account;
    private Double amount;
    @Column(name = "branch_code")
    private Integer branchCode;
    @ManyToOne
    @JoinColumn(name = "transaction_initiator", nullable = false, updatable = false)
    private User transactionInitiator;
    @Column(name = "transaction_reason")
    private String transactionReason;
    @Column(name = "transaction_status")
    private TransactionStatus transactionStatus;
    @Column(name = "transaction_date")
    private Date transactionDate;
    public Transaction(){}

    public Transaction(TransactionType transactionType, Account account, Double amount, Integer branchCode, User transactionInitiator, String transactionReason) {
        this.transactionType = transactionType;
        this.account = account;
        this.amount = amount;
        this.branchCode = branchCode;
        this.transactionInitiator = transactionInitiator;
        this.transactionReason = transactionReason;
        this.transactionDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public User getTransactionInitiator() {
        return transactionInitiator;
    }

    public void setTransactionInitiator(User transactionInitiator) {
        this.transactionInitiator = transactionInitiator;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transationType=" + transactionType +
                ", account=" + account +
                ", amount=" + amount +
                ", branchCode=" + branchCode +
                ", transactionInitiator=" + transactionInitiator +
                ", transactionReason='" + transactionReason + '\'' +
                ", transactionStatus=" + transactionStatus +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
