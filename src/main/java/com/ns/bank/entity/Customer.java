package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer  implements Serializable {

    private Long id;
    private String name;
    private Date dob;
    private Address address;
    private String email;
    private Long accountNo;
    private String password;
    private String confirmPassword;
    private Branch branchName;
    private Status status;
    private Date accountCreatedDate;
    private AccountType accountType;
    private Set<Deposit> deposits;
    private Set<Withdraw> withdraws;
    private Set<Transfer> transfers;
    private Set<Loan> loans;

    public Customer() {
    }

    public Customer(Long id, String name, Date dob, Address address, String email, Long accountNo, String password,
                    String confirmPassword, Branch branchName, Status status, Date accountCreatedDate,
                    AccountType accountType, Set<Deposit> deposits, Set<Withdraw> withdraws, Set<Transfer> transfers,
                    Set<Loan> loans) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.accountNo = accountNo;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.branchName = branchName;
        this.status = status;
        this.accountCreatedDate = accountCreatedDate;
        this.accountType = accountType;
        this.deposits = deposits;
        this.withdraws = withdraws;
        this.transfers = transfers;
        this.loans = loans;
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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDob() {
        return dob;
    }


    public void setDob(Date dob) {
        this.dob = dob;
    }


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "accountNo")
    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

   // @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "branchId")
    public Branch getBranchName() {
        return branchName;
    }

    public void setBranchName(Branch branchName) {
        this.branchName = branchName;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }


    public void setAccountCreatedDate(Date accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "accountTypeId")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
 //   @JsonBackReference

    public Set<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(Set<Deposit> deposits) {
        this.deposits = deposits;
    }
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    //@JsonBackReference
    public Set<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(Set<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    //@JsonBackReference
    public Set<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<Transfer> transfers) {
        this.transfers = transfers;
    }


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }
}
