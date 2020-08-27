package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@SequenceGenerator(
        name="accountNumberGenerator",
        initialValue=11111,allocationSize=1
)

@JsonIgnoreProperties({"deposits","withdraws","transfers","loans","complaints"})
@Entity
@Table(name="customer")
public class Customer  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "accountNumberGenerator")
    private Long accountNo;
    @Column(name = "name")
    private String name;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @ManyToOne()
    @JoinColumn(name = "addressId")
    private Address address;
    private String email;
    private String password;
    @ManyToOne()
    @JoinColumn(name = "branchId")
    private Branch branchName;
    @ManyToOne()
    @JoinColumn(name = "statusId")
    private Status status;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date accountCreatedDate;
    @ManyToOne()
    @JoinColumn(name = "accountTypeId")
    private AccountType accountType;

    @JsonProperty("deposits")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Deposit> deposits;
    @JsonProperty("withdraws")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Withdraw> withdraws;
    @JsonProperty("transfers")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Transfer> transfers;
    @JsonProperty("loans")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Loan> loans;
    @JsonProperty("complaints")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Complaint> complaints;

    private Double balance;

    public Customer() {
    }

    public Customer( String name, Date dob, Address address, String email, Long accountNo, String password, Branch branchName, Status status, Date accountCreatedDate,
                    AccountType accountType, Set<Deposit> deposits, Set<Withdraw> withdraws, Set<Transfer> transfers,
                    Set<Loan> loans,Set<Complaint>complaints,Double balance){

        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.accountNo = accountNo;
        this.password = password;

        this.branchName = branchName;
        this.status = status;
        this.accountCreatedDate = accountCreatedDate;
        this.accountType = accountType;
        this.deposits = deposits;
        this.withdraws = withdraws;
        this.transfers = transfers;
        this.loans = loans;
        this.complaints=complaints;
        this.balance=balance;

    }


    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getDob() {
        return dob;
    }


    public void setDob(Date dob) {
        this.dob = dob;
    }


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


    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   // @JsonManagedReference

    public Branch getBranchName() {
        return branchName;
    }

    public void setBranchName(Branch branchName) {
        this.branchName = branchName;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }


    public void setAccountCreatedDate(Date accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Set<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(Set<Deposit> deposits) {
        this.deposits = deposits;
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


    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }


    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;}

    @Column(name = "balance")
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
