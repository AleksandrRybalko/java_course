package com.epam.alexander_rybalko.java.lesson2.task3.vegetable;

public abstract class Vegetable {

    private String name;
    private Nutritive nutritive;

    public Vegetable(String name, Nutritive nutritive) {
        this.name = name;
        this.nutritive = nutritive;
    }

    public String getName() {
        return this.name;
    }

    public Nutritive getNutritive() {
        return this.nutritive;
    }

    @Override
    public String toString() {
        return "Vegetable [name=" + this.name + ", nutritive=" + this.nutritive + "]";
    }

    public String print() {
        return "Name: " + this.name + " (" + this.nutritive.print() + ") ";
    }
}
