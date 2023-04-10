package com.example.LibraryBooks.GlobalExceptionHandler;

import com.example.LibraryBooks.Exceptions.StudentException.NoSuchStudentFoundException;
import com.example.LibraryBooks.Exceptions.StudentException.StudentAlreadyExistException;
import com.example.LibraryBooks.Exceptions.StudentException.StudentNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptions {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NoSuchStudentFoundException.class)
    public ResponseException noSuchStudentFoundException(NoSuchStudentFoundException exception){
        return new ResponseException(exception.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = StudentNotExists.class)
    public ResponseException studentNotExists(StudentNotExists exception){
        return new ResponseException(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = StudentAlreadyExistException.class)
    public ResponseException studentAlreadyExistException(StudentAlreadyExistException exception){
        return new ResponseException(exception.getMessage());
    }
}
