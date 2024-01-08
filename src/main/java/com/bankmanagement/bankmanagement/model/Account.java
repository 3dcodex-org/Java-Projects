package com.bankmanagement.bankmanagement.model;

import com.bankmanagement.bankmanagement.helper.helper.AccountNumberGenerator;
import com.bankmanagement.bankmanagement.helper.status.AccountStatus;
import com.bankmanagement.bankmanagement.helper.status.AccountType;
import jakarta.persistence.*;

@Entity @SuppressWarnings("unused")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number", unique = true)
    private String AccountNumber;

    @ManyToOne
    @JoinColumn(name = "account_holder", nullable = false)
    private User accountHolder;
    @Column(name = "account_type")
    private AccountType accountType;
    private Double balance;
    @Column(name = "account_status")
    private AccountStatus accountStatus;
    public Account(){
        AccountNumber = AccountNumberGenerator.generate();
    }

    public Account(User accountHolder, AccountType accountType, Double balance) {
        AccountNumber = AccountNumberGenerator.generate();
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public User getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(User accountHolder) {
        this.accountHolder = accountHolder;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", AccountNumber='" + AccountNumber + '\'' +
                ", accountHolder=" + accountHolder +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
