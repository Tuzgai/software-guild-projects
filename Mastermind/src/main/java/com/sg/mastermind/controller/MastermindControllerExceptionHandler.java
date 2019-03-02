package com.sg.mastermind.controller;

import com.sg.mastermind.dao.GameEmptyException;
import com.sg.mastermind.dao.GameNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Stuart
 */
@ControllerAdvice
@RestController
public class MastermindControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String CONSTRAINT_MESSAGE = "Could not save your item. "
            + "Please insure it is valid and try again.";

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public final ResponseEntity<Error> handleSqlException(
            SQLIntegrityConstraintViolationException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage(CONSTRAINT_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(GameNotFoundException.class)
    public final ResponseEntity<Error> handleGameNotFoundException(
            GameNotFoundException e,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GameEmptyException.class)
    public final ResponseEntity<Error> handleGameEmptyException(
            GameEmptyException e,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

}
