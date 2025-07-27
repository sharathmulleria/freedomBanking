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

    public LoginResponse(Long userId, String fullName, String token, Boolean success, String message) {
        this.userId = userId;
        this.fullName = fullName;
        this.token = token;
        this.success = success;
        this.message = message;
    }
}
