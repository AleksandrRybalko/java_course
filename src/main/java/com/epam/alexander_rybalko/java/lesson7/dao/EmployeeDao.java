package com.epam.alexander_rybalko.java.lesson7.dao;

import com.epam.alexander_rybalko.java.lesson7.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    void createEmployeeTable();

    void insert(Employee employee);

    List<Employee> getAll();
}
