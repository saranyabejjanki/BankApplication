package com.ns.bank.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
public class Address  implements Serializable {
    private Long id;
    private String city;
    private String state;
    private String country;
    private Integer pinCode;
    private String  street;


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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }
    @Column(name = "pinCode")
    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
