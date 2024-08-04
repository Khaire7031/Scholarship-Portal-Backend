package com.pdk.scolarship.Controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdk.scolarship.Dto.UserDto;
import com.pdk.scolarship.ServiceImplementation.UserServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("User logged In");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateProfile(@PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        return userServiceImpl.updateUserProfile(id, userDto);
    }

}