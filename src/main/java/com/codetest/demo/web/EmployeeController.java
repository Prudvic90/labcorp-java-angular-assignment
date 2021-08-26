package com.codetest.demo.web;

import java.util.List;

import com.codetest.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codetest.demo.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController
{
    @Autowired
    EmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = service.getAllEmployees();

        return new ResponseEntity<List<Employee>>(service.listAllEmployees(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}/work")
    public ResponseEntity<List<Employee>> work(@PathVariable("id") long employeeId, @RequestParam int daysWorked) {
        return new ResponseEntity<List<Employee>>(service.work(daysWorked, employeeId), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}/takevacation")
    public ResponseEntity<List<Employee>> takeVacation(@PathVariable("id") long employeeId, @RequestParam double vacationDays) {
        List<Employee> list = service.getAllEmployees();

        return new ResponseEntity<List<Employee>>(service.takeVacation(vacationDays, employeeId), new HttpHeaders(), HttpStatus.OK);
    }
 
}