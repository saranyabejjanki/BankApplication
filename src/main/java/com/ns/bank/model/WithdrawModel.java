package com.ns.bank.model;

import java.io.Serializable;
import java.util.Date;

public class WithdrawModel implements Serializable {

    private Long id;
    private CustomerModel customerModel;
    private Double withdrawAmount;
    private Date withdrawDate;
    private StatusModel statusModel;

    public WithdrawModel() {
    }

    public WithdrawModel(Long id, CustomerModel customerModel, Double withdrawAmount, Date withdrawDate, StatusModel statusModel) {
        this.id = id;
        this.customerModel = customerModel;
        this.withdrawAmount = withdrawAmount;
        this.withdrawDate = withdrawDate;
        this.statusModel = statusModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public Double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public Date getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(Date withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }
}