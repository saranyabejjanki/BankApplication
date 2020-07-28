package com.ns.bank.model;

import java.io.Serializable;

public class AddressModel implements Serializable {
    private Long id;
    private String city;
    private String state;
    private String country;
    private Integer pinCode;
    private String  street;


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
