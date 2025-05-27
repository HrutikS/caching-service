package com.spring.redis.caching.app.controller;

import com.spring.redis.caching.app.domains.Employee;
import com.spring.redis.caching.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee registerEmployee(Employee employee) {

        return employeeService.registerEmployeeService(employee);
    }
}
