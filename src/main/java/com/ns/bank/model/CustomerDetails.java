package com.ns.bank.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerDetails implements UserDetails {
    private CustomerModel customerModel;
    private Long accountNo;
    private  String customerName;
    private Long customerBranchCode;
    private String password;
    private String email;
    private String role;

    private Boolean customer;

    public CustomerDetails(CustomerModel customerModel, Long accountNo, String customerName, Long customerBranchCode) {
        this.customerModel = customerModel;
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.customerBranchCode = customerBranchCode;
    }

    public CustomerDetails(Long accountNo, String customerName, Long customerBranchCode,String password,String email,String role) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.customerBranchCode = customerBranchCode;
        this.password=password;
        this.email=email;
        this.customer=customer;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public CustomerDetails(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public Long getAccountNo() {
        return customerModel.getAccountNo();
    }

    public CustomerDetails() {
    }

    public String getCustomerName() {
        return  customerModel.getName();
    }

    public Long getCustomerBranchCode() {
        return customerBranchCode;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return customerModel.getPassword();
    }

    @Override
    public String getUsername() {
        return customerModel.getEmail();
    }
    public Boolean getCustomer() {
        return customer;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
