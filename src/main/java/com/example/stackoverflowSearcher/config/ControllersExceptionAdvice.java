package com.example.stackoverflowSearcher.config;

import com.example.stackoverflowSearcher.exception.SearcherException;
import com.example.stackoverflowSearcher.exception.StackoverflowExceptionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ControllersExceptionAdvice {
    private static final String UNABLE_TO_PARSE_EXCEPTION = "unable to parse exception";
    private Logger logger = LogManager.getLogger(ControllersExceptionAdvice.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(SearcherException.class)
    public ResponseEntity<StackoverflowExceptionDto> handleRuntimeException(SearcherException ex) {
        logger.error(ex.getMessage(), ex);
        try {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.readValue(ex.getMessage(), StackoverflowExceptionDto.class));
        } catch (IOException e) {
            logger.debug(UNABLE_TO_PARSE_EXCEPTION, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StackoverflowExceptionDto(UNABLE_TO_PARSE_EXCEPTION));
        }
    }
}
