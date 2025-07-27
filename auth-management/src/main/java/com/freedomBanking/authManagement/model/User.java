package com.freedomBanking.authManagement.model;

import com.freedomBanking.dto.common.CommonUtils;
import com.freedomBanking.dto.request.RegisterRequest;
import com.freedomBanking.enums.Gender;
import com.freedomBanking.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends CommonUtils {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    private String profilePictureUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Roles> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserSession> sessions = new ArrayList<>();

    private Boolean emailVerified = false;

    private Boolean phoneVerified = false;

    private LocalDateTime passwordChangedAt;

    private Integer failedLoginAttempts = 0;

    private LocalDateTime lastLogin;




// Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public @Email String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
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

    public Status getStatus() {
        return status;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    // Constructors //


    public User() {}

    public User(RegisterRequest request) {
        this.email = request.getEmail();
        this.dateOfBirth = request.getDateOfBirth();
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.gender = request.getGender();
        this.password = request.getPassword();
        this.phone = request.getPhone();
    }
}
