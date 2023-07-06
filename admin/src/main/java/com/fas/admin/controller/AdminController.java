package com.fas.admin.controller;

import com.fas.admin.dtos.AddUser;
import com.fas.admin.dtos.ChangePasswordRequest;
import com.fas.admin.dtos.LoginCredentials;
import com.fas.admin.dtos.UserDetails;
import com.fas.admin.entities.User;
import com.fas.admin.service.IAdminService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/admins")
@Validated
public class AdminController {
    @Autowired
    private IAdminService service;

    /*
     * @url admins/login
     * @param loginCredentials
     * @return string
     * @implNot login request with credentials
     */
    @PostMapping("/login")
    public User login(@Valid @RequestBody LoginCredentials loginCredentials) {
        return service.loginWithCredentials(loginCredentials);
    }

    /*
     * @url admins/logout
     * @param username
     * @return user
     * @implNot logout request with username
     */
    @GetMapping("/logout/{username}")
    public User logout(@Length(min = 6, max = 16, message = "Username should be of length b/w 6 and 16") @PathVariable String username) {
        return service.logout(username);
    }

    /*
     * @url admins/changePassword
     * @param username
     * @return user
     * @implNot change password request from username
     */
    @PostMapping("/changePassword")
    public User changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        return service.changePassword(changePasswordRequest);
    }

    /*
     * @url admins/addUSer
     * @param addUser
     * @return user
     * @implNot to add user to database
     */

    @DeleteMapping("/delete/{username}")
    public void deleteUser(@Length(min = 6, max = 16, message = "Username should be of length b/w 6 and 16") @PathVariable String username) {
        service.deleteUser(username);
    }

    /*
     * @url admins/addUSer
     * @param addUser
     * @return user
     * @implNot to add user to database
     */
    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody AddUser addUser) {
        return service.addUser(addUser);
    }

    /*
     * @url admins/getUserDetails
     * @param username
     * @return UserDetails
     * @implNot to get user details of username
     */
    @GetMapping("/getUserDetails/{username}")
    public UserDetails getUser(@PathVariable String username) {
        return service.getUserDetails(username);
    }


}
