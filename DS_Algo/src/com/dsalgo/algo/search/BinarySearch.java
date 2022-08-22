package com.dsalgo.algo.search;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 33, 50, 70 };

		BinarySearch obj = new BinarySearch();
		System.out.println(obj.arraySearch(arr, 70));

//		int start = 0;
//		int end = arr.length - 1;
//		int res = obj.binaryRecursiveSearch(arr, 5, start, end);
//		System.out.println(res);
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
			int mid = start + (end - start) / 2;
			if (arr[mid] == key)
				return mid;
			else if (key > arr[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	/**
	 * input array is reverse sorted
	 * 
	 * @param arr
	 * @param key
	 * @return the index of the key from the array if found, otherwise -1.
	 */
	public int binaryReverseSearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (key > arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	public int binaryRecursiveSearch(int[] arr, int key, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (key > arr[mid])
				start = mid + 1;
			else
				end = mid - 1;
			return binaryRecursiveSearch(arr, key, start, end);
		}
		return -1;
	}
}
