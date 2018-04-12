package com.epam.alexander_rybalko.java.lesson4.task3.list;

import java.util.Comparator;

import com.epam.alexander_rybalko.java.lesson4.task3.dish.Ingredient;


public interface MyList extends Iterable<Ingredient> {
    public void add(Ingredient ingredient);

    public void sort(Comparator<Ingredient> comparator);

    public MyList copy();

}
