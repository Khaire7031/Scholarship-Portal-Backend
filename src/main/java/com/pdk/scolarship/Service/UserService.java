package com.pdk.scolarship.Service;

import org.springframework.http.ResponseEntity;

import com.pdk.scolarship.Dto.UserDto;

public interface UserService {
    // Update User Profile
    ResponseEntity<UserDto> updateUserProfile(Integer id, UserDto userDto);
}
