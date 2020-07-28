package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="branch")
public class Branch  implements Serializable {

    private Long branchCode;
    private String name;
    private Address address;
    private Set<User> users;
    private Long phoneNo;
    private Set<Customer> customers;
    private Date createdDate;
    private RowStatus rowStatus;



    public Branch() {
    }

    public Branch(Long branchCode, String name, Address address, Set<User> users, Long phoneNo, Set<Customer> customers, Date createdDate, RowStatus rowStatus) {
        this.branchCode = branchCode;
        this.name = name;
        this.address = address;
        this.users = users;
        this.phoneNo = phoneNo;
        this.customers = customers;
        this.createdDate = createdDate;
        this.rowStatus = rowStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getBranchCode() {
        return branchCode;
    }

    public void setBranchCode( Long branchCode) {
        this.branchCode = branchCode;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "branch")
    @JsonBackReference
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column(name = "phoneNo")
    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "branch")
    @JsonBackReference
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDate")
    public Date getCreatedDate() {
        return createdDate;
    }

    @CreationTimestamp
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "rowStatusID")
    public RowStatus getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatus rowStatus) {
        this.rowStatus = rowStatus;
    }
}
