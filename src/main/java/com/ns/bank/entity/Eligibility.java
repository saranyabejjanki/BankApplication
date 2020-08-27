package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Eligibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "eligibilityId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JsonBackReference
    private Set<AccountType> accountTypes;

    @OneToMany(mappedBy = "eligibility",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JsonBackReference
    private Set<LoanType> loanTypes;
    private Integer minAge;
    private Integer maxAge;


    public Eligibility() {
    }

    public Eligibility(Integer id, Set<AccountType> accountTypes, Set<LoanType> loanTypes, Integer minAge, Integer maxAge) {
        this.id = id;
        this.accountTypes = accountTypes;
        this.loanTypes = loanTypes;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<AccountType> getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(Set<AccountType> accountTypes) {
        this.accountTypes = accountTypes;
    }

    public Set<LoanType> getLoanTypes() {
        return loanTypes;
    }

    public void setLoanTypes(Set<LoanType> loanTypes) {
        this.loanTypes = loanTypes;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }
}
