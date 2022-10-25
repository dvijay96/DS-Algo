package com.problems.java.fca;

import java.util.Arrays;

public class AnnualDay {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		int sum = 0;
		int prevType = -1;
		for (int i = 0; i < arr.length; i++) {
			int[] temp = Arrays.copyOf(arr[i], arr[i].length);
			Arrays.sort(temp);
			for (int j = 0; j < temp.length;) {
				if (prevType == linearSearch(arr[i], temp[j])) {
					j++;
				} else {
					prevType = linearSearch(arr[i], temp[j]);
					sum += temp[j];
					break;
				}

			}
		}
		System.out.println(sum);
	}

	private static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
		}
		return -1;
	}
}
