package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;

public class RowStatusModel implements Serializable {

    private Integer id;
    private String name;
   /* private Set<LoanTypeModel> loanTypeModels;
    private Set<UserModel> userModels;
    private Set<BranchModel> branchModels;
*/

    public RowStatusModel() {
    }

    public RowStatusModel(Integer id, String name, Set<LoanTypeModel> loanTypeModels, Set<UserModel> userModels, Set<BranchModel> branchModels) {
        this.id = id;
        this.name = name;
      /*  this.loanTypeModels = loanTypeModels;
        this.userModels = userModels;
        this.branchModels = branchModels;*/
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
/*
    public Set<LoanTypeModel> getLoanTypeModels() {
        return loanTypeModels;
    }

    public void setLoanTypeModels(Set<LoanTypeModel> loanTypeModels) {
        this.loanTypeModels = loanTypeModels;
    }

    public Set<UserModel> getUserModels() {
        return userModels;
    }

    public void setUserModels(Set<UserModel> userModels) {
        this.userModels = userModels;
    }

    public Set<BranchModel> getBranchModels() {
        return branchModels;
    }

    public void setBranchModels(Set<BranchModel> branchModels) {
        this.branchModels = branchModels;
    }*/
}
