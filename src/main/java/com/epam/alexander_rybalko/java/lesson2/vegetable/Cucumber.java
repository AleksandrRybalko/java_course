package com.epam.alexander_rybalko.java.lesson2.vegetable;

public class Cucumber extends MelonVegetable {
    private static final String NAME = "Cucumber";
    private static final Nutritive NUTRITIVE = new Nutritive(23, 12, 21, 14);

    public Cucumber() {
        super(NAME, NUTRITIVE);
    }

}
