package com.epam.alexander_rybalko.java.lesson6.task3.vegetable;

public class Carrot extends rootVegetable {
    private static final String NAME = "carrot";
    private static final Nutritive NUTRITIVE = new Nutritive(18, 7, 13, 21);

    public Carrot() {
        super(NAME, NUTRITIVE);
    }

}
