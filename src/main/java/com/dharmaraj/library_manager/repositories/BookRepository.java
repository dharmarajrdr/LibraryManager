package com.dharmaraj.library_manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.library_manager.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    
    public Optional<Book> findBookById(Integer bookId);
}
