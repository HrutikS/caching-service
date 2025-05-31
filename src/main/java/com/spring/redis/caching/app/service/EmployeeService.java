package com.spring.redis.caching.app.service;

import com.spring.redis.caching.app.domains.Employee;
import com.spring.redis.caching.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CacheManager cacheManager;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Employee registerEmployeeService(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Cacheable(value = "employee", key = "#empId")
    public Employee getEmployeeService(String empId) {

        Cache cache = cacheManager.getCache("employee");

        return employeeRepository.findById(empId).orElse(null);
    }
}