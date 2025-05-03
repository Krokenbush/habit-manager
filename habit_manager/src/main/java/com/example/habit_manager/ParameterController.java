package com.example.habit_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {
    @Autowired
    ParameterRepository parameterRepository;

    @GetMapping("/insertParameter")
    public ResponseEntity<Parameter> insertParameter() {
        Parameter param = parameterRepository.save(createParameter());
        return new ResponseEntity<>(param, HttpStatus.OK);
    }

    private Parameter createParameter() {
        Parameter param = new Parameter();
        param.setName("quantity");
        param.setValue(1000000000);
        param.setDescription("number of tasks compiled per day");
        return param;
    }
}