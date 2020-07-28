package com.ns.bank.model;

import java.io.Serializable;
import java.util.Date;

public class TransferModel implements Serializable {

    private Long id;
    private CustomerModel customerModel;
    private Long receiverAccountNumber;
    private Double amount;
    private StatusModel statusModel;
    private Date transferDate;

    public TransferModel() {
    }

    public TransferModel(Long id, CustomerModel customerModel, Long receiverAccountNumber, Double amount, StatusModel statusModel, Date transferDate) {
        this.id = id;
        this.customerModel = customerModel;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.statusModel = statusModel;
        this.transferDate = transferDate;
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

    public Long getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(Long receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }
}
