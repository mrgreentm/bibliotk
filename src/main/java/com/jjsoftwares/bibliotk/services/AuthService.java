package com.jjsoftwares.bibliotk.services;

import com.jjsoftwares.bibliotk.dtos.UserDTO;
import com.jjsoftwares.bibliotk.entities.User;
import com.jjsoftwares.bibliotk.repositories.UserRepository;
import com.jjsoftwares.bibliotk.security.authentication.JwtTokenService;
import com.jjsoftwares.bibliotk.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig securityConfig;

    public void createUser(UserDTO createUserDto) {
        User newUser = User.builder()
                .email(createUserDto.email())
                .password(securityConfig.passwordEncoder().encode(createUserDto.password()))
                .username(createUserDto.username())
                .build();

        userRepository.save(newUser);
    }

}
