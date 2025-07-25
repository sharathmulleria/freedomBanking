package com.freedomBanking.dto.response;

import com.freedomBanking.enums.Gender;
import com.freedomBanking.enums.Status;

import java.time.LocalDateTime;
import java.util.Date;

public class UserResponse {

    private Long userId;
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

    // Getters and Setters

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

    public Status getStatus() {
        return status;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public Boolean getPhoneVerified() {
        return phoneVerified;
    }

    public LocalDateTime getPasswordChangedAt() {
        return passwordChangedAt;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Constructors


}
