package com.arka.product.domain.exception.error;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum ErrorProduct {

    VALIDATION("validation errors"),
    RESOURCE("Resource-related errors"),
    DATA_ACCESS("Data access errors"),
    SYSTEM("System errors");

    private final String description;
}
