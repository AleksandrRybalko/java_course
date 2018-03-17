package com.epam.alexander_rybalko.java.lesson2.dish;

import com.epam.alexander_rybalko.java.lesson2.comparator.KcalsComparator;
import com.epam.alexander_rybalko.java.lesson2.comparator.WeightComparator;
import com.epam.alexander_rybalko.java.lesson2.list.MyArrayList;
import com.epam.alexander_rybalko.java.lesson2.vegetable.Vegetable;

public class Salad {
    private String name;
    private MyArrayList ingredients;

    public Salad() {
        this("unnamed");
    }

    public Salad(String name) {
        this.name = name;
        this.ingredients = new MyArrayList();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addIngredient(Vegetable vegetable, double weight) {
        this.ingredients.add(new Ingredient(vegetable, weight));
    }

    public void sortByWeight() {
        this.ingredients.sort(new WeightComparator());
    }

    public void sortByKcals() {
        this.ingredients.sort(new KcalsComparator());
    }

    public MyArrayList getIngredients() {
        return this.ingredients.copy();
    }

    public double getTotalCalories() {
        double totalCalories = 0.0;
        for (Ingredient ingredient : this.ingredients) {
            totalCalories += ingredient.getTotalKcals();
        }
        return totalCalories;
    }

    public void showIngredients() {
        System.out.println("Ingredients of salad are:");
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.print() + "\n");
        }
    }
}
