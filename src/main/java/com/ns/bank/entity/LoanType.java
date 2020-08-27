package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class LoanType  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double interest;
    private Integer months;

    @ManyToOne()
    @JoinColumn(name = "eligibilityId")
    private Eligibility eligibility;

    private Double minAmount;
    private Double maxAmount;

    @ManyToOne()
    @JoinColumn(name = "rowStatusId")
    private RowStatus rowStatus;

    @OneToMany(mappedBy = "loanType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonBackReference
    private Set<Loan> loans;

    @ManyToOne()
    @JoinColumn(name = "accountTypeId")
    private AccountType accountType;


    public LoanType() {
    }

    public LoanType(Integer id, String name, Double interest, Integer months, Eligibility eligibility, Double minAmount, Double maxAmount, RowStatus rowStatus, Set<Loan> loans, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.months = months;
        this.eligibility = eligibility;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.rowStatus = rowStatus;
        this.loans = loans;
        this.accountType = accountType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Eligibility getEligibility() {
        return eligibility;
    }

    public void setEligibility(Eligibility eligibility) {
        this.eligibility = eligibility;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public RowStatus getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatus rowStatus) {
        this.rowStatus = rowStatus;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}