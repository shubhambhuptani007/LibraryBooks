package com.example.LibraryBooks.GlobalExceptionHandler;

import com.example.LibraryBooks.Exceptions.BookExceptions.BookAlreadyExistException;
import com.example.LibraryBooks.Exceptions.BookExceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptions {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseException bookNotFoundException(BookNotFoundException exception){
        return new ResponseException(exception.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BookAlreadyExistException.class)
    public ResponseException bookAlreadyExistException(BookAlreadyExistException exception){
        return new ResponseException(exception.getMessage());
    }

}
