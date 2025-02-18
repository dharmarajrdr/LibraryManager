package com.dharmaraj.library_manager.dto;

import java.util.List;

import com.dharmaraj.library_manager.models.Book;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetAllBookResponseDto extends ResponseDto {
    
    private List<Book> data;
}
