package com.problems.java;

import java.util.Arrays;

public class InversionCountProblem {

	public static void main(String[] args) {
		int[] arr = { 3, 1, -2, 0 };

		int invCount = 0;
//		invCount = mergeSort(arr, 0, arr.length - 1);
		invCount = countWithQuickSort(arr);
		System.out.println(invCount);
		System.out.println(Arrays.toString(arr));
	}

	private static int mergeSort(int[] arr, int start, int end) {
		int count = 0;
		if (start < end) {
			int mid = start + (end - start) / 2;
			count += mergeSort(arr, start, mid);
			count += mergeSort(arr, mid + 1, end);
			count += inversionCountMerge(arr, start, mid, end, count);
		}
		return count;
	}

	private static int inversionCountMerge(int[] arr, int start, int mid, int end, int count) {

		int[] merge = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		int l = start;
		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				merge[k++] = arr[i++];
			} else {
				merge[k++] = arr[j++];
				count++;
			}
		}

		while (i <= mid)
			merge[k++] = arr[i++];

		while (j <= end)
			merge[k++] = arr[j++];

		for (i = 0, j = start; i < merge.length; i++, j++)
			arr[j] = merge[i];
		return count;
	}

	static int countWithQuickSort(int[] arr) {
		int count = 0;
		int k = 1;

		while (k <= arr.length - 1) {

			int low = 0;
			int high = arr.length - 1;
			int mid = low + (high - low) / 2;
			int pivot = arr[mid];

			while (low <= high) {
				while (arr[low] < pivot) {
					low++;
				}
				while (arr[high] > pivot) {
					high--;
				}

				if (low <= high) {
					if (low < high)
						count++;
					int temp = arr[low];
					arr[low] = arr[high];
					arr[high] = temp;
					low++;
					high--;
				}
			}
			k++;
		}
		return count;
	}
}
