package com.entrevista.previred.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private int status;
    private String cause;
    private String detail;

}