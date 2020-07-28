package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Withdraw> withdraws;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Transfer> transfers;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Deposit> deposits;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Complaint> complaints;
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Loan> loans;

    public Status() {
    }

    public Status(Integer id, String name, Set<Withdraw> withdraws, Set<Transfer> transfers, Set<Deposit> deposits, Set<Complaint> complaints, Set<Loan> loans) {
        this.id = id;
        this.name = name;
        this.withdraws = withdraws;
        this.transfers = transfers;
        this.deposits = deposits;
        this.complaints = complaints;
        this.loans = loans;
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

    public Set<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(Set<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }

    public Set<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Set<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(Set<Deposit> deposits) {
        this.deposits = deposits;
    }

    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }
}