package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;

public class LoanModel implements Serializable {

    private Long id;
    private CustomerModel customerModel;
    private Double loanAmount;
    private StatusModel statusModel;
    private LoanTypeModel loanTypeModel;

    public LoanModel() {
    }

    public LoanModel(Long id, CustomerModel customerModel, Double loanAmount, StatusModel statusModel, LoanTypeModel loanTypeModel) {
        this.id = id;
        this.customerModel = customerModel;
        this.loanAmount = loanAmount;
        this.statusModel = statusModel;
        this.loanTypeModel = loanTypeModel;
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

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }

    public LoanTypeModel getLoanTypeModel() {
        return loanTypeModel;
    }

    public void setLoanTypeModel(LoanTypeModel loanTypeModel) {
        this.loanTypeModel = loanTypeModel;
    }
}