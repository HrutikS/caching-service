package com.spring.redis.caching.app.service;

import com.spring.redis.caching.app.domains.Employee;
import com.spring.redis.caching.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Employee registerEmployeeService(Employee employee) {

        return employeeRepository.registerEmployee(employee);
    }
}
