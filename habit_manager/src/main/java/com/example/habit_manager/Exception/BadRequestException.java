package com.example.habit_manager.Exception;

public class BadRequestException extends Exception {
    BadRequestException(String message) {
        super(message);
    }
}
