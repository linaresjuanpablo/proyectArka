package com.arka.product.domain.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor

public enum CommonErrorCode implements IErrorCode{

    VALIDATION_ERROR("ERR_VALIDATION", "Validation error", HttpStatus.BAD_REQUEST.value(), ErrorProduct.VALIDATION),

    INVALID_INPUT("ERR_INVALID_INPUT", "Invalid input data", HttpStatus.BAD_REQUEST.value(), ErrorProduct.VALIDATION),
    RESOURCE_NOT_FOUND("ERR_NOT_FOUND", "Resource not found", HttpStatus.NOT_FOUND.value(), ErrorProduct.RESOURCE),
    RESOURCE_ALREADY_EXISTS("ERR_DUPLICATE_RESOURCE", "Resource already exists", HttpStatus.CONFLICT.value(), ErrorProduct.RESOURCE),
    INTERNAL_ERROR("ERROR_INTERNAK_SERVER", "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorProduct.SYSTEM),


    //data access errors
    DATA_ACCESS_ERROR( "ERR_DATA_ACCESS", "Data access error", HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorProduct.DATA_ACCESS),

    DATABASE_ERROR("ERR_DATABASE", "Database error", HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorProduct.DATA_ACCESS);


    private final String code;
    private final String message;
    private final int statusCode;


    private final ErrorProduct category;


}
