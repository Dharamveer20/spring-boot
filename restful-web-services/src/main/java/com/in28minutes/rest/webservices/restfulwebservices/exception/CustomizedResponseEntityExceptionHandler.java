package com.in28minutes.rest.webservices.restfulwebservices.exception;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/*  -------------------------- HANDLING EXCEPTIONS OCCURRING IN OUR APPLICATION  --------------------------------*/

@ControllerAdvice // Spring annotation hai jo poore application me exceptions ko handle karne ke liye use hota hai.
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) // To handle all type of Exception we pass Exception Class
    public final ResponseEntity<ErrorDetail> handleAllException(Exception ex, WebRequest request) throws Exception { // Ye line ResponseEntityExceptionHandler class ye utha le
        ErrorDetail errorDetails = new ErrorDetail(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        // ResponseEntity return kar rahe hain jisme errorDetails aur HTTP response status pass rahe hai.
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class) // To handle UserNotFound Exception we pass UserNotFoundException class which we created.
    public final ResponseEntity<ErrorDetail> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ErrorDetail errorDetails = new ErrorDetail(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

//    // Not working
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        ErrorDetail errorDetails = new ErrorDetail(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
//        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
//    }
}
