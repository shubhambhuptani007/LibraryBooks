package com.example.LibraryBooks.Exceptions.LibrarianException;

public class LibrarianNotExistsException extends RuntimeException{
    public LibrarianNotExistsException(String message) {
        super(message);
    }
}
