package com.dsalgo.algo.sortings;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 0, 0, -1 };

		sortMix(arr);

		System.out.println(Arrays.toString(arr));

	}

	/**
	 * Sorts the array in ASC order
	 * 
	 * @apiNote Only works for arrays with positive integers.
	 * @param arr
	 */
	static void sort(int[] arr) {

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		int[] countArr = new int[max + 1];

		for (int i = 0; i < arr.length; i++) {
			countArr[arr[i]]++;
		}

		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		int[] output = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			output[countArr[arr[i]] - 1] = arr[i];
			countArr[arr[i]]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	/**
	 * Sorts the array in ASC order
	 * 
	 * @apiNote works for arrays with both positive and negative integer
	 * @param arr
	 */
	static void sortMix(int[] arr) {

		int max = arr[0];
		int min = arr[0];

		for (int i : arr) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}

		int[] countArr = new int[max - min + 1];

		for (int i = 0; i < arr.length; i++) {
			countArr[arr[i] - min]++;
		}

		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		int[] output = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			output[countArr[arr[i] - min] - 1] = arr[i];
			countArr[arr[i] - min]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	/**
	 * Example to show how count sort is stable
	 */
	public void stableCountSortExample() {
		Student[] arr = new Student[10];

		char c = 'A';
		for (int i = 0; i < arr.length; i++, c++) {
			int age = (int) (Math.random() * (10 - 1) + 1);
			Student s = new Student(c, age);
			arr[i] = s;
		}

		System.out.println("Before -> " + Arrays.toString(arr));

		sort(arr);

		System.out.println("After -> " + Arrays.toString(arr));
	}

	private void sort(Student[] arr) {

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
}

class Student {

	protected char name;
	protected int age;

	Student(char name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "{" + name + "," + age + "}";
	}

}
