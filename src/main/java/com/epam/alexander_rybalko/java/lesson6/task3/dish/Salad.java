package com.epam.alexander_rybalko.java.lesson6.task3.dish;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.epam.alexander_rybalko.java.lesson6.task3.comparator.KcalsComparator;
import com.epam.alexander_rybalko.java.lesson6.task3.comparator.WeightComparator;
import com.epam.alexander_rybalko.java.lesson6.task3.vegetable.Vegetable;

public class Salad implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<Ingredient> ingredients;

	public Salad() {
		this("unnamed");
	}

	public Salad(String name) {
		this.name = name;
		this.ingredients = new ArrayList<>();
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

	public List<Ingredient> getIngredients() {
		return this.ingredients;
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
