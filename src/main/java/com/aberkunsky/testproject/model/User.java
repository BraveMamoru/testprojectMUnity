package com.aberkunsky.testproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.tuple.GeneratedValueGeneration;
import sun.nio.cs.Surrogate;

import javax.persistence.*;
import javax.transaction.Transactional;

/**
 * user: alekseyb
 * date: 15.06.18
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(name = "username", unique = true)
    private String userName;

    private String plainTextPassword;
    @JsonIgnore
    private String hashedPassword;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @JsonIgnore
    public String getPlainTextPassword() {
        return plainTextPassword;
    }
    @JsonProperty
    public void setPlainTextPassword(String plainTextPassword) {
        this.plainTextPassword = plainTextPassword;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", plainTextPassword='" + plainTextPassword + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
