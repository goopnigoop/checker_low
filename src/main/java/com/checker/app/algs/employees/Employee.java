package com.checker.app.algs.employees;

import lombok.Data;

import java.util.Map;

@Data
public class Employee {
    private String name;
    private Map<String, Integer> skillSet;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Map<String, Integer> skillSet) {
        this.name = name;
        this.skillSet = skillSet;
    }

    public Map<String, Integer> getSkillSet() {
        return Map.copyOf(skillSet);
    }

    public void setSkill(String skillName, Integer level) {
        skillSet.merge(skillName,level,(integer, integer2) -> integer>integer2?integer:integer2);
    }
}
