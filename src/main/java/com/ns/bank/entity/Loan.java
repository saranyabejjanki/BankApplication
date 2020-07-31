package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="loan")
public class Loan  implements Serializable {

    private Long id;
    private Customer customer;
    private  Double loanAmount;
    private Status status;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "customeId", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Column(name = "loanAmount")
    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "loanTypeId", nullable = false)
    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

}
