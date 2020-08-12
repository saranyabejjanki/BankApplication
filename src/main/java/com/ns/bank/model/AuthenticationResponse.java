package com.ns.bank.model;

public class AuthenticationResponse {
    final  private String jwt;
    private Long userId;
    private String userName;
    private String role;
    private String email;


   public AuthenticationResponse(String jwt, Long userId, String userName, String role, String email) {
        this.jwt = jwt;
        this.userId = userId;
        this.userName = userName;
        this.role = role;
        this.email = email;
    }


   public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
