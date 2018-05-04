package com.epam.alexander_rybalko.java.lesson7;

import com.epam.alexander_rybalko.java.lesson7.dao.EmployeeDao;
import com.epam.alexander_rybalko.java.lesson7.daoImpl.EmployeeDaoImpl;
import com.epam.alexander_rybalko.java.lesson7.entities.Employee;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ConnectionConfig connectionConfig = new ConnectionConfig();
        connectionConfig.process("jdbc:postgresql://localhost:5432/TestDB", "test", "test");

        EmployeeDao employeeDao = new EmployeeDaoImpl(connectionConfig);
        employeeDao.createEmployeeTable();
        employeeDao.insert(new Employee("Alex", "Rybalko"));
        List<Employee> employees = employeeDao.getAll();
        for (int i = 0; i < 10; i++) {
            for (Employee employee : employees) {
                employeeDao.insert(employee);
            }
        }
        connectionConfig.close();
    }
}
