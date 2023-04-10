package com.example.LibraryBooks.Exceptions.BookExceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
