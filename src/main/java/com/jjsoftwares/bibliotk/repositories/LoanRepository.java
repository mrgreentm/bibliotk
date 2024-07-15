package com.jjsoftwares.bibliotk.repositories;

import com.jjsoftwares.bibliotk.dtos.LoanBookDTO;
import com.jjsoftwares.bibliotk.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("SELECT new com.jjsoftwares.bibliotk.dtos.LoanBookDTO(l.id, l.userId, l.bookId, l.loanDate, l.dueDate, l.returnDate, b.title, b.author) " +
            "FROM Loan l JOIN Book b ON l.bookId = b.id WHERE l.userId = :userId")
    List<LoanBookDTO> findAllLoansByUserId(@Param("userId") Long userId);

}
