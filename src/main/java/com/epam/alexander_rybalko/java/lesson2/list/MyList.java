package com.epam.alexander_rybalko.java.lesson2.list;

import com.epam.alexander_rybalko.java.lesson2.dish.Ingredient;

import java.util.Comparator;


public interface MyList extends Iterable<Ingredient> {
    public void add(Ingredient ingredient);

    public void sort(Comparator<Ingredient> comparator);

    public MyList copy();

}
