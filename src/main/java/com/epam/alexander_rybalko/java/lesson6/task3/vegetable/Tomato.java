package com.epam.alexander_rybalko.java.lesson6.task3.vegetable;

public class Tomato extends NightshadeVegetable {
    private static final String NAME = "tomato";
    private static final Nutritive NUTRITIVE = new Nutritive(25, 13, 7, 22);

    public Tomato() {
        super(NAME, NUTRITIVE);
    }

}
