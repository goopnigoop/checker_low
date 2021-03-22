package com.checker.app.algs.employees.impl;

import com.checker.app.algs.employees.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

class EmployeeFilterServiceImplTest {

    EmployeeFilterServiceImpl employeeFilterService = new EmployeeFilterServiceImpl();

    static Set<Employee> employeeSet;

    @BeforeAll
    static void setUp() {
        employeeSet = Set.of(
                new Employee("first", Map.of("Java", 1, "Kotlin", 2, "SQL", 3)),
                new Employee("second", Map.of("Java", 3, "Kotlin", 3, "SQL", 2)),
                new Employee("third", Map.of("Java", 2, "Kotlin", 4, "SQL", 3)),
                new Employee("fourth", Map.of("Java", 4, "Kotlin", 1, "SQL", 5)),
                new Employee("fifth", Map.of("Java", 5, "Kotlin", 2, "SQL", 1, "Groovy", 3))
        );
    }

    @Test
    void shouldFindTheOneWithGroovy() {
        final Set<Employee> setOfEmployees = employeeFilterService.getEmployeesByMinimalCriteria(employeeSet, Map.of("Groovy", 3));
        assertThat(setOfEmployees, hasSize(1));
        assertThat(setOfEmployees, hasItem(hasProperty("name", is("fifth"))));
    }

    @Test
    void shouldNotFindTheOneWithGroovyWithHighLevel() {
        final Set<Employee> setOfEmployees = employeeFilterService.getEmployeesByMinimalCriteria(employeeSet, Map.of("Groovy", 4));
        assertThat(setOfEmployees, hasSize(0));
    }

    @Test
    void shouldFindThreeSpecialists() {
        final Set<Employee> setOfEmployees = employeeFilterService.getEmployeesByMinimalCriteria(employeeSet, Map.of("Java", 1,
                                                                                                                     "Kotlin", 2, "SQL", 3));
        assertThat(setOfEmployees, hasSize(2));
        assertThat(setOfEmployees, hasItem(hasProperty("name", is("first"))));
        assertThat(setOfEmployees, hasItem(hasProperty("name", is("third"))));
    }
}