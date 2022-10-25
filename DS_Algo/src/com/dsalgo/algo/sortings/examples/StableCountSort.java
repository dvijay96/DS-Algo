package com.dsalgo.algo.sortings.examples;

import java.util.Arrays;

import com.dsalgo.algo.sortings.examples.model.Student;
import com.dsalgo.utility.Utility;

public class StableCountSort {

	public static void main(String[] args) {
		stableCountSortExample();
		System.out.println();
		stableCountSortExampleDesc();
	}

	public static void stableCountSortExample() {
		System.out.println("Stable count sort!!!");
		Student[] arr = Utility.generateInput();

		System.out.println("Before -> " + Arrays.toString(arr));
		stableCountSort(arr);
		System.out.println("After -> " + Arrays.toString(arr));
	}

	private static void stableCountSort(Student[] arr) {
		int maxAge = arr[0].age;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i].age > maxAge)
				maxAge = arr[i].age;
		}

		int[] countArr = new int[maxAge + 1];

		for (int i = 0; i < arr.length; i++) {

			int age = arr[i].age;
			countArr[age]++;
		}

		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		Student[] output = new Student[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			int age = arr[i].age;
			--countArr[age];
			output[countArr[age]] = arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	public static void stableCountSortExampleDesc() {
		System.out.println("Stable desc count sort!!!");
		Student[] arr = Utility.generateInput();

		System.out.println("Before -> " + Arrays.toString(arr));
		stableCountSortDesc(arr);
		System.out.println("After -> " + Arrays.toString(arr));
	}

	private static void stableCountSortDesc(Student[] arr) {

		int max = arr[0].age;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i].age > max)
				max = arr[i].age;
		}

		int[] countArr = new int[max + 1];

		for (Student s : arr) {
			countArr[max - s.age]++;
		}

		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		Student[] output = new Student[arr.length];

		for (Student s : arr) {
			countArr[max - s.age]--;
			output[countArr[max - s.age]] = s;
		}

		for (int i = 0; i < arr.length; i++)
			arr[i] = output[i];
	}
}
