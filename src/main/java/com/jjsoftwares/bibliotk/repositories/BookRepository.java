package com.jjsoftwares.bibliotk.repositories;

import com.jjsoftwares.bibliotk.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);

}
