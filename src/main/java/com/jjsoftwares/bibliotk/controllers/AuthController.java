package com.jjsoftwares.bibliotk.controllers;

import com.jjsoftwares.bibliotk.dtos.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
