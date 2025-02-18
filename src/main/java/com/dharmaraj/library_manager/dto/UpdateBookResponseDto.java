package com.dharmaraj.library_manager.dto;

import com.dharmaraj.library_manager.models.Book;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateBookResponseDto extends ResponseDto {
    
    private Book data;
}
