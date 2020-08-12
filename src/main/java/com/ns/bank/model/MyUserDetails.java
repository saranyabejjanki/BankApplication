package com.ns.bank.model;

import com.ns.bank.entity.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private UserModel userModel;

    private Long id;
    private String name;
    private String role;
    private Long branchCode;


    private Collection<? extends GrantedAuthority> authorities;

    public MyUserDetails(UserModel userModel) {
        this.userModel = userModel;
    }

    public MyUserDetails(UserModel userModel, Long id, String name, Collection<? extends GrantedAuthority> authorities) {
        this.userModel = userModel;
        this.id = id;
        this.name = name;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userModel.getRoleModel().getName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return userModel.getPassword();
    }

    @Override
    public String getUsername() {
        return userModel.getEmail();
    }

    public Long getId() {
        return userModel.getId();
    }

    public String getName() {
        return userModel.getName();
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public String getRole() {
        return userModel.getRoleModel().getName();
    }

    public Long getBranchCode() {
        return userModel.getBranchModel().getBranchCode();
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