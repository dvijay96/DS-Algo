package com.dsalgo.algo.search;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 33, 50, 70 };

		System.out.println(new BinarySearch().arraySearch(arr, 50));
	}

	/**
	 * Array must be sorted
	 * 
	 * @param arr - the sorted array
	 * @param key - the key to be searched
	 * @return index of the key in the sorted array if found otherwise -1.
	 */
	public int arraySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (key > arr[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

}
