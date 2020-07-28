package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;


public class EligibilityModel implements Serializable {

    private Integer id;

    private Set<AccountTypeModel> accountTypeModels;

    private Set<LoanTypeModel> loanTypeModels;
    private Integer minAge;
    private Integer maxAge;


    public EligibilityModel() {
    }

    public EligibilityModel(Integer id, Set<AccountTypeModel> accountTypeModels, Set<LoanTypeModel> loanTypeModels, Integer minAge, Integer maxAge) {
        this.id = id;
        this.accountTypeModels = accountTypeModels;
        this.loanTypeModels = loanTypeModels;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<AccountTypeModel> getAccountTypeModels() {
        return accountTypeModels;
    }

    public void setAccountTypeModels(Set<AccountTypeModel> accountTypeModels) {
        this.accountTypeModels = accountTypeModels;
    }

    public Set<LoanTypeModel> getLoanTypeModels() {
        return loanTypeModels;
    }

    public void setLoanTypeModels(Set<LoanTypeModel> loanTypeModels) {
        this.loanTypeModels = loanTypeModels;
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
