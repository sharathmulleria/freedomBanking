package com.freedomBanking.dto.request;

import com.freedomBanking.enums.Gender;
import com.freedomBanking.enums.Status;

import java.time.LocalDateTime;
import java.util.Date;

public class RegisterRequest {

    private Integer userId;
    private String email;
    private String phone;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    private String profilePictureUrl;
    private Gender gender;
    private Status status = Status.ACTIVE;
    private Boolean emailVerified = false;
    private Boolean phoneVerified = false;
    private LocalDateTime passwordChangedAt;
    private Integer failedLoginAttempts = 0;
    private LocalDateTime lastLogin;

    // Getters and Setters //


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getUserId() {
        return userId;
    }

}
