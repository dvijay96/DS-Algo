package com.dsalgo.recursion;

import java.util.Arrays;

/*
   As we start from the 2nd element in the array considering it as key.
   recursive function with arr and key position arguments
   find suitable position for the key element in the sorted array
   recursively call the sort function to do it for the next key i.e k+1
 */
public class RecursiveInsertionSort {

	public static void main(String[] args) {

		int[] arr = { 7, 3, 5, 6, 2, 7, 8, 2, 8, 9, 3 };

		sort(arr, 1);

		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] arr, int k) {

		if (k == arr.length)
			return;
		int curr = arr[k];

		int j = k - 1;

		while (j >= 0 && arr[j] > curr) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = curr;

		sort(arr, k + 1);
	}

}
