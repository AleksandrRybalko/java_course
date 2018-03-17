package com.epam.alexander_rybalko.java.lesson2.vegetable;

public class Cabbage extends CabbageVegetable {
    private static final String NAME = "cabbage";
    private static final Nutritive NUTRITIVE = new Nutritive(25, 15, 8, 13);

    public Cabbage() {
        super(NAME, NUTRITIVE);
    }

}
