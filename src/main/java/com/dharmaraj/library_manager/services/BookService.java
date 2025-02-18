package com.dharmaraj.library_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dharmaraj.library_manager.custom_exceptions.BookNotFound;
import com.dharmaraj.library_manager.dto.AddBookRequestDto;
import com.dharmaraj.library_manager.dto.UpdateBookRequestDto;
import com.dharmaraj.library_manager.models.Book;
import com.dharmaraj.library_manager.repositories.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public Book addBook(AddBookRequestDto addBookRequestDto) {

        Book book = new Book();
        book.setTitle(addBookRequestDto.getTitle());
        book.setGenre(addBookRequestDto.getGenre());
        book.setAuthor(addBookRequestDto.getAuthor());

        return this.bookRepository.save(book);
    }

    public Book getBookById(Integer bookId) throws BookNotFound {
        
        Optional<Book> optionalBook = this.bookRepository.findById(bookId);
        if(optionalBook.isEmpty()) {
            throw new BookNotFound(bookId);
        }

        return optionalBook.get();
    }

    public List<Book> getAllBooks() {

        return this.bookRepository.findAll();
    }

    public Book updateBookById(Integer bookId, UpdateBookRequestDto updateBookRequestDto) {

        if(bookId == null) {
            throw new BookNotFound(bookId);
        }

        Book book = getBookById(bookId);
        book.setAuthor(updateBookRequestDto.getAuthor());
        book.setGenre(updateBookRequestDto.getGenre());
        book.setTitle(updateBookRequestDto.getTitle());

        return this.bookRepository.save(book);
    }

    public void deleteBookById(Integer bookId) {
        
        if(bookId == null) {
            throw new BookNotFound(bookId);
        }

        Book book = getBookById(bookId);
        this.bookRepository.delete(book);
    }
}
