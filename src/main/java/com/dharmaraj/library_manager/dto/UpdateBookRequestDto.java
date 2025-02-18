package com.dharmaraj.library_manager.dto;

import lombok.Data;

@Data
public class UpdateBookRequestDto {
    
    private String title;

    private String genre;

    private String author;
}
