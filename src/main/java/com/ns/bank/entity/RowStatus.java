package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class RowStatus  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "rowStatus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JsonBackReference
    private Set<LoanType> loanTypes;

    @OneToMany(mappedBy = "rowStatus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JsonBackReference
    private Set<User> users;

    @OneToMany(mappedBy = "rowStatus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JsonBackReference
    private Set<Branch> branches;




    public RowStatus() {
    }

    public RowStatus(Integer id, String name, Set<LoanType> loanTypes, Set<User> users, Set<Branch> branches) {
        this.id = id;
        this.name = name;
        this.loanTypes = loanTypes;
        this.users = users;
        this.branches = branches;
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

    public Set<LoanType> getLoanTypes() {
        return loanTypes;
    }

    public void setLoanTypes(Set<LoanType> loanTypes) {
        this.loanTypes = loanTypes;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }
}
