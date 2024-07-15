package com.jjsoftwares.bibliotk.services;

import com.jjsoftwares.bibliotk.controllers.errorhandler.RestException;
import com.jjsoftwares.bibliotk.dtos.CreateBookDTO;
import com.jjsoftwares.bibliotk.dtos.CreateLoanDTO;
import com.jjsoftwares.bibliotk.dtos.GetUsersLoanDTO;
import com.jjsoftwares.bibliotk.dtos.LoanBookDTO;
import com.jjsoftwares.bibliotk.entities.Book;
import com.jjsoftwares.bibliotk.entities.Loan;
import com.jjsoftwares.bibliotk.entities.User;
import com.jjsoftwares.bibliotk.repositories.BookRepository;
import com.jjsoftwares.bibliotk.repositories.LoanRepository;
import com.jjsoftwares.bibliotk.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LoansService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private UserRepository userRepository;

    public void createLoan(CreateLoanDTO createLoanDTO) {
        var book = verifyIfBookExists(createLoanDTO.bookId());
        var user = verifyIfUserExists(createLoanDTO.userId());
        if(verifyUser(user)) {
            processLoan(createLoanDTO, book);
        } else throw new RestException("usuário inexistente");
    }
    public List<LoanBookDTO> getLoansByUser(Long id) {
        return this.loanRepository.findAllLoansByUserId(id);
    }

    private void processLoan(CreateLoanDTO createLoanDTO, Optional<Book> book) {
        if(book.isPresent() && verifyStatusBook(book.get())) {
            book.ifPresent(this::changeStatusBook);
            loanRepository.save(buildLoan(createLoanDTO));
        } else {
            throw new RestException("Livro inexistente ou não disponível");
        }
    }

    private Optional<Book> verifyIfBookExists(Long bookId) {
        return this.bookRepository.findById(bookId);
    }
    private Boolean verifyUser(Optional<User> user) {
        return user.isPresent();
    }
    private Optional<User> verifyIfUserExists(Long userId) {
        return this.userRepository.findById(userId);
    }

    private void changeStatusBook(Book book) {
        book.setStatus("unavailable");
        bookRepository.save(book);
    }
    private Boolean verifyStatusBook(Book book) {
        return book.getStatus().equals("available");
    }
    private Loan buildLoan(CreateLoanDTO createLoanDTO) {
        return Loan
                .builder()
                .loanDate(createLoanDTO.loanDate())
                .bookId(createLoanDTO.bookId())
                .returnDate(createLoanDTO.returnDate())
                .userId(createLoanDTO.userId())
                .loanDate(createLoanDTO.loanDate())
                .dueDate(createLoanDTO.loanDate().plusDays(5))
                .build();
    }
}
