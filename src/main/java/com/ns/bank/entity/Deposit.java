package com.ns.bank.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="deposit")
public class Deposit  implements Serializable {


    private Long id;
    private Double depositAmount;
    private Status status;
    private Date transactionDate;
    private Customer customer;


    public Deposit() {
    }

    public Deposit(Long id, Double depositAmount, Status status, Date transactionDate, Customer customer) {
        this.id = id;
        this.depositAmount = depositAmount;
        this.status = status;
        this.transactionDate = transactionDate;
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name="depositAmount")
    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }


    @Temporal(TemporalType.TIMESTAMP)
    public Date getTransactionDate() {
        return transactionDate;
    }
    @CreationTimestamp
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name="statusId")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name="customerId")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
