package com.freedomBanking.dto.response;

public class LoginResponse {

    private Long userId;

    private String fullName;

    private String token;

    private Boolean success;

    private String message;

    private String email;

 // getters and setters


    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getToken() {
        return token;
    }

    public Boolean isSuccess() {
        return success;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getToken() {
        return token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    // constructor


    public LoginResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public LoginResponse(Boolean success, String message, String token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }

    public  LoginResponse(Long userId, String fullName, String token, Boolean success, String message, String email) {
        this.userId = userId;
        this.fullName = fullName;
        this.token = token;
        this.success = success;
        this.message = message;
        this.email = email;
    }
}
