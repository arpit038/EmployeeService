package com.example.employee;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Arpit Agarwal on 21/06/20
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeServiceController {

    private static List<Employee> employeeDB;

    static {
        employeeDB = new ArrayList<>();
        Employee employee = new Employee("101", "John Doe");
        employeeDB.add(employee);
        employee = new Employee("102", "Peter Parker");
        employeeDB.add(employee);
    }

    @GetMapping(value = "/getAllEmployees", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> getAllEmployees() {
        log.info("Returning all employees details...");
        return employeeDB;
    }
}
