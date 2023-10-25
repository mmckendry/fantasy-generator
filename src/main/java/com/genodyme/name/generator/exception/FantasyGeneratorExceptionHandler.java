package com.genodyme.name.generator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception handler for Fantasy Generator Exceptions
 */
@RestControllerAdvice
public class FantasyGeneratorExceptionHandler {

  @ExceptionHandler(FantasyGeneratorException.class)
  public ResponseEntity<Object> handleLocationGeneratorException(FantasyGeneratorException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
