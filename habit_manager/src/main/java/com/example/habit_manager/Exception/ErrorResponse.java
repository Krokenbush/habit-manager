package com.example.habit_manager.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String status;
    private String userMessage;
    private String details;
}
