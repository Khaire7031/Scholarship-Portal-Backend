package com.pdk.scolarship.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @GetMapping("/login")
    public ResponseEntity<HashMap<String, String>> getMethodName() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Pranav Khaire");
        data.put("email", "pranavkhaire28@gmail.com");
        data.put("password", "pranavkhaire");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
