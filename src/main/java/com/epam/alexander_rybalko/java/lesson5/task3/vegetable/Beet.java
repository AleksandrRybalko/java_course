package com.epam.alexander_rybalko.java.lesson5.task3.vegetable;

public class Beet extends rootVegetable {
    private static final String NAME = "beet";
    private static final Nutritive NUTRITIVE = new Nutritive(15, 10, 15, 20);

    public Beet() {
        super(NAME, NUTRITIVE);
    }

}
