package com.fas.admin.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddUser {

    @NotNull
    private Long adminId;
    @NotNull
    @Length(min = 8, max = 16, message = "Username should be of length b/w 6 and 16")
    private String username;
    @NotNull
    @Length(min = 8, max = 16, message = "Password should be of length b/w 6 and 16")
    private String password;
    @NotNull
    private String userType;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
