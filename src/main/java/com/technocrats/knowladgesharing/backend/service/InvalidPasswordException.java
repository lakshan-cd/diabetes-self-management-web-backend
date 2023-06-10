package com.technocrats.knowladgesharing.backend.service;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException(String message) {
        super(message);
    }
}
