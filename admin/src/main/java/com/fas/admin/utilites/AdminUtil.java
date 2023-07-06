package com.fas.admin.utilites;

import com.fas.admin.constants.UserType;
import com.fas.admin.exceptions.InvalidUserTypeException;
import org.springframework.stereotype.Component;

/**
 * Simple Utility for service layer and DTOs to entities
 *
 * @author Prateek Singh
 */
@Component
public class AdminUtil {

    public UserType getUserType(String userType) {
        for (UserType type : UserType.values())
            if (userType.equals(type.toString()))
                return type;
        throw new InvalidUserTypeException("Invalid User Type: " + userType);
    }
}
