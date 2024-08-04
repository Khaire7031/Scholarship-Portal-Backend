package com.pdk.scolarship.Dto;

import com.pdk.scolarship.Enums.Role;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;
    private String refreshToken;
    private Role Role;
}