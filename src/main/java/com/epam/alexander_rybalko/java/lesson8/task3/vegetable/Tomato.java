package com.epam.alexander_rybalko.java.lesson8.task3.vegetable;

public class Tomato extends NightshadeVegetable {
	private static final String NAME = "tomato";
	private static final Nutritive NUTRITIVE = new Nutritive(25, 13, 7, 22);

	public Tomato() {
		super(NAME, NUTRITIVE);
	}

	public Tomato(Nutritive nutritive) {
		super(NAME, nutritive);
	}
}
