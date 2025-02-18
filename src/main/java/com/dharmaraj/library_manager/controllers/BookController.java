package com.dharmaraj.library_manager.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dharmaraj.library_manager.dto.AddBookRequestDto;
import com.dharmaraj.library_manager.dto.AddBookResponseDTO;
import com.dharmaraj.library_manager.dto.DeleteBookResponseDto;
import com.dharmaraj.library_manager.dto.GetAllBookResponseDto;
import com.dharmaraj.library_manager.dto.GetBookResponseDto;
import com.dharmaraj.library_manager.dto.ResponseStatus;
import com.dharmaraj.library_manager.dto.UpdateBookRequestDto;
import com.dharmaraj.library_manager.dto.UpdateBookResponseDto;
import com.dharmaraj.library_manager.models.Book;
import com.dharmaraj.library_manager.services.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create/book")
    public ResponseEntity<AddBookResponseDTO> addBook(@RequestBody AddBookRequestDto addBookRequestDto) {
        
        AddBookResponseDTO addBookResponseDTO = new AddBookResponseDTO();
        Book book = this.bookService.addBook(addBookRequestDto);
        addBookResponseDTO.setBook(book);
        addBookResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        addBookResponseDTO.setMessage("Book created successfully.");
        return ResponseEntity.status(201).body(addBookResponseDTO);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<GetBookResponseDto> getBookById(@PathVariable("id") Integer bookId) {
        
        GetBookResponseDto getBookResponseDto = new GetBookResponseDto();
        Book book = this.bookService.getBookById(bookId);
        getBookResponseDto.setData(book);
        getBookResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return ResponseEntity.status(200).body(getBookResponseDto);
    }

    @GetMapping("/book")
    public ResponseEntity<GetAllBookResponseDto> getAllBooks() {
        
        GetAllBookResponseDto getAllBookResponseDto = new GetAllBookResponseDto();
        List<Book> books = this.bookService.getAllBooks();
        getAllBookResponseDto.setData(books);
        getAllBookResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return ResponseEntity.status(200).body(getAllBookResponseDto);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<UpdateBookResponseDto> updateBookById(@PathVariable("id") Integer bookId, @RequestBody UpdateBookRequestDto updateBookRequestDto) {
        
        UpdateBookResponseDto updateBookResponseDto = new UpdateBookResponseDto();
        Book book = this.bookService.updateBookById(bookId, updateBookRequestDto);
        updateBookResponseDto.setData(book);
        updateBookResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return ResponseEntity.status(200).body(updateBookResponseDto);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<DeleteBookResponseDto> updateBookById(@PathVariable("id") Integer bookId) {
        
        DeleteBookResponseDto deleteBookResponseDto = new DeleteBookResponseDto();
        this.bookService.deleteBookById(bookId);
        deleteBookResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        deleteBookResponseDto.setMessage("Book with id '" + bookId +"' has been successfully deleted.");
        return ResponseEntity.status(200).body(deleteBookResponseDto);
    }
}
