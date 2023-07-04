package com.genodyme.name.generator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FantasyNameGeneratorExceptionHandler {

  @ExceptionHandler(FantasyNameGeneratorException.class)
  public ResponseEntity<Object> handleLocationGeneratorException(FantasyNameGeneratorException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
