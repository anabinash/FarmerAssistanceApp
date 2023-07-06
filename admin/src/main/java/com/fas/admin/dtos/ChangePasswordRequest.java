package com.fas.admin.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ChangePasswordRequest {
    @NotNull
    @Length(min = 6, max = 16, message = "Username should be of length b/w 6 and 16")
    private String username;
    @NotNull
    @Length(min = 8, max = 16, message = "Password should be of length b/w 6 and 16")
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
