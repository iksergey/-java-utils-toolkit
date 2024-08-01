package ru.ksergey.exception;

public class EmptyStorageException extends Exception {
    public EmptyStorageException(String message) {
        super(message);
    }
}
