package com.freedomBanking.authManagement.controller;

import com.freedomBanking.authManagement.service.UserService;
import com.freedomBanking.dto.request.LoginRequest;
import com.freedomBanking.dto.request.RegisterRequest;
import com.freedomBanking.dto.response.ApiResponse;
import com.freedomBanking.dto.response.LoginResponse;
import com.freedomBanking.dto.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private final UserService userService;

    @Autowired
    AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody RegisterRequest request) {
        ApiResponse<UserResponse>  response = userService.registerUser(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getData().getUserId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        try {
            LoginResponse response = userService.authenticateUser(request);

            if (response.isSuccess()) {
                return ResponseEntity.ok(response);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } catch (Exception e) {
            LoginResponse errorResponse = new LoginResponse(false, "Credential not accepted");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
