package com.dsalgo.algo.sortings;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		MergeSort obj = new MergeSort();

		int n = 11;
		int[] arr = new int[n];

		for (int j = 0; j < arr.length; j++) {
			arr[j] = (int) (Math.random() * (20 - 1) + 1);
		}

		System.out.println("Before: " + Arrays.toString(arr));

		obj.iterativeMergeSort(arr);

		System.out.println("After: ");
		for (int i = 0; i < arr.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
	}

	public void iterativeMergeSort(int[] arr, int n) {

		for (int currSize = 1; currSize <= n - 1; currSize *= 2) {
			for (int left = 0; left < n - 1; left += 2 * currSize) {
				int mid = Math.min(left + currSize - 1, n - 1);
				int right = Math.min(left + 2 * currSize - 1, n - 1);
				merge(arr, left, mid, right);
			}
		}
	}

	public void sort(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int mid = start + (end - start) / 2;

		sort(arr, start, mid);
		sort(arr, mid + 1, end);
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

		while (i <= mid) {
			merge[k++] = arr[i++];
		}

		while (j <= end) {
			merge[k++] = arr[j++];
		}

		for (i = 0, j = start; i < merge.length; i++, j++) {
			arr[j] = merge[i];
		}
	}

	@Deprecated
	public void iterativeMergeSort(int[] arr) {
		int p = 0;
		for (p = 2; p <= arr.length; p = 2 * p) {
			for (int i = 0; i < arr.length; i = i + p) {
				int start = i;
				int end = Math.min(i + p - 1, arr.length - 1);
				int mid = start + (end - start) / 2;
				merge(arr, start, mid, end);
			}
		}

//		if (p / 2 < arr.length) {
//			merge(arr, 0, (p / 2) - 1, arr.length - 1);
//		}
	}
}
