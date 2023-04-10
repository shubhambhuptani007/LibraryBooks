package com.example.LibraryBooks.GlobalExceptionHandler;

public class ResponseException {
    String exception;

    public ResponseException(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
