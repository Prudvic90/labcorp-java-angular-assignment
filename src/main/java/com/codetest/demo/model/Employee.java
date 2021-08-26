package com.codetest.demo.model;


public class Employee {
    private long id;
    private String employeeName;
    private EmployeeType employeeType;
    private double maxVacationDays;
    private int workDays;
    private double vacationDays;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public double getMaxVacationDays() {
        return maxVacationDays;
    }

    public void setMaxVacationDays(double maxVacationDays) {
        this.maxVacationDays = maxVacationDays;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(double vacationDays) {
        this.vacationDays = vacationDays;
    }
}
