package com.freedomBanking.authManagement.service;

import com.freedomBanking.authManagement.exception.UserAlreadyExistsException;
import com.freedomBanking.dto.request.LoginRequest;
import com.freedomBanking.dto.request.RegisterRequest;
import com.freedomBanking.dto.response.ApiResponse;
import com.freedomBanking.dto.response.LoginResponse;
import com.freedomBanking.dto.response.UserResponse;

public interface UserService {

    ApiResponse<UserResponse> registerUser(RegisterRequest request) throws UserAlreadyExistsException;

    LoginResponse authenticateUser(LoginRequest request);

}
