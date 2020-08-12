package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="accountType")
public class AccountType  implements Serializable {

    private Long id;
    private String name;
    private Float interest;
    private Double minBalance;
    private Double withdrawLimit;
    private Integer transactionLimit;
    private Eligibility eligibilityId;
    private Set<LoanType> loanTypes;

    public AccountType() {
    }


    public AccountType(Long id, String name, Set<LoanType> loanTypes,Float interest, Double minBalance,
                       Double withdrawLimit,
                       Integer transactionLimit, Eligibility eligibilityId) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.minBalance = minBalance;
        this.withdrawLimit = withdrawLimit;
        this.transactionLimit = transactionLimit;
        this.eligibilityId = eligibilityId;
        this.loanTypes = loanTypes;
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


    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "eligibilityId")
    public Eligibility getEligibilityId() {
        return eligibilityId;
    }

    public void setEligibilityId(Eligibility eligibilityId) {
        this.eligibilityId = eligibilityId;
    }

    @OneToMany(mappedBy = "accountType",cascade=CascadeType.ALL,fetch = FetchType.LAZY)

    public Set<LoanType> getLoanTypes() {
        return loanTypes;
    }

    public void setLoanTypes(Set<LoanType> loanTypes) {
        this.loanTypes = loanTypes;
    }
}
