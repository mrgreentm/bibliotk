package com.jjsoftwares.bibliotk.controllers;

import com.jjsoftwares.bibliotk.dtos.CreateBookDTO;
import com.jjsoftwares.bibliotk.entities.Book;
import com.jjsoftwares.bibliotk.services.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@AllArgsConstructor
public class BookController {

    private final BooksService booksService;
    @PostMapping()
    public ResponseEntity<Void> createBook(@RequestBody CreateBookDTO createBookDTO) {
        this.booksService.createBook(createBookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(this.booksService.getAllBooks());
    }
}
