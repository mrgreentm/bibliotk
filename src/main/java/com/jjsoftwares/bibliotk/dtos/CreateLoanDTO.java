package com.jjsoftwares.bibliotk.dtos;

import java.time.LocalDate;

public record CreateLoanDTO(
        Long userId,
        Long bookId,
        LocalDate loanDate,
        LocalDate returnDate

) {
}
