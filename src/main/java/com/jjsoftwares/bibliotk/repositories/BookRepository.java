package com.jjsoftwares.bibliotk.repositories;

import com.jjsoftwares.bibliotk.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
