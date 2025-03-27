package com.entrevista.previred.handler;

import com.entrevista.previred.models.dtos.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ExceptionHandlerStrategySelector strategySelector;

    public GlobalExceptionHandler(ExceptionHandlerStrategySelector strategySelector) {
        this.strategySelector = strategySelector;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return strategySelector.handleException(ex);
    }
}