package com.jjsoftwares.bibliotk.services;

import com.jjsoftwares.bibliotk.dtos.CreateBookDTO;
import com.jjsoftwares.bibliotk.dtos.CreateUserDTO;
import com.jjsoftwares.bibliotk.entities.Book;
import com.jjsoftwares.bibliotk.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BooksService {
    @Autowired
    private BookRepository bookRepository;
    public void createBook(CreateBookDTO createBookDTO) {
        this.bookRepository.save(buildBook(createBookDTO));
    }

    private Book buildBook(CreateBookDTO createBookDTO) {
        return Book
                .builder()
                .author(createBookDTO.author())
                .category(createBookDTO.category())
                .title(createBookDTO.title())
                .status(createBookDTO.status())
                .build();
    }
}
