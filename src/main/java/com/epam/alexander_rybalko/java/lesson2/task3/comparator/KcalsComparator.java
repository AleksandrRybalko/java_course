package com.epam.alexander_rybalko.java.lesson2.task3.comparator;

import com.epam.alexander_rybalko.java.lesson2.task3.dish.Ingredient;

import java.util.Comparator;

public class KcalsComparator implements Comparator<Ingredient> {

    @Override
    public int compare(Ingredient o1, Ingredient o2) {
        return (o1 == null) ? ((o2 == null) ? 0 : 1)
                : (o2 == null) ? -1 : (int) (o1.getTotalKcals() - o2.getTotalKcals());
    }

}
