package com.project.finance.infra.adapters.inbound.controllers;

import com.project.finance.core.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalFilterExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(GlobalFilterExceptionController.class);

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity handleNotFound(NotFoundException notFoundException) {
        logger.error("error: ", notFoundException);
        return ResponseEntity.notFound().build();
    }
}
