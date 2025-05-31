package com.spring.redis.caching.app.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@Entity(name = "employee")
public class Employee {

    private String name;

    @Id
    private String empId;
}