package com.example.LibraryBooks.Exceptions.StudentException;

public class StudentNotExists extends RuntimeException{
    public StudentNotExists(String message) {
        super(message);
    }
}
