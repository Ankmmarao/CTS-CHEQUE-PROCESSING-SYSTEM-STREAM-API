package com.iispl.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.iispl.enums.AccountStatus;
import com.iispl.enums.ChequeType;
import com.iispl.enums.MicrStatus;
import com.iispl.enums.ValidationStatus;

public class Cheque {

    private int chequeId;
    private String chequeNumber;
    private String accountNumber;
    private String customerName;
    private String branchCode;
    private String micrCode;
    private double amount;
    private double availableBalance;
    private LocalDate chequeDate;
    private AccountStatus accountStatus;
    private ChequeType chequeType;
    private MicrStatus micrStatus;
    private ValidationStatus validationStatus;
    private int batchId;

    // Parameterized Constructor
    public Cheque(int chequeId, String chequeNumber, String accountNumber, String customerName,
                  String branchCode, String micrCode, double amount, double availableBalance,
                  LocalDate chequeDate, AccountStatus accountStatus, ChequeType chequeType,
                  MicrStatus micrStatus, ValidationStatus validationStatus, int batchId) {

        super();

        this.chequeId = chequeId;
        this.chequeNumber = chequeNumber;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.branchCode = branchCode;
        this.micrCode = micrCode;
        this.amount = amount;
        this.availableBalance = availableBalance;
        this.chequeDate = chequeDate;
        this.accountStatus = accountStatus;
        this.chequeType = chequeType;
        this.micrStatus = micrStatus;
        this.validationStatus = validationStatus;
        this.batchId = batchId;
    }

    // Default Constructor
    public Cheque() {
        // TODO Auto-generated constructor stub
    }

    // Getter and Setter for chequeId
    public int getChequeId() {
        return chequeId;
    }

    public void setChequeId(int chequeId) {
        this.chequeId = chequeId;
    }

    // Getter and Setter for chequeNumber
    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    // Getter and Setter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter and Setter for customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter and Setter for branchCode
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    // Getter and Setter for micrCode
    public String getMicrCode() {
        return micrCode;
    }

    public void setMicrCode(String micrCode) {
        this.micrCode = micrCode;
    }

    // Getter and Setter for amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter and Setter for availableBalance
    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    // Getter and Setter for chequeDate
    public LocalDate getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(LocalDate chequeDate) {
        this.chequeDate = chequeDate;
    }

    // Getter and Setter for accountStatus
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    // Getter and Setter for chequeType
    public ChequeType getChequeType() {
        return chequeType;
    }

    public void setChequeType(ChequeType chequeType) {
        this.chequeType = chequeType;
    }

    // Getter and Setter for micrStatus
    public MicrStatus getMicrStatus() {
        return micrStatus;
    }

    public void setMicrStatus(MicrStatus micrStatus) {
        this.micrStatus = micrStatus;
    }

    // Getter and Setter for validationStatus
    public ValidationStatus getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(ValidationStatus validationStatus) {
        this.validationStatus = validationStatus;
    }

    // Getter and Setter for batchId
    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    // toString()
    @Override
    public String toString() {
        return "Cheque [chequeId=" + chequeId
                + ", chequeNumber=" + chequeNumber
                + ", accountNumber=" + accountNumber
                + ", customerName=" + customerName
                + ", branchCode=" + branchCode
                + ", micrCode=" + micrCode
                + ", amount=" + amount
                + ", availableBalance=" + availableBalance
                + ", chequeDate=" + chequeDate
                + ", accountStatus=" + accountStatus
                + ", chequeType=" + chequeType
                + ", micrStatus=" + micrStatus
                + ", validationStatus=" + validationStatus
                + ", batchId=" + batchId + "]";
    }
}