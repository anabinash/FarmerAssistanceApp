package com.fas.admin.repository;

import com.fas.admin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Data Repository for users_db by JpaRepository
 *
 * @author Prateek singh
 */
public interface IAdminRepository extends JpaRepository<User, Long> {

    /**
     * @param username, password;
     * @return List<User>
     * @implNote Gets List<User> with username, password
     */
    @Query("from User where username = :username and password = :password")
    public List<User> getUserWithCredentials(@Param("username") String username, @Param("password") String password);

    /**
     * @param username, password;
     * @return List<User>
     * @implNote Gets List<User> with username
     */
    @Query("FROM User WHERE username = :username")
    public List<User> getUserWithUsername(@Param("username") String username);
}
