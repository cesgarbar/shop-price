package com.inditex.retail.shopprice.app.config;

import com.inditex.retail.shopprice.module.shared.exceptions.DomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalHandlerExceptionController {

    @ExceptionHandler({DomainException.class})
    public ResponseEntity<Object> handleAll(DomainException ex) {
        log.error("Error: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + ex.getMessage());
    }
}
