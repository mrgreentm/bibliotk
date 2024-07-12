package com.jjsoftwares.bibliotk.controllers;

import com.jjsoftwares.bibliotk.dtos.CreateBookDTO;
import com.jjsoftwares.bibliotk.dtos.CreateLoanDTO;
import com.jjsoftwares.bibliotk.services.BooksService;
import com.jjsoftwares.bibliotk.services.LoansService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loans")
@AllArgsConstructor
public class LoanController {

    private final LoansService loansService;
    @PostMapping()
    public ResponseEntity<Void> createLoan(@RequestBody CreateLoanDTO createLoanDTO) {
        this.loansService.createLoan(createLoanDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
