package com.problems.java.fca;

import java.util.Arrays;
import java.util.Comparator;

public class PickThePoint {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 6,9 }, { 1, 3 }, { 2, 5 } };

		System.out.println(countPoints(arr));
	}

	private static int countPoints(int[][] arr) {

		if (arr.length == 0)
			return 0;
//		printArray(arr);
		sortByColumn(arr, 0);
//		printArray(arr);
		int point = arr[0][1];
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] > point) {
				count++;
				point = arr[i][1];
			}
		}
		return count;
	}

	private static void printArray(int[][] arr) {
		for (int[] ar : arr) {
			System.out.println(Arrays.toString(ar));
		}
		System.out.println("\n------------------------------\n");
	}

	private static void sortByColumn(int[][] arr, int col) {
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[col] > o2[col])
					return 1;
				return -1;
			}
		});
	}
}
