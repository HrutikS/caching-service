package com.spring.redis.caching.app.repository;

import com.spring.redis.caching.app.domains.Employee;

public interface EmployeeRepositoryCustom {

    Employee registerEmployee(Employee employee);
}
