package com.ns.bank.model;

import java.io.Serializable;


public class AccountTypeModel implements Serializable {

    private Long id;
    private String name;
    private Float interest;
    private Double minBalance;
    private Double withdrawLimit;
    private Integer transactionLimit;
    private EligibilityModel eligibilityModel;


    public AccountTypeModel() {
    }


    public AccountTypeModel(Long id, String name, Float interest, Double minBalance, Double withdrawLimit, Integer transactionLimit, EligibilityModel eligibilityModel) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.minBalance = minBalance;
        this.withdrawLimit = withdrawLimit;
        this.transactionLimit = transactionLimit;
        this.eligibilityModel = eligibilityModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public Double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(Double minBalance) {
        this.minBalance = minBalance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(Integer transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public EligibilityModel getEligibilityModel() {
        return eligibilityModel;
    }

    public void setEligibilityModel(EligibilityModel eligibilityModel) {
        this.eligibilityModel = eligibilityModel;
    }
}
