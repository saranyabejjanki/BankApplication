package com.ns.bank.model;

public class CustomerAuthenticationResponse {
    final  private String jwt;
    private Long accountNo;
    private String customerName;
    private String customerEmail;
    private String role;
    private Long branchCode;

    public CustomerAuthenticationResponse(String jwt, Long accountNo, String customerName, String customerEmail, String role, Long branchCode) {
        this.jwt = jwt;
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.role = role;
        this.branchCode = branchCode;
    }

    public Long getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Long branchCode) {
        this.branchCode = branchCode;
    }

    public String getJwt() {
        return jwt;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
