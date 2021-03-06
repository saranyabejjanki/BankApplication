package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;

public class LoanTypeModel implements Serializable {

    private Integer id;
    private String name;
    private Double interest;
    private Integer months;
    private EligibilityModel eligibilityModel;
    private Double minAmount;
    private Double maxAmount;
    private RowStatusModel rowStatusModel;
   // private Set<LoanModel> loanModels;
    private AccountTypeModel accountTypeModel;


    public LoanTypeModel() {
    }

    public LoanTypeModel(Integer id, String name, Double interest, Integer months, EligibilityModel eligibilityModel, Double minAmount, Double maxAmount, RowStatusModel rowStatusModel, AccountTypeModel accountTypeModel) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.months = months;
        this.eligibilityModel = eligibilityModel;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.rowStatusModel = rowStatusModel;
        this.accountTypeModel = accountTypeModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public EligibilityModel getEligibilityModel() {
        return eligibilityModel;
    }

    public void setEligibilityModel(EligibilityModel eligibilityModel) {
        this.eligibilityModel = eligibilityModel;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public RowStatusModel getRowStatusModel() {
        return rowStatusModel;
    }

    public void setRowStatusModel(RowStatusModel rowStatusModel) {
        this.rowStatusModel = rowStatusModel;
    }

    public AccountTypeModel getAccountTypeModel() {
        return accountTypeModel;
    }

    public void setAccountTypeModel(AccountTypeModel accountTypeModel) {
        this.accountTypeModel = accountTypeModel;
    }
}

