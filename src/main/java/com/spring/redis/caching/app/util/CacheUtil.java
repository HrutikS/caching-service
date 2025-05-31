package com.spring.redis.caching.app.util;

import com.spring.redis.caching.app.domains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheUtil {

    @Autowired
    private CacheManager cacheManager;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Get Cached Employee (returns null if not cached)
    public Employee getCachedEmployee(String empId) {

        Cache cache = cacheManager.getCache("employeeId");

        if (cache != null) {

            Cache.ValueWrapper valueWrapper = cache.get(empId);

            if (valueWrapper != null) {
                return (Employee) valueWrapper.get();
            }
        }

        return null;
    }
}
