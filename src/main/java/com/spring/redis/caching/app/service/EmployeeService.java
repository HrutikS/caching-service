package com.spring.redis.caching.app.service;

import com.spring.redis.caching.app.domains.Employee;
import com.spring.redis.caching.app.repository.EmployeeRepository;
import com.spring.redis.caching.app.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CacheUtil cacheUtil;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Cacheable(value = "employee", key = "#employee.empId")
    public Employee registerEmployeeService(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeService(String empId) {

        // Check cache and get employee
        Employee cachedEmployee = cacheUtil.getCachedEmployee(empId);

        // If cached employee exists, return it
        if (cachedEmployee != null) {
            return cachedEmployee;
        }

        // Fetch from repository
        return employeeRepository.findById(empId).orElse(null);
    }
}