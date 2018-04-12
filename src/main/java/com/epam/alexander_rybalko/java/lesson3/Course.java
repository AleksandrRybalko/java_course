package com.epam.alexander_rybalko.java.lesson3;

public class Course {
	private String name;
	// duration in hours
	private Number duration;

	public Course(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return this.name;
	}

	public int getDuration() {
		return this.duration.intValue();
	}
}
