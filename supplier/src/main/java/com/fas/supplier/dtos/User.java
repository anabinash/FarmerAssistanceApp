package com.fas.supplier.dtos;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Objects;

/**
 * Simple JavaBean modal object for Users entity of the Admin module
 *
 * @author Prateek Singh
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    @Length(min = 6, max = 16, message = "Username should be of length b/w 6 and 16")
    private String username;
    @Column(nullable = false)
    @Min(value = 8, message = "Password should be of length b/w 6 and 16")
    @Length(min = 8, max = 16, message = "Password should be of length b/w 6 and 16")
    private String password;
    @Column(nullable = false)
    private Boolean loggedIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type=" + type +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
