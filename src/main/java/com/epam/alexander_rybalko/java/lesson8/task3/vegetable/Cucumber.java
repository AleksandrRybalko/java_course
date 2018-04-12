package com.epam.alexander_rybalko.java.lesson8.task3.vegetable;

public class Cucumber extends MelonVegetable {
	private static final String NAME = "Cucumber";
	private static final Nutritive NUTRITIVE = new Nutritive(23, 12, 21, 14);

	public Cucumber() {
		super(NAME, NUTRITIVE);
	}

	public Cucumber(Nutritive nutritive) {
		super(NAME, nutritive);
	}
}
