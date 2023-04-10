package com.example.LibraryBooks.Exceptions.StudentException;

public class NoSuchStudentFoundException extends RuntimeException{
    public NoSuchStudentFoundException(String message) {
        super(message);
    }
}
