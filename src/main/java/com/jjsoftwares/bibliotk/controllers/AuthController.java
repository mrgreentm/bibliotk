package com.jjsoftwares.bibliotk.controllers;

import com.jjsoftwares.bibliotk.dtos.UserDTO;
import com.jjsoftwares.bibliotk.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        authService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
