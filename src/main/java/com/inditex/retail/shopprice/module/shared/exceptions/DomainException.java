package com.inditex.retail.shopprice.module.shared.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainException extends RuntimeException{
    private final String message;

    public DomainException(final String message) {
        this.message = message;
    }
}
