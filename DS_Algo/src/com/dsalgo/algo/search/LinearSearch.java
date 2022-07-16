package com.dsalgo.algo.search;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr= {2,5,6,7,8,2,4,7,9,2,7,3,3};
		System.out.println(new LinearSearch().arraySearch(arr, 3));
	}

	public int arraySearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
		}
		return -1;
	}

	public int search(Object[] arr, Object key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(key))
				return i;
		}
		return -1;
	}
}
