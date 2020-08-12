package com.ns.bank.model;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class UserModel  implements Serializable{

    private Long id;
    private String name;
    private Long phone;
    private String email;
    private String password;
    private String gender;
    private Date createdDate;
    private AddressModel addressModel;
    private BranchModel branchModel;
    private RoleModel roleModel;
    private RowStatusModel rowStatusModel;

    public UserModel() {
    }

    public UserModel(Long id, String name, String password,Long phone, String email, String gender, RoleModel roleModel, RowStatusModel rowStatusModel) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.password=password;
        this.roleModel = roleModel;
        this.rowStatusModel = rowStatusModel;
    }

    public UserModel(Long id, String name, Date createdDate, Long phone, String email, String password, String gender,
                     AddressModel addressModel,
                     BranchModel branchModel, RoleModel roleModel, RowStatusModel rowStatusModel) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.addressModel = addressModel;
        this.branchModel = branchModel;
        this.roleModel = roleModel;
        this.rowStatusModel = rowStatusModel;
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

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public BranchModel getBranchModel() {
        return branchModel;
    }

    public void setBranchModel(BranchModel branchModel) {
        this.branchModel = branchModel;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public RowStatusModel getRowStatusModel() {
        return rowStatusModel;
    }

    public void setRowStatusModel(RowStatusModel rowStatusModel) {
        this.rowStatusModel = rowStatusModel;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", createdDate=" + createdDate +
                ", addressModel=" + addressModel +
                ", branchModel=" + branchModel +
                ", roleModel=" + roleModel +
                ", rowStatusModel=" + rowStatusModel +
                '}';
    }
}
