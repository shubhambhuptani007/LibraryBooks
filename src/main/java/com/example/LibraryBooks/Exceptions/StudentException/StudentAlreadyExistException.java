package com.example.LibraryBooks.Exceptions.StudentException;

public class StudentAlreadyExistException extends RuntimeException{
    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
