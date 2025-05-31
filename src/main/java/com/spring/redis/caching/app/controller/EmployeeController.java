package com.spring.redis.caching.app.controller;

import com.spring.redis.caching.app.domains.Employee;
import com.spring.redis.caching.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<>(
                employeeService.registerEmployeeService(employee),
                HttpStatus.CREATED
        );
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@RequestParam String empId) {

        return new ResponseEntity<>(
                employeeService.getEmployeeService(empId),
                HttpStatus.OK
        );
    }
}
