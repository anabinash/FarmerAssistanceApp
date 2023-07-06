package com.fas.admin.service;

import com.fas.admin.constants.UserType;
import com.fas.admin.dtos.AddUser;
import com.fas.admin.dtos.ChangePasswordRequest;
import com.fas.admin.dtos.LoginCredentials;
import com.fas.admin.dtos.UserDetails;
import com.fas.admin.entities.User;
import com.fas.admin.exceptions.AdminNotLoggedInException;
import com.fas.admin.exceptions.InvalidPasswordException;
import com.fas.admin.exceptions.UserNotFoundException;
import com.fas.admin.exceptions.UsernameAlreadyExistsException;
import com.fas.admin.repository.IAdminRepository;
import com.fas.admin.utilites.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Main Service class implementation for database repository of the module
 *
 * @author singh
 */
@Transactional
@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminRepository repository;
    @Autowired
    private AdminUtil adminUtil;

    /**
     * @param loginCredentials;
     * @return User
     * @throws UserNotFoundException, InvalidPassword
     * @implNote To check validity of logged in credentials
     */
    @Override
    public User loginWithCredentials(LoginCredentials loginCredentials) {
        List<User> usersList = repository.getUserWithUsername(loginCredentials.getUsername());
        if (usersList.isEmpty())
            throw new UserNotFoundException("No user found for username: " + loginCredentials.getUsername());
        usersList = repository.getUserWithCredentials(loginCredentials.getUsername(), loginCredentials.getPassword());
        if (usersList.isEmpty())
            throw new InvalidPasswordException("The password does not match for username: " + loginCredentials.getUsername());
        User user = usersList.get(0);
        user.setLoggedIn(Boolean.TRUE);
        return repository.save(user);
    }

    /**
     * @param username;
     * @return User
     * @implNote To logout user
     */
    @Override
    public User logout(String username) {
        List<User> usersList = repository.getUserWithUsername(username);
        if (usersList.isEmpty())
            throw new UserNotFoundException("No user found for username: " + username);
        User user = usersList.get(0);
        user.setLoggedIn(Boolean.FALSE);
        return repository.save(user);
    }

    /**
     * @param changPasswordRequest ;
     * @return User
     * @implNote To request password change request
     */
    @Override
    public User changePassword(ChangePasswordRequest changPasswordRequest) {
        List<User> usersList = repository.getUserWithUsername(changPasswordRequest.getUsername());
        if (usersList.isEmpty())
            throw new UserNotFoundException("No user found for username: " + changPasswordRequest.getUsername());
        User user = usersList.get(0);
        user.setPassword(changPasswordRequest.getNewPassword());
        return repository.save(user);
    }

    /**
     * @param addUser;
     * @return User
     * @implNote To add new users to database
     */
    @Override
    public User addUser(AddUser addUser) {

        if (adminUtil.getUserType(addUser.getUserType()) != UserType.ADMIN) {
            Optional<User> userOptional = repository.findById(addUser.getAdminId());
            if (!userOptional.isPresent())
                throw new UserNotFoundException("No admin user found for id: " + addUser.getAdminId());
            User adminUser = userOptional.get();
            if (Boolean.FALSE.equals(adminUser.getLoggedIn()))
                throw new AdminNotLoggedInException("Admin not logged in for id: " + adminUser.getId());
        }
        User user = new User();
        user.setUsername(addUser.getUsername());
        List<User> userList = repository.getUserWithUsername(addUser.getUsername());
        if (!userList.isEmpty())
            throw new UsernameAlreadyExistsException("The username already exists: " + addUser.getUsername());

        user.setPassword(addUser.getPassword());
        UserType userType = adminUtil.getUserType(addUser.getUserType());
        user.setType(userType);
        user.setLoggedIn(Boolean.FALSE);
        return repository.save(user);

    }

    @Override
    public UserDetails getUserDetails(String username) {
        List<User> usersList = repository.getUserWithUsername(username);
        if (usersList.isEmpty())
            throw new UserNotFoundException("No user found for username: " + username);
        User user = usersList.get(0);
        UserDetails userDetails = new UserDetails();
        userDetails.setId(user.getId());
        userDetails.setUsername(user.getUsername());
        userDetails.setUserType(user.getType().toString());
        userDetails.setLoggedIn(user.getLoggedIn());
        return userDetails;
    }

    @Override
    public void deleteUser(String username) {
        UserDetails userDetails = getUserDetails(username);
        repository.deleteById(userDetails.getId());
    }
}
