package com.ns.bank.model;

import java.io.Serializable;
import java.util.Set;


public class RoleModel implements Serializable {

    private Integer id;
    private String name;
    private Set<UserModel> userModels;

    public RoleModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserModel> getUserModels() {
        return userModels;
    }

    public void setUserModels(Set<UserModel> userModels) {
        this.userModels = userModels;
    }

    public RoleModel(Integer id, String name, Set<UserModel> userModels) {
        this.id = id;
        this.name = name;
        this.userModels = userModels;
    }
}
