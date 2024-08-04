package com.pdk.scolarship.Controller;

import com.pdk.scolarship.ServiceImplementation.AuthenticationService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdk.scolarship.Dto.JwtAuthenticationResponse;
import com.pdk.scolarship.Dto.RefreshTokenRequest;
import com.pdk.scolarship.Dto.SignInRequest;
import com.pdk.scolarship.Dto.SignUpRequest;
import com.pdk.scolarship.Entity.User;
import com.pdk.scolarship.Enums.AppConstants;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private final AuthenticationService authenticationService;

    // Add new user
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    // Add new Admin
    @PostMapping("/admin-signup")
    public ResponseEntity<User> adminSignUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.adminSignUp(signUpRequest));
    }

    // Login User and admin
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody SignInRequest signInRequest) {
        System.out.println(signInRequest.getEmail() + " : " + signInRequest.getPassword());
        logger.info(AppConstants.PURPLE + "User name = {}" + AppConstants.WHITE, signInRequest.getEmail());

        JwtAuthenticationResponse response = authenticationService.signIn(signInRequest);

        logger.info(AppConstants.RED + "Responce = {}" + AppConstants.WHITE, response.getToken());
        logger.info(AppConstants.BLUE + "Responce = {}" + AppConstants.WHITE, response.getRefreshToken());

        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    // Get Refresh Token
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

}