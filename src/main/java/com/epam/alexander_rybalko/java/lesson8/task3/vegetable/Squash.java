package com.epam.alexander_rybalko.java.lesson8.task3.vegetable;

public class Squash extends MelonVegetable {
	private static final String NAME = "squash";
	private static final Nutritive NUTRITIVE = new Nutritive(15, 17, 18, 29);

	public Squash() {
		super(NAME, NUTRITIVE);
	}

	public Squash(Nutritive nutritive) {
		super(NAME, nutritive);
	}
}
