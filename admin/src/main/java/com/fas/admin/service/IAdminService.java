package com.fas.admin.service;

import com.fas.admin.dtos.AddUser;
import com.fas.admin.dtos.ChangePasswordRequest;
import com.fas.admin.dtos.LoginCredentials;
import com.fas.admin.dtos.UserDetails;
import com.fas.admin.entities.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * Interface of service layer for database of the module
 *
 * @author Prateek singh
 */

@Validated
@Service
public interface IAdminService {
    /**
     * @param loginCredentials;
     * @return User
     * @implNote To check validity of logged in credentials
     */
    User loginWithCredentials(@Valid LoginCredentials loginCredentials);

    /**
     * @param username;
     * @return User
     * @implNote To logout user
     */
    User logout(@Length(min = 6, max = 16, message = "Username should be of length b/w 6 and 16") String username);

    /**
     * @param changPasswordRequest ;
     * @return User
     * @implNote To request password change request
     */
    User changePassword(@Valid ChangePasswordRequest changPasswordRequest);

    /**
     * @param addUser;
     * @return User
     * @implNote To add new users to database
     */
    User addUser(@Valid AddUser addUser);

    /**
     * @param username;
     * @return UserDetails
     * @implNote To add new users to database
     */
    UserDetails getUserDetails(@Length(min = 6, max = 16, message = "Username should be of length b/w 6 and 16") String username);

    void deleteUser(String username);
}
