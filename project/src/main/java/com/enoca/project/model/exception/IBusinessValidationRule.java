package com.enoca.project.model.exception;

import org.springframework.http.HttpStatus;

public interface IBusinessValidationRule {

    String getCode();

    String getMessage();

    HttpStatus getHttpStatus();
}
