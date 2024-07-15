package com.jjsoftwares.bibliotk.dtos;

import java.time.LocalDate;

public record LoanBookDTO(
        Long loanId,
        Long bookId,
        LocalDate loanDate,
        LocalDate dueDate,
        LocalDate returnDate,
        String bookTitle,
        String bookAuthor
) {}
