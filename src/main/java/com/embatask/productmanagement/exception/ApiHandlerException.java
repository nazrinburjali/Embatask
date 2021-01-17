package com.embatask.productmanagement.exception;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ApiHandlerException {
    private final static Logger logger = LogManager.getLogger(ApiHandlerException.class);

    @ResponseBody
    @ExceptionHandler(value = ResponseStatusException.class)
    public ResponseEntity<?> handleException(ResponseStatusException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<?> handleException(UsernameNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

}
