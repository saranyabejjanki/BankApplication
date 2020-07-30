package com.ns.bank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


public class BranchModel implements Serializable {

    private Long branchCode;
    private String name;
    private AddressModel addressModel;
    private Set<UserModel> userModels;
    private Long phoneNo;
    private Set<CustomerModel> customerModels;
    private Date createdDate;
    private RowStatusModel rowStatusModel;

    public BranchModel() {
    }


    public BranchModel(Long branchCode, String name, AddressModel addressModel, Set<UserModel> userModels, Long phoneNo, Set<CustomerModel> customerModels, Date createdDate, RowStatusModel rowStatusModel) {
        this.branchCode = branchCode;
        this.name = name;
        this.addressModel = addressModel;
        this.userModels = userModels;
        this.phoneNo = phoneNo;
        this.customerModels = customerModels;
        this.createdDate = createdDate;
        this.rowStatusModel = rowStatusModel;
    }

    public Long getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Long branchCode) {
        this.branchCode = branchCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public Set<UserModel> getUserModels() {
        return userModels;
    }

    public void setUserModels(Set<UserModel> userModels) {
        this.userModels = userModels;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Set<CustomerModel> getCustomerModels() {
        return customerModels;
    }

    public void setCustomerModels(Set<CustomerModel> customerModels) {
        this.customerModels = customerModels;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public RowStatusModel getRowStatusModel() {
        return rowStatusModel;
    }

    public void setRowStatusModel(RowStatusModel rowStatusModel) {
        this.rowStatusModel = rowStatusModel;
    }
}