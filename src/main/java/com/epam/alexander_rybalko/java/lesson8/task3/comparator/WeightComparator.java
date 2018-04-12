package com.epam.alexander_rybalko.java.lesson8.task3.comparator;

import java.util.Comparator;

import com.epam.alexander_rybalko.java.lesson8.task3.dish.Ingredient;


public class WeightComparator implements Comparator<Ingredient> {

    @Override
    public int compare(Ingredient o1, Ingredient o2) {
        return (o1 == null) ? ((o2 == null) ? 0 : 1) : (o2 == null) ? -1 : (int) (o1.getWeight() - o2.getWeight());
    }

}
