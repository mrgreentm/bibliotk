package com.jjsoftwares.bibliotk.services;

import com.jjsoftwares.bibliotk.dtos.HomeDataDTO;
import com.jjsoftwares.bibliotk.entities.User;
import com.jjsoftwares.bibliotk.repositories.BookRepository;
import com.jjsoftwares.bibliotk.repositories.LoanRepository;
import com.jjsoftwares.bibliotk.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HomeService {
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    public HomeDataDTO getUserDataById(Long userId) {
        var user = getUserById(userId);
        var userLoans = loanRepository.findAllLoansByUserId(userId);
        return HomeDataDTO
                .builder()
                .userName(user.getUsername())
                .userId(user.getId())
                .loans(userLoans)
                .email(user.getEmail())
                .build();
    }
    private User getUserById(Long id) {
        return this.userRepository.getReferenceById(id);
    }
}
