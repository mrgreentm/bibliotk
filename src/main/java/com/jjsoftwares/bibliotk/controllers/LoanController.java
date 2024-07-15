package com.jjsoftwares.bibliotk.controllers;

import com.jjsoftwares.bibliotk.dtos.CreateBookDTO;
import com.jjsoftwares.bibliotk.dtos.CreateLoanDTO;
import com.jjsoftwares.bibliotk.dtos.LoanBookDTO;
import com.jjsoftwares.bibliotk.entities.Loan;
import com.jjsoftwares.bibliotk.services.BooksService;
import com.jjsoftwares.bibliotk.services.LoansService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{userId}")
    public ResponseEntity<List<LoanBookDTO>> getLoansByUser(@PathVariable Long userId) {
        var loans = this.loansService.getLoansByUser(userId);
        return ResponseEntity.ok(loans);
    }
    @DeleteMapping("/{loanId}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long loanId) {
        this.loansService.deleteLoan(loanId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
