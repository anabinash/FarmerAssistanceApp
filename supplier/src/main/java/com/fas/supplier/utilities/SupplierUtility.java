package com.fas.supplier.utilities;

import com.fas.supplier.dtos.*;
import com.fas.supplier.exceptions.InvalidUserTypeException;
import com.fas.supplier.exceptions.SupplierLoggedOutException;
import com.fas.supplier.exceptions.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SupplierUtility {


    @Value("${admins.baseUrl}")
    private String baseAdminsUrl;

    @Autowired
    private RestTemplate restTemplate;

    public User sendLoginRequest(LoginCredentials loginCredentials) {
        String url = baseAdminsUrl + "/login";
        ResponseEntity<User> result = restTemplate.postForEntity(url, loginCredentials, User.class);
        return result.getBody();
    }

    public User sendLogoutRequest(String username) {
        String url = baseAdminsUrl + "/logout/" + username;
        return restTemplate.getForEntity(url, User.class).getBody();
    }


    public User sendChangePasswordRequest(ChangePasswordRequest changePasswordRequest) {
        String url = baseAdminsUrl + "/changePassword";
        ResponseEntity<User> result = restTemplate.postForEntity(url, changePasswordRequest, User.class);
        return result.getBody();
    }

    public UserDetails getUserDetails(String username) {
        String url = baseAdminsUrl + "/getUserDetails/" + username;
        ResponseEntity<UserDetails> result = restTemplate.getForEntity(url, UserDetails.class);
        return result.getBody();
    }

    public UserType getUserType(String userType) {
        for (UserType type : UserType.values())
            if (userType.equals(type.toString()))
                return type;
        throw new InvalidUserTypeException("Invalid User Type: " + userType);
    }

    public void isUserSupplier(UserDetails userDetails) {
        UserType userType = getUserType(userDetails.getUserType());
        if (userType != UserType.SUPPLIER)
            throw new SupplierNotFoundException("No supplier found for username: " + userDetails.getUsername());
    }

    public void isSupplierLoggedIn(UserDetails userDetails) {
        if (Boolean.FALSE.equals(userDetails.getLoggedIn()))
            throw new SupplierLoggedOutException("Supplier for username is not logged in: " + userDetails.getUsername());
    }

}
