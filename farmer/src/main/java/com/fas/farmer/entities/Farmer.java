package com.fas.farmer.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.Objects;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @Length(min = 6, max = 16, message = "Username should be of length b/w 6 and 16")
    private String username;
    @Column(nullable = false)
    @Length(min=4, max=16, message = "First name must be b/w 4 and 16")
    private String firstName;
    @Column(nullable = false)
    @Length(min=4, max=16, message = "First name must be b/w 4 and 16")
    private String lastName;
    @Column(nullable = false)
    @Min(1)
    @Max(999999)
    private Long pincode;

    @Column(nullable = false)
    private String phnNumber;

    public Farmer() {

    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pincode=" + pincode +
                ", phnNumber='" + phnNumber + '\'' +
                '}';
    }

    public Farmer(String username, String firstName, String lastName, Long pincode, String phnNumber) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pincode = pincode;
        this.phnNumber = phnNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farmer farmer = (Farmer) o;
        return Objects.equals(id, farmer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long long1) {
        this.pincode = long1;
    }

    public String getPhnNumber() {
        return phnNumber;
    }

    public void setPhnNumber(String phnNumber) {
        this.phnNumber = phnNumber;
    }
}
