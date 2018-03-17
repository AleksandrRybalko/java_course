package com.epam.alexander_rybalko.java.lesson2.task3.list;

import com.epam.alexander_rybalko.java.lesson2.task3.dish.Ingredient;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;


public class MyArrayList implements MyList {
	private int size = 10000;
	private int pos = 0;
	private Ingredient[] data;

	public MyArrayList() {
		this.data = new Ingredient[size];
	}

	public void add(Ingredient object) {
		if (pos < size) {
			data[pos++] = object;
		}
	}

	public void sort(Comparator<Ingredient> comparator) {
		Arrays.sort(data, comparator);
	}

	public MyArrayList copy() {
		MyArrayList copy = new MyArrayList();
		copy.size = this.size;
		copy.pos = this.pos;
		copy.data = Arrays.copyOf(data, this.size);
		return copy;
	}

	@Override
	public Iterator<Ingredient> iterator() {

		return new Itr();
	}

	private class Itr implements Iterator<Ingredient> {
		int cursor;

		@Override
		public boolean hasNext() {
			return cursor != pos;
		}

		@Override
		public Ingredient next() {
			return data[cursor++];
		}

	}
}
