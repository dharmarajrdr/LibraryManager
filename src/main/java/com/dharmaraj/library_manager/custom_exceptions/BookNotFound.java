package com.dharmaraj.library_manager.custom_exceptions;

public class BookNotFound extends RuntimeException {
    
    public BookNotFound(Integer bookId) {
        super("Book with id '" + bookId +"' is not found");
    }
}
