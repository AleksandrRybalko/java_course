package com.epam.alexander_rybalko.java.lesson2.vegetable;

public class Potato extends TuberVegetable {
    private static final String NAME = "potato";
    private static final Nutritive NUTRITIVE = new Nutritive(27, 11, 21, 25);

    public Potato() {
        super(NAME, NUTRITIVE);
    }

}
