package com.ns.bank.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="accountType")
public class AccountType  implements Serializable {

    private Long id;
    private String name;
    private Float interest;
    private Double minBalance;
    private Double withdrawLimit;
    private Integer transactionLimit;
    private Eligibility eligibility;


    public AccountType() {
    }


    public AccountType(Long id, String name, Float interest, Double minBalance, Double withdrawLimit, Integer transactionLimit, Eligibility eligibility) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.minBalance = minBalance;
        this.withdrawLimit = withdrawLimit;
        this.transactionLimit = transactionLimit;
        this.eligibility = eligibility;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "interest")
    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }
    @Column(name = "minBalance")
    public Double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(Double minBalance) {
        this.minBalance = minBalance;
    }
    @Column(name = "withdrawLimit")
    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    @Column(name = "transactionLimit")
    public Integer getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(Integer transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "eligibilityId")
    public Eligibility getEligibility() {
        return eligibility;
    }

    public void setEligibility(Eligibility eligibility) {
        this.eligibility = eligibility;
    }
}
