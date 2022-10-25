package com.problems.java.fca;

import java.util.Arrays;

public class ChildrenDay {

	public static void main(String[] args) {

		int[] arr = new int[] { 100, 20, 40, 20, 50, 50 };
		int k = 4;

		int pos = -1;
		if (arr.length % 2 == 0)
			pos = (arr.length / 2) - 1;
		else
			pos = arr.length / 2;
		Arrays.parallelSort(arr);
		System.out.println(arr[pos]);
	}

	private static void approach1() {
		int arr1[] = new int[] { 4, 17, 77, 25, 22, 23, 92, 82, 40, 24, 14, 12, 67, 23, 29 };

		Arrays.sort(arr1);

		int pos;
		if (arr1.length % 2 == 0) {
			pos = (arr1.length / 2) - 1;
		} else {
			pos = arr1.length / 2;
		}

		System.out.println(arr1[pos]);
	}

}
