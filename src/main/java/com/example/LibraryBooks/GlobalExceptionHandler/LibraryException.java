package com.example.LibraryBooks.GlobalExceptionHandler;

import com.example.LibraryBooks.Exceptions.LibraryException.NoSuchLibraryPresent;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibraryException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NoSuchLibraryPresent.class)
    public ResponseException noSuchLibraryPresent(NoSuchLibraryPresent exception){
        return new ResponseException(exception.getMessage());
    }
}
