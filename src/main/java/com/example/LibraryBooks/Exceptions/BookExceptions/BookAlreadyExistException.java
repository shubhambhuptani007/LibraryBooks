package com.example.LibraryBooks.Exceptions.BookExceptions;

public class BookAlreadyExistException extends RuntimeException{
    public BookAlreadyExistException(String message) {
        super(message);
    }
}
