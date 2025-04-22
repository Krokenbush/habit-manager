package com.example.task_scheduler;

public class Date {
    public int year = -1;
    public int month = -1;
    public int day = -1;
    public int hour = -1;
    Date(int year, int month, int day, int hour) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
    }
    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    Date(int year, int month) {
        this.year = year;
        this.month = month;
    }
    Date(int year) {
        this.year = year;
    }
    Date() {}
}
