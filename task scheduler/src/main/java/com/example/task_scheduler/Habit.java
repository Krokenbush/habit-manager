package com.example.task_scheduler;

import java.util.Map;

public class Habit {
    private String name;
    private Map <String, Integer> parameters;
    Regularity regular;
    private int times;

    Habit (String name, Map <String, Integer> parameters, Regularity regular, int times) {
        this.name = name;
        this.parameters = parameters;
        this.regular = regular;
        this.times = times;
    }
    Habit () {}

    public void setName (String name) {
        this.name = name;
    }
    public void setParameters (Map <String, Integer> parameters) {
        this.parameters = parameters;
    }
    public void setRegular(Regularity regular) {
        this.regular = regular;
    }
    public void setTimes(int times) {
        this.times = times;
    }

    public String getName () {
        return name;
    }
    public Map <String, Integer> getParameters () {
        return parameters;
    }
    public Regularity getRegular () {
        return regular;
    }
    public int getTimes () {
        return times;
    }
}
