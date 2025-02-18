package com.dharmaraj.library_manager.dto;

import com.dharmaraj.library_manager.models.Book;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AddBookResponseDTO extends ResponseDto {
    
    private Book book;
}
