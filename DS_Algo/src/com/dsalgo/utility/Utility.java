package com.dsalgo.utility;

import com.dsalgo.algo.sortings.examples.model.Student;

public class Utility {

	public static Student[] generateInput() {
		Student[] arr = new Student[7];

		char c = 'A';

		for (int i = 0; i < arr.length; i++, c++) {
			int age = (int) (Math.random() * (7 - 1) + 1);
			arr[i] = new Student(c, age);
		}
		return arr;
	}
}
