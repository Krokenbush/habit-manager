package com.example.habit_manager.Services;

import org.springframework.http.HttpStatus;

public abstract class AbstractService {
    public HttpStatus checkByNull (Object item) {
        if (item == null) {
            return HttpStatus.NOT_FOUND;
        } else {
            return HttpStatus.OK;
        }
    }
}
