package com.example.habit_manager.Services;

import com.example.habit_manager.Exception.NotFoundException;
import org.springframework.http.HttpStatus;

public abstract class AbstractService {
    public HttpStatus checkByNull (Object item) throws NotFoundException {
        if (item == null) {
            throw new NotFoundException("Данные не найдены.");
        } else {
            return HttpStatus.OK;
        }
    }
}
