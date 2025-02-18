package com.dharmaraj.library_manager.custom_exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dharmaraj.library_manager.dto.ResponseDto;
import com.dharmaraj.library_manager.dto.ResponseStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<?> bookNotFoundHandler(BookNotFound e) {
        
        ResponseDto responseDto = new ResponseDto();
        responseDto.setError(e.getMessage());
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
        return ResponseEntity.status(404).body(responseDto);
    }
}
