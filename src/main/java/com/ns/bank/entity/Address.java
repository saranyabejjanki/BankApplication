package com.ns.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="address")
public class Address  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "pinCode")
    private Integer pinCode;
    @Column(name = "street")
    private String  street;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "address")
    private Set<Branch> branches;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "address")
    private Set<User> users;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "address")
    private Set<Customer> customers;

    public Address() {
    }

    public Address(Long id, String city, String state, String country, Integer pinCode, String street) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    //@JsonBackReference
    public Set<Branch> getBranches() {
        return branches;
    }


   // @JsonBackReference
    public Set<User> getUsers() {
        return users;
    }

    //@JsonBackReference

    public Set<Customer> getCustomers() {
        return customers;
    }
}
