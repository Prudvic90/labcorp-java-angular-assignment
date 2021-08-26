package com.codetest.demo.service;

import java.util.*;
import java.util.stream.Collectors;

import com.codetest.demo.model.Employee;
import com.codetest.demo.model.EmployeeType;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;

@Service
public class EmployeeService {

    private Map<Long, Employee> global = new HashMap<>();


    @PostConstruct
    public void init() {
        String[] employeeName = {"Aaron, Hank",
                "Abagnale, Frank",
                "Abbey, Edward",
                "Abel, Reuben",
                "Abelson, Hal",
                "Abourezk, James",
                "Abrams, Creighton",
                "Ace, Jane",
                "Acton, John (Lord Acton)",
                "Adams, Abigail",
                "Adams, Douglas",
                "Adams, Henry",
                "Adams, John",
                "Adams, John Quincy",
                "Adams, Samuel",
                "Adams, Scott",
                "Addams, Jane",
                "Addison, Joseph",
                "Adorno, Theodor",
                "Adler, Alfred",
                "Aeschylus",
                "Aesop",
                "Affleck, Ben",
                "Agena, Keiko",
                "Agnew, Spiro",
                "Ahbez, Eden",
                "Ahern, Bertie",
                "Ah Koy, James",
                "Ahmad",
                "Aiken, Clay",
                "Aiken, Conrad",
                "Akinola, Peter Jasper (Archbishop)"};
        for (int i = 1; i <= 30; i++) {
            Employee employee = new Employee();
            employee.setEmployeeName(employeeName[i]);
            employee.setVacationDays(0);
            employee.setWorkDays(0);

            if (i <= 10) {
                employee.setId(i);
                employee.setEmployeeType(EmployeeType.HOURLY);
                employee.setMaxVacationDays(10);
            } else if (i <= 20) {
                employee.setId(i);
                employee.setEmployeeType(EmployeeType.SALARIED);
                employee.setMaxVacationDays(15);

            } else {
                employee.setId(i);
                employee.setEmployeeType(EmployeeType.MANAGER);
                employee.setMaxVacationDays(30);
            }
            global.put(employee.getId(), employee);
        }
    }

    public List<Employee> listAllEmployees() {
        return global.values().stream()
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        if (employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Employee> work(int daysWorked, long employeeId) {
        try {
            if (daysWorked < 0 || daysWorked > 260) {
                throw new Exception("Days worked should be between 0 and 260");
            }
            Employee employee = global.get(employeeId);
            long accruedVacationDays = (long) ((employee.getMaxVacationDays() * daysWorked) / 260);
            employee.setVacationDays(accruedVacationDays);
            employee.setWorkDays(daysWorked);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAllEmployees();
    }

    public List<Employee> takeVacation(double vacationDays, long employeeId) {
        try {
            Employee employee = global.get(employeeId);
            if (employee.getVacationDays() < vacationDays) {
                throw new Exception("No sufficient vacation days");
            }
            employee.setVacationDays(employee.getVacationDays() - vacationDays);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAllEmployees();
    }

}