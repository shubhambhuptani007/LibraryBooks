package com.example.LibraryBooks.Exceptions.LibrarianException;

public class LibrarianAlreadyExistsException extends RuntimeException{
    public LibrarianAlreadyExistsException(String message) {
        super(message);
    }
}
