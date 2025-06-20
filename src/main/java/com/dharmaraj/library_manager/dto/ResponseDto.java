package com.dharmaraj.library_manager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

    private String error;
    
    private String message;

    private ResponseStatus responseStatus;
}
