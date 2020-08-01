package com.ns.bank.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transfer  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer customer;

    private Long receiverAccountNumber;
    private Double amount;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "statusId")
    private Status status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDate;

    public Transfer() {
    }

    public Transfer(Long id, Customer customer, Long receiverAccountNumber, Double amount, Status status, Date transferDate) {
        this.id = id;
        this.customer = customer;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.status = status;
        this.transferDate = transferDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }
}
