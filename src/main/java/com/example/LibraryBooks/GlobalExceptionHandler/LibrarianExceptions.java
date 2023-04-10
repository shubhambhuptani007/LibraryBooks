package com.example.LibraryBooks.GlobalExceptionHandler;

import com.example.LibraryBooks.Exceptions.BookExceptions.BookNotFoundException;
import com.example.LibraryBooks.Exceptions.LibrarianException.NoSuchLibrarianFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibrarianExceptions {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NoSuchLibrarianFound.class)
    public ResponseException noSuchLibrarianFound(NoSuchLibrarianFound exception){
        return new ResponseException(exception.getMessage());
    }
}
