package com.example.LibraryBooks.Exceptions.LibrarianException;

public class NoSuchLibrarianFound extends RuntimeException{
    public NoSuchLibrarianFound(String message) {
        super(message);
    }
}
