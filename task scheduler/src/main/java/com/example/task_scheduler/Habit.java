package com.example.task_scheduler;

import java.util.ArrayList;
import java.util.Map;

public class Habit {
    private final String name;
    private final int inf = Integer.MAX_VALUE;
    private final int regular; // day = 1, month = 2, year = 3
    private final int times;
    private int curStreak = 0;
    private int bestStreak = 0;
    private Date lastExecution = new Date();
    private Map <String, Integer> parameters;
    private Map <String, ArrayList<Integer>> memoryParameters;
    int[][][][] calendar = new int[3000][12][31][24];

    Habit (String name, int regular, int times, Map <String, Integer> parameters) {
        this.name = name;
        this.regular = regular;
        this.times = times;
        this.parameters = parameters;
    }

    public void update (Date date, Map <String, Integer> done) {
        if (date != lastExecution) {
            int cnt = 0;
            switch (regular) {
                case 1:
                    for (int i = 0; i < 24; ++i) {
                        if (calendar[lastExecution.year][lastExecution.month][lastExecution.day][i] == 1) {
                            cnt++;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 31; ++i) {
                        int counter = 0;
                        for (int j = 0; j < 24; ++j) {
                            if (calendar[lastExecution.year][lastExecution.month][i][j] == 1) {
                                counter++;
                            }
                        }
                        if (counter == 24) {
                            cnt++;
                        }
                    }
                    break;
                case 3:
                    for (int k = 0; k < 12; ++k) {
                        int counter = 0;
                        for (int i = 0; i < 31; ++i) {
                            for (int j = 0; j < 24; ++j) {
                                if (calendar[lastExecution.year][lastExecution.month][i][j] == 1) {
                                    counter++;
                                }
                            }
                        }
                        if (counter == 24 * 31) {
                            cnt++;
                        }
                    }
                    break;
            }
            if (cnt >= times) {
                curStreak++;
                bestStreak = Math.max(bestStreak, curStreak);
            }
        }

        boolean flag = true;
        for (Map.Entry <String, Integer> entry : parameters.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (parameters.getOrDefault(key, inf) > value) {
                flag = false;
            }
        }
        if (flag) {
            switch (regular) {
                case 1:
                    calendar[date.year][date.month][date.day][date.hour] = 1;
                    break;
                case 2:
                    for (int i = 0; i < 24; ++i) {
                        calendar[date.year][date.month][date.day][i] = 1;
                    }
                    break;
                case 3:
                    for (int i = 0; i < 31; ++i) {
                        for (int j = 0; j < 24; ++j) {
                            calendar[date.year][date.month][i][j] = 1;
                        }
                    }
                    break;
            }
        }
        lastExecution = date;
    }

    public void changeParameter (String name, int newValue) {
        ArrayList <Integer> tmp = memoryParameters.get(name);
        tmp.add(newValue);
        memoryParameters.put(name, tmp);
        parameters.put(name, newValue);
    }

    public int getNowStreak () {
        return curStreak;
    }

    public int getBestStreak () {
        return bestStreak;
    }

    public Map <String, Integer> getParameters () {
        return parameters;
    }

    public Map <String, ArrayList<Integer>> getMemoryParameters () {
        return memoryParameters;
    }

    public int[][][][] getCalendar() {
        return calendar;
    }
}
