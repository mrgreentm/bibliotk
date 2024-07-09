package com.jjsoftwares.bibliotk.controllers;

import com.jjsoftwares.bibliotk.dtos.LoginUserDTO;
import com.jjsoftwares.bibliotk.dtos.UserDTO;
import com.jjsoftwares.bibliotk.security.authentication.JwtTokenService;
import com.jjsoftwares.bibliotk.security.userdetails.UserDetailsImpl;
import com.jjsoftwares.bibliotk.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final JwtTokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        authService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody @Valid LoginUserDTO loginUserDTO) {
        var usernamePassoword = new UsernamePasswordAuthenticationToken(loginUserDTO.email(), loginUserDTO.password());
        var authentication = this.authenticationManager.authenticate(usernamePassoword);
        var token = this.tokenService.generateToken((UserDetailsImpl) authentication.getPrincipal());
        return ResponseEntity.ok(token);
    }
}
