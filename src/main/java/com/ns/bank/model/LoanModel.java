package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;

public class LoanModel implements Serializable {

    private Long id;
    private Set<CustomerModel> customerModels;
    private  Double loanAmount;
    private StatusModel statusModel;
    private LoanTypeModel loanTypeModel;

    public LoanModel() {
    }

    public LoanModel(Long id, Set<CustomerModel> customerModels, Double loanAmount, StatusModel statusModel, LoanTypeModel loanTypeModel) {
        this.id = id;
        this.customerModels = customerModels;
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

    public Set<CustomerModel> getCustomerModels() {
        return customerModels;
    }

    public void setCustomerModels(Set<CustomerModel> customerModels) {
        this.customerModels = customerModels;
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
