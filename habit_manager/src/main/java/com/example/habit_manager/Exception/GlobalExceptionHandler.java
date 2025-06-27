package com.example.habit_manager.Exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    /*@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException (NotFoundException e) {
        return buildResponse(
                HttpStatus.NOT_FOUND,
                "Данные не найдены.",
                e.getMessage()
        );
    }*/

    /*@ExceptionHandler({BadRequestException.class, NoResourceFoundException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestException (Exception e) {
        return buildResponse(
                HttpStatus.BAD_REQUEST,
                "Некорректный запрос.",
                e.getMessage()
        );
    }*/

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException (NotFoundException e, Model model) {
        model.addAttribute("status", HttpStatus.NOT_FOUND);
        model.addAttribute("userMessage","Данные не найдены.");
        model.addAttribute("details", e.getMessage());
        return "Error";
    }

    @ExceptionHandler({BadRequestException.class, NoResourceFoundException.class, NullPointerException.class})
    public String handleBadRequestException (Exception e, Model model) {
        model.addAttribute("status", HttpStatus.BAD_REQUEST);
        model.addAttribute("userMessage","Некорректный запрос.");
        model.addAttribute("details", e.getMessage());
        return "Error";
    }

    /*private ResponseEntity<ErrorResponse> buildResponse (HttpStatus status, String message, String ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                status.getReasonPhrase(),
                message,
                ex
        );
        return new ResponseEntity<>(errorResponse, status);
    }*/
}
