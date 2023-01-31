package com.careerit.iplstats.controller;

import com.careerit.iplstats.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value
      = {IllegalArgumentException.class})
  protected ResponseEntity<ApiError> handleConflict(
      RuntimeException ex, WebRequest request) {
    String bodyOfResponse = ex.getMessage();
    String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
    ApiError apiError = ApiError.builder().dateTime(LocalDateTime.now())
        .httpStatus(HttpStatus.CONFLICT).path(path).message(ex.getMessage()).build();
    return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
  }
}
