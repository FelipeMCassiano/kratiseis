package com.felipemcassiano.kratiseis.infra;

import com.felipemcassiano.kratiseis.exceptions.DateConflictException;
import com.felipemcassiano.kratiseis.exceptions.ResourceNotFoundException;
import com.felipemcassiano.kratiseis.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DateConflictException.class)
    public ResponseEntity<RestErrorMessage> handleDateConflictException(DateConflictException ex) {
        RestErrorMessage errorResponse = new RestErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
        RestErrorMessage errorResponse = new RestErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handleUserNotFoundController(UserNotFoundException ex) {
        RestErrorMessage errorResponse = new RestErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
