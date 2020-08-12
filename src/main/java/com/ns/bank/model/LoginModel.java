package com.ns.bank.model;

public class LoginModel {
    private String email;
    private String password;
    private Boolean customer;

    public LoginModel() {
    }

    public LoginModel(String email, String password, Boolean  customer) {
        this.email = email;
        this.password = password;
        this.customer = customer;
    }

    public Boolean getCustomer() {
        return customer;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
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
}
