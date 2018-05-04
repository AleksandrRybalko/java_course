package com.epam.alexander_rybalko.java.lesson7.entities;

public class Employee {
    private int id;
    private String firstname;
    private String lastname;

    public Employee() {

    }

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String print() {
        return ((this.id > 0) ? this.id : "") + " " + this.firstname + " " + this.lastname;
    }
}
