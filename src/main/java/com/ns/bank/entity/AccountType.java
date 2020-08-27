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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "interest")
    private Float interest;
    @Column(name = "minBalance")
    private Double minBalance;
    @Column(name = "withdrawLimit")
    private Double withdrawLimit;
    @Column(name = "transactionLimit")
    private Integer transactionLimit;
    @ManyToOne()
    @JoinColumn(name = "eligibilityId")
    private Eligibility eligibilityId;
    @OneToMany(mappedBy = "accountType",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public Double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(Double minBalance) {
        this.minBalance = minBalance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }


    public Integer getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(Integer transactionLimit) {
        this.transactionLimit = transactionLimit;
    }



    public Eligibility getEligibilityId() {
        return eligibilityId;
    }

    public void setEligibilityId(Eligibility eligibilityId) {
        this.eligibilityId = eligibilityId;
    }


    public Set<LoanType> getLoanTypes() {
        return loanTypes;
    }

    public void setLoanTypes(Set<LoanType> loanTypes) {
        this.loanTypes = loanTypes;
    }
}
