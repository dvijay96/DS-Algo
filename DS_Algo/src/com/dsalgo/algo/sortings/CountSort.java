package com.dsalgo.algo.sortings;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {

		int[] arr = { 4, 6, 5, 3 };

		sortDesc(arr);

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

	static void sortDesc(int[] arr) {

		int max = Arrays.stream(arr).max().getAsInt();

		int[] countArr = new int[max + 1];

		for (int i : arr) {
			countArr[max - i]++;
		}

		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		int[] output = new int[arr.length];

		for (int i : arr) {
			countArr[max - i]--;
			output[countArr[max - i]] = i;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}
}
