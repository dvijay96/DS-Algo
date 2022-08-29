package com.dsalgo.recursion;

import java.util.Arrays;

/*
  As we know, in bubble sort we repeatedly swap two adjacent elements when found to be in unsorted order.
  As the repetition happens for n-1 times and each iteration , the largest or the smallest element is moved to the last.
  Hence, for recursive intuition ,
  1st apply sort for 0 to n-1, then recursively call method to apply sort for the rest n-1.
 */
public class RecursiveBubbleSort {

	public static void main(String[] args) {

		int[] arr = { 4, 5, 2, 8, 1, 9, 4, 7, 6 };

		sort(arr, arr.length);

		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int n) {

		if (n == 0) {
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}

		sort(arr, n - 1);
	}
}
