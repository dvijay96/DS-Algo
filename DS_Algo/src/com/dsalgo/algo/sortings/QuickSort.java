package com.dsalgo.algo.sortings;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int n = 10;

		int[] arr = new int[n];

		for (int j = 0; j < arr.length; j++) {
			arr[j] = (int) (Math.random() * (100 - 1) + 1);
		}

		quickSortMid(arr, 0, n - 1);

		boolean isSorted = true;
		for (int i = 0, j = i + 1; i < arr.length - 1; i++, j++) {
			if (arr[i] > arr[j])
				isSorted = false;
		}
		System.out.println(isSorted);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIdx = partionWithPivotLow(arr, low, high);

			quickSort(arr, low, pivotIdx - 1);
			quickSort(arr, pivotIdx + 1, high);
		}
	}

	/*
	 * Divides the array by taking high as pivot and places the pivot at its correct
	 * position
	 */
	private static int partitionWithPivotHigh(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = pivot;
		arr[high] = temp;
		return i;
	}

	/*
	 * Divides the array by taking low as pivot and places the pivot at its correct
	 * position
	 */
	private static int partionWithPivotLow(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = high + 1;

		for (int j = high; j > low; j--) {
			if (arr[j] > pivot) {
				i--;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i--;
		int temp = arr[i];
		arr[i] = pivot;
		arr[low] = temp;
		return i;
	}

	/**
	 * Applies quick sort by taking random pivot element
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSortMid(int[] arr, int low, int high) {
		if (low < high) {
			int start = low, end = high;
			int random = (int) Math.random() * (high - low) + low;
			int pivot = arr[random];

			while (start <= end) {
				while (arr[start] < pivot) {
					start++;
				}
				while (arr[end] > pivot) {
					end--;
				}

				if (start <= end) {
					int temp = arr[start];
					arr[start] = arr[end];
					arr[end] = temp;
					end--;
					start++;
				}
			}
			// now my pivot is at correct position, perform sorting for other two halves
			quickSortMid(arr, low, end);
			quickSortMid(arr, start, high);
		}
	}
}
