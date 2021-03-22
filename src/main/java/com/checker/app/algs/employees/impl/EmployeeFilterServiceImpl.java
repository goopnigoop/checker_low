package com.checker.app.algs.employees.impl;

import com.checker.app.algs.employees.Employee;
import com.checker.app.algs.employees.EmployeeFilterService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;

public class EmployeeFilterServiceImpl implements EmployeeFilterService {
    @Override
    public Set<Employee> getEmployeesByMinimalCriteria(Set<Employee> employees, Map<String, Integer> criteria) {
        if (CollectionUtils.isEmpty(employees)) {
            return emptySet();
        }
        final Set<String> skillNames = criteria.keySet();
        return employees.stream()
                 .filter(employee -> MapUtils.isNotEmpty(employee.getSkillSet()))
                 .filter(employee -> employee.getSkillSet()
                                             .keySet()
                                             .containsAll(skillNames))
                 .filter(employee -> {
                     final Map<String, Integer> skillSet = employee.getSkillSet();
                     for (Map.Entry<String, Integer> stringIntegerEntry : criteria.entrySet()) {
                         final Integer currentSkillLevel = skillSet.get(stringIntegerEntry.getKey());
                         if (currentSkillLevel < stringIntegerEntry.getValue()) {
                             return false;
                         }
                     }
                     return true;
                 })
                 .collect(Collectors.toSet());
    }
}
