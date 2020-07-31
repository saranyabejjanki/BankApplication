package com.ns.bank.model;

import com.ns.bank.entity.Branch;
import com.ns.bank.entity.Customer;
import com.ns.bank.entity.User;

import java.io.Serializable;
import java.util.Set;

public class AddressModel implements Serializable {
    private Long id;
    private String city;
    private String state;
    private String country;
    private Integer pinCode;
    private String  street;
  /*  private Set<Branch> branches;
    private Set<User> users;
    private Set<Customer> customers;

    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
*/
    public AddressModel() {
    }

    public AddressModel(Long id, String city, String state, String country, Integer pinCode, String street) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.street = street;
    }

    public AddressModel(Long id, String city, String state, String country, Integer pinCode, String street, Set<Branch> branches, Set<User> users, Set<Customer> customers) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.street = street;
        /*this.branches = branches;
        this.users = users;
        this.customers = customers;*/
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

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
