package com.example.habit_manager.Services;

import com.example.habit_manager.DAO.Module.Parameter;
import com.example.habit_manager.DAO.Repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ParameterService extends AbstractService {
    @Autowired
    ParameterRepository parameterRepository;

    public ResponseEntity <Parameter> insertParameter (Long habitId) {
        Parameter param = parameterRepository.save(createParameter(habitId));
        return new ResponseEntity<>(param, HttpStatus.OK);
    }

    public ResponseEntity <Parameter> getParameter (Long parameterId) {
        Parameter param = parameterRepository.findById(parameterId).orElse(null);
        return new ResponseEntity<>(param, checkByNull(param));
    }

    public ResponseEntity <Parameter> deleteParameter (Long parameterId) {
        Parameter param = parameterRepository.findById(parameterId).orElse(null);
        if (param == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            parameterRepository.deleteAllByHabitId(parameterId);
            parameterRepository.delete(param);
            return new ResponseEntity<>(param, HttpStatus.OK);
        }
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
