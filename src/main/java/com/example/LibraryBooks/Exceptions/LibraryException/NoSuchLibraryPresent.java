package com.example.LibraryBooks.Exceptions.LibraryException;

public class NoSuchLibraryPresent extends RuntimeException{
    public NoSuchLibraryPresent(String message) {
        super(message);
    }
}
