package com.spring.redis.caching.app.repository;

import com.spring.redis.caching.app.domains.Employee;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @Autowired
    private EmployeeRepository employeeRepository;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Employee registerEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }
}
