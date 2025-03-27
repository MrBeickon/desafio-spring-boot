package com.entrevista.previred.handler;

import com.entrevista.previred.models.dtos.ErrorResponse;
import org.springframework.http.ResponseEntity;

public interface ExceptionHandlerStrategy {
    boolean canHandle(Exception ex);
    ResponseEntity<ErrorResponse> handle(Exception ex);
}