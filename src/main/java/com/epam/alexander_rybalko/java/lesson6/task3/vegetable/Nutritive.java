package com.epam.alexander_rybalko.java.lesson6.task3.vegetable;

import java.io.Serializable;

public class Nutritive implements Serializable {

	private static final long serialVersionUID = 1L;

	private double kcals;
	private double proteins;
	private double fats;
	private double carbohydrates;

	public Nutritive(double kcals, double proteins, double fats, double carbohydrates) {
		this.kcals = kcals;
		this.proteins = proteins;
		this.fats = fats;
		this.carbohydrates = carbohydrates;
	}

	public double getKcals() {
		return this.kcals;
	}

	public double getProteins() {
		return this.proteins;
	}

	public double getFats() {
		return this.fats;
	}

	public double getCarbohydrates() {
		return this.carbohydrates;
	}

	@Override
	public String toString() {
		return "Nutritive [kcals=" + this.kcals + ", proteins=" + this.proteins + ", fats=" + this.fats
				+ ", carbohydrates=" + this.carbohydrates + "]";
	}

	public String print() {
		return "By 100g: kcals - " + this.getKcals() + ", proteints - " + this.getProteins() + ", fats - "
				+ this.getFats() + ", carbohydrates - " + this.getCarbohydrates();
	}

}
