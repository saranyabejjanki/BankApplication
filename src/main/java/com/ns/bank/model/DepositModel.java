package com.ns.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class DepositModel implements Serializable {
    private Long id;
    private Double depositAmount;
    private StatusModel statusModel;
    private Date transactionDate;
    private CustomerModel customerModel;


    public DepositModel() {
    }

    public DepositModel(Long id, Double depositAmount, StatusModel statusModel, Date transactionDate, CustomerModel customerModel) {
        this.id = id;
        this.depositAmount = depositAmount;
        this.statusModel = statusModel;
        this.transactionDate = transactionDate;
        this.customerModel = customerModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    @Override
    public String toString() {
        return "DepositModel{" +
                "id=" + id +
                ", depositAmount=" + depositAmount +
                ", statusModel=" + statusModel +
                ", transactionDate=" + transactionDate +
                ", customerModel=" + customerModel +
                '}';
    }
}