package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="loan")
public class Loan  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customeId", nullable = false)
    private Customer customer;
    @Column(name = "loanAmount")
    private  Double loanAmount;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "loanTypeId", nullable = false)
    private LoanType loanType;

    public Loan() {
    }

    public Loan(Long id, Customer customer, Double loanAmount, Status status, LoanType loanType) {
        this.id = id;
        this.customer = customer;
        this.loanAmount = loanAmount;
        this.status = status;
        this.loanType = loanType;
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

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

}
