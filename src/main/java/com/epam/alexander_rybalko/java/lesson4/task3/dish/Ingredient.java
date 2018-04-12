package com.epam.alexander_rybalko.java.lesson4.task3.dish;

import com.epam.alexander_rybalko.java.lesson4.task3.vegetable.Vegetable;

public class Ingredient {

    private Vegetable vegetable;
    private double weight;

    public Ingredient(Vegetable vegetable, double weight) {
        this.vegetable = vegetable;
        this.weight = weight;
    }

    public Vegetable getVegetable() {
        return this.vegetable;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getTotalKcals() {
        return this.vegetable.getNutritive().getKcals() * this.weight / 100;
    }

    @Override
    public String toString() {
        return "Ingredient [vegetable=" + this.vegetable + ", weight=" + this.weight + "]";
    }

    public String print() {
        return this.vegetable.print() + "\nWeight: " + this.getWeight();
    }

}
