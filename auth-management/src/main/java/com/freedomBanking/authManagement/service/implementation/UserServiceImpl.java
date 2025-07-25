package com.freedomBanking.authManagement.service.implementation;

import com.freedomBanking.authManagement.config.JwtUtil;
import com.freedomBanking.authManagement.exception.UserAlreadyExistsException;
import com.freedomBanking.authManagement.model.Roles;
import com.freedomBanking.authManagement.model.User;
import com.freedomBanking.authManagement.repository.UserRepository;
import com.freedomBanking.authManagement.service.UserService;
import com.freedomBanking.dto.request.LoginRequest;
import com.freedomBanking.dto.request.RegisterRequest;
import com.freedomBanking.dto.response.ApiResponse;
import com.freedomBanking.dto.response.LoginResponse;
import com.freedomBanking.dto.response.UserResponse;
import com.freedomBanking.enums.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    @Autowired
    UserServiceImpl(UserRepository userRepository,
                    PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public ApiResponse<UserResponse> registerUser(RegisterRequest request) throws UserAlreadyExistsException {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User with email "+request.getEmail() + "already registered.");
        }

        User user = new User(request);
        Roles roles = new Roles(RoleName.CUSTOMER, user);
        List<Roles> roleList = new ArrayList<>();
        roleList.add(roles);
        user.setRoles(roleList);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        UserResponse response = convertUserToUserResponse(user);
        userRepository.save(user);

        return new ApiResponse<UserResponse>(true,
                "Account created successfully", response);
    }

    @Override
    public LoginResponse authenticateUser(LoginRequest request) {

        try {
            Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

            if (optionalUser.isPresent()) {
                User user = new User();

                if (!passwordEncoder.matches(user.getPassword(), request.getPassword())) {
                    return new LoginResponse(false, "Invalid email or password");
                }

                String token = jwtUtil.generateToken(request.getEmail());
                user.setLastLogin(LocalDateTime.now());
                userRepository.save(user);
                return new LoginResponse(false, "Login failed. Please try again.", token);
            } else {
                return new LoginResponse(false, "Login failed. Please try again.");
            }

        }catch (Exception e) {
            return new LoginResponse(false, "Login failed. Please try again.");
        }
    }


    private UserResponse convertUserToUserResponse(User user) {
        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        return response;
    }
}
