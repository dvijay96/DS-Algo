package com.dsalgo.algo.sortings;

import java.util.Arrays;

public class SortingAlgos {

	public static void main(String[] args) {

		SortingAlgos obj = new SortingAlgos();

		int[] arr = { 4, 3, 2, 4, 1 };
		System.out.println(Arrays.toString(arr));

		// select sort
//		obj.stableSelectionSort(arr);
//		System.out.println(Arrays.toString(arr));

		// bubble sort
		obj.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
//
//		String[] str = { "abc", "ABC" };
//		obj.selectionSort(str);
//		System.out.println(Arrays.toString(str));

//		obj.mergeSort(arr);
//		System.out.println(Arrays.toString(arr));
//
//		int[] br = null;
//		System.out.println(Arrays.toString(br));
	}

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public void bubbleSort(int[] arr) {

		int count = 1;

		while (count <= arr.length - 1) {
			boolean swapped = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				break;
			count++;
		}
	}

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int curr = arr[i];
			int j = i - 1;
			while (arr[j] > curr && j >= 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = curr;
		}
	}

	public void selectionSort(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareToIgnoreCase(arr[j]) > 1) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	/*
	 * Input : 4A 5 3 2 4B 1 Output : 1 2 3 4B 4A 5
	 * 
	 * Stable Selection Sort would have produced Output : 1 2 3 4A 4B 5 Selection
	 * sort works by finding the minimum element and then inserting it in its
	 * correct position by swapping with the element which is in the position of
	 * this minimum element. This is what makes it unstable. Swapping might impact
	 * in pushing a key(let’s say A) to a position greater than the key(let’s say B)
	 * which are equal keys. which makes them out of desired order. In the above
	 * example 4A was pushed after 4B and after complete sorting this 4A remains
	 * after this 4B. Hence resulting in unstability. Selection sort can be made
	 * Stable if instead of swapping, the minimum element is placed in its position
	 * without swapping i.e. by placing the number in its position by pushing every
	 * element one step forward. In simple terms use a technique like insertion sort
	 * which means inserting element in its correct place. EXPLANATION WITH EXAMPLE:
	 * 
	 * 
	 * Example: 4A 5 3 2 4B 1 First minimum element is 1, now instead of swapping.
	 * Insert 1 in its correct place and pushing every element one step forward i.e
	 * forward pushing. 1 4A 5 3 2 4B Next minimum is 2 : 1 2 4A 5 3 4B Next minimum
	 * is 3 : 1 2 3 4A 5 4B Repeat the steps until array is sorted. 1 2 3 4A 4B 5
	 */
	public void stableSelectionSort(int[] arr) {
		// Iterate through array elements
		for (int i = 0; i < arr.length - 1; i++) {
			// Assuming elements before till are sorted
			// finding smallest element index from i+1 to n-1
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			// insertion sort approach
			// move every larger element on the left of new min to the right
			int key = arr[min];
			while (min > i) {
				arr[min] = arr[min - 1];
				min--;
			}
			// set the new min at the current i
			arr[i] = key;
		}
	}

	/**
	 * Sorts the array using merge sort algo
	 * 
	 * @param arr
	 */
	public void mergeSort(int[] arr) {
		if (arr != null && arr.length > 0)
			divide(arr, 0, arr.length - 1);
	}

	/**
	 * Applies merge sort on the array. Uses divide and conquer methodology.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	private void divide(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int mid = start + (end - start) / 2;

		divide(arr, start, mid);
		divide(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}

	private void merge(int[] arr, int start, int mid, int end) {

		int[] merge = new int[end - start + 1];

		int i = start;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				merge[k++] = arr[i++];
			} else {
				merge[k++] = arr[j++];
			}
		}

		while (i <= mid)
			merge[k++] = arr[i++];

		while (j <= end)
			merge[k++] = arr[j++];

		for (i = 0, j = start; i < merge.length; i++, j++) {
			arr[j] = merge[i];
		}
	}

}
