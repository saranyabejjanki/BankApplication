package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;


public class EligibilityModel implements Serializable {

    private Integer id;

    //private Set<AccountTypeModel> accountTypeModels;

   // private Set<LoanTypeModel> loanTypeModels;
    private Integer minAge;
    private Integer maxAge;


    public EligibilityModel() {
    }

    public EligibilityModel(Integer id, Integer minAge, Integer maxAge) {
        this.id = id;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
