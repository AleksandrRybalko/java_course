package com.epam.alexander_rybalko.java.lesson4.task3.exception;

public class BadNameOfVegetableException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Bad name of vegetable!";
	}
}
