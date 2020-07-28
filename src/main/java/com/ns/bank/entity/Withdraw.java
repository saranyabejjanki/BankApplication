package com.ns.bank.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "withdraw")
public class Withdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customerId")
    private Customer customer;

    private Double withdrawAmount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date withdrawDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "statusId")
    private Status status;

    public Withdraw() {
    }

    public Withdraw(Long id, Customer customer, Double withdrawAmount, Date withdrawDate, Status status) {
        this.id = id;
        this.customer = customer;
        this.withdrawAmount = withdrawAmount;
        this.withdrawDate = withdrawDate;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}