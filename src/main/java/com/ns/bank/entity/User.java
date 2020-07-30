package com.ns.bank.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long phone;
    private String email;
    private String password;
    private String gender;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "addressId")
    private Address address;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "branchId")
    private Branch branch;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rowStatusId")
    private RowStatus rowStatus;

    public User() {
    }

    public User(Long id, String name,Date createdDate, Long phone, String email, String password, String gender,
                Address address,
                Branch branch, Role role, RowStatus rowStatus) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.branch = branch;
        this.role = role;
        this.rowStatus = rowStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public RowStatus getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatus rowStatus) {
        this.rowStatus = rowStatus;
    }
}
