package com.jjsoftwares.bibliotk.controllers;

import com.jjsoftwares.bibliotk.dtos.HomeDataDTO;
import com.jjsoftwares.bibliotk.services.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {
    private final HomeService homeService;
    @GetMapping("/{userId}")
    public ResponseEntity<HomeDataDTO> getHomeDataByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(this.homeService.getUserDataById(userId));
    }
}
