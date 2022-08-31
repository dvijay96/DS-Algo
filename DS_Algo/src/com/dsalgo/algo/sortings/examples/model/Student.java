package com.dsalgo.algo.sortings.examples.model;

public class Student {

	public char id;
	public int age;

	public Student(char id, int age) {
		this.id = id;
		this.age = age;
	}

	@Override
	public String toString() {
		return "{" + id + "," + age + "}";
	}

}
