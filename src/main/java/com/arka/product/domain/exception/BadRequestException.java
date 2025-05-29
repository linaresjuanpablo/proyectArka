package com.arka.product.domain.exception;

import com.arka.product.domain.exception.error.CommonErrorCode;
import com.arka.product.domain.exception.error.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder

public class BadRequestException extends BusinessException{

    private static final IErrorCode DEFAULT_ERROR_CODE = CommonErrorCode.INVALID_INPUT;
}
