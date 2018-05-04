package com.epam.alexander_rybalko.java.lesson7.daoImpl;

import com.epam.alexander_rybalko.java.lesson7.ConnectionConfig;
import com.epam.alexander_rybalko.java.lesson7.dao.EmployeeDao;
import com.epam.alexander_rybalko.java.lesson7.entities.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private ConnectionConfig connectionConfig;

    public EmployeeDaoImpl(ConnectionConfig connectionConfig) {
        this.connectionConfig = connectionConfig;
    }

    @Override
    public void createEmployeeTable() {
        try {
            Connection connection = this.connectionConfig.getConnection();
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS employees(id SERIAL PRIMARY KEY UNIQUE, " +
                    "firstname VARCHAR(225), lastname VARCHAR(225))";
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insert(Employee employee) {
        try {
            Connection connection = this.connectionConfig.getConnection();
            String query = "INSERT INTO employees (firstname, lastname) VALUES(?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstname());
            statement.setString(2, employee.getLastname());
            statement.executeUpdate();
            System.out.println(employee.print() + " was inserted into table employees!");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = this.connectionConfig.getConnection();
            String query = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstname(resultSet.getString("firstname"));
                employee.setLastname(resultSet.getString("lastname"));
                employees.add(employee);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
