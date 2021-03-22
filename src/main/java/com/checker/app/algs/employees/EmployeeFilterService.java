package com.checker.app.algs.employees;

import java.util.Map;
import java.util.Set;

public interface EmployeeFilterService {
    Set<Employee> getEmployeesByMinimalCriteria(Set<Employee> employees, Map<String, Integer> criteria);
}
