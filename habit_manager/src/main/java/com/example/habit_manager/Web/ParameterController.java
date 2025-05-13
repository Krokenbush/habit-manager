package com.example.habit_manager.Web;

import com.example.habit_manager.DAO.Module.Parameter;
import com.example.habit_manager.Services.ParameterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping("/insertParameter")
    public ResponseEntity<Parameter> insertParameter(@RequestParam(name = "habit_id") Long habitId) {
        return parameterService.insertParameter(habitId);
    }

    @GetMapping("/getParameter")
    public ResponseEntity<Parameter> getParameter(@RequestParam(name = "parameter_id") Long parameterId) {
        return parameterService.getParameter(parameterId);
    }

    @Transactional
    @GetMapping("/deleteParameter")
    public ResponseEntity<Parameter> deleteParameter(@RequestParam(name = "parameter_id") Long parameterId) {
       return parameterService.deleteParameter(parameterId);
    }
}