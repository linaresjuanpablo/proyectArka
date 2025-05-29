package com.arka.product.domain.exception;

import com.arka.product.domain.exception.error.CommonErrorCode;
import com.arka.product.domain.exception.error.ErrorCodeRegistry;
import com.arka.product.domain.exception.error.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class BusinessException extends RuntimeException{
    private IErrorCode iErrorCode;
    private String code;
    private String message;
    private int statusCode;

    public BusinessException(IErrorCode iErrorCode){
        super(iErrorCode.getMessage());
        this.iErrorCode = iErrorCode;
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
        this.statusCode = iErrorCode.getStatusCode();
    }

    public BusinessException(IErrorCode iErrorCode, String message){
        super(message);
        this.iErrorCode = iErrorCode;
        this.code = iErrorCode.getCode();
        this.message = message;
        this.statusCode = iErrorCode.getStatusCode();
    }

    public BusinessException(String code, String message, int statusCode){
        super(message);
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
        this.iErrorCode = ErrorCodeRegistry.getOrDefault(code, CommonErrorCode.INTERNAL_ERROR);
    }




}
