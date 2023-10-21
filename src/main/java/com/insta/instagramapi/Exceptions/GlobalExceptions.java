package com.insta.instagramapi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> UserExceptionHandler(UserException ue, WebRequest request){
        ErrorDetails error = new ErrorDetails(ue.getMessage(),request.getDescription(false), LocalDateTime.now());
            return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)//usernameATLEAST 2 CHAR MAX 50 such cases handled by this exception
    public ResponseEntity<ErrorDetails> MethodArgumentNotValidException(MethodArgumentNotValidException me, WebRequest request){
        ErrorDetails error = new ErrorDetails(me.getBindingResult().getFieldError().getDefaultMessage(),"Validation Error", LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)//Always keep this exception at last
    public ResponseEntity<ErrorDetails> OtherExceptionHandler(Exception ue, WebRequest request){
        ErrorDetails error = new ErrorDetails(ue.getMessage(),request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }

}
