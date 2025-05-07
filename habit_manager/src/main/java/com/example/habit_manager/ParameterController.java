package com.example.habit_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {
    @Autowired
    ParameterRepository parameterRepository;

    @GetMapping("/insertParameter")
    public ResponseEntity<Parameter> insertParameter(@RequestParam(name = "habit_id") Long habitId) {
        Parameter param = parameterRepository.save(createParameter(habitId));
        return new ResponseEntity<>(param, HttpStatus.OK);
    }
    @GetMapping("/getParameter")
    public ResponseEntity<Parameter> getParameter(@RequestParam(name = "parameter_id") Long parameterId) {
        Parameter param = parameterRepository.findById(parameterId).orElseThrow();
        return new ResponseEntity<>(param, HttpStatus.OK);
    }

    @GetMapping("/deleteParameter")
    public ResponseEntity<Parameter> deleteParameter(@RequestParam(name = "parameter_id") Long parameterId) {
        Parameter param = parameterRepository.findById(parameterId).orElseThrow();
        ResponseEntity <Parameter> re = new ResponseEntity<>(param, HttpStatus.OK);
        parameterRepository.delete(param);
        return re;
    }

    private Parameter createParameter(Long habitId) {
        Parameter param = new Parameter();
        param.setName("quantity");
        param.setHabitId(habitId);
        param.setValue(1000000000);
        param.setDescription("number of tasks compiled per day");
        return param;
    }
}