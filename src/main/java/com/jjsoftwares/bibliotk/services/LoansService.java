package com.jjsoftwares.bibliotk.services;

import com.jjsoftwares.bibliotk.dtos.CreateBookDTO;
import com.jjsoftwares.bibliotk.dtos.CreateLoanDTO;
import com.jjsoftwares.bibliotk.entities.Book;
import com.jjsoftwares.bibliotk.entities.Loan;
import com.jjsoftwares.bibliotk.repositories.BookRepository;
import com.jjsoftwares.bibliotk.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoansService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LoanRepository loanRepository;
    public void createLoan(CreateLoanDTO createLoanDTO) {
        var book = verifyIfBookExists(createLoanDTO.bookId());
        if(book.isPresent())
            loanRepository.save(buildLoan(createLoanDTO));
        else
            throw new IllegalArgumentException("livro inexistente");
    }
    private Optional<Book> verifyIfBookExists(Long bookId) {
        var book = this.bookRepository.findById(bookId);
        if(book.isPresent()) {
            changeStatusBook(book);
        }
        return book;
    }

    private void changeStatusBook(Optional<Book> book) {
        book.get().setStatus("unavailable");
        bookRepository.save(book.get());
    }
    private Loan buildLoan(CreateLoanDTO createLoanDTO) {
        return Loan
                .builder()
                .loanDate(createLoanDTO.loanDate())
                .bookId(createLoanDTO.bookId())
                .returnDate(createLoanDTO.returnDate())
                .userId(createLoanDTO.userId())
                .loanDate(createLoanDTO.loanDate())
                .dueDate(createLoanDTO.loanDate())
                .build();
    }
}
