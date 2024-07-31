package com.pdk.scolarship.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.pdk.scolarship.Dto.LoginDto;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> login(@RequestBody LoginDto loginDto) {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Pranav Khaire");
        data.put("email", "pranavkhaire28@gmail.com");
        data.put("password", "pranavkhaire");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping()
    public String mainPage() {
        return "Hello From Server";
    }

}