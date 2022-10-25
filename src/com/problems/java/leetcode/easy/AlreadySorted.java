package com.problems.java.leetcode.easy;

public class AlreadySorted {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 3, 4 };
		System.out.println(check(arr));
	}

	public static boolean check(int[] arr) {
		int k = 0, n = arr.length;
		for (int i = 0; i < n; ++i) {
			if (arr[i] > arr[(i + 1) % n]) {
				k++;
			}
			if (k > 1) {
				return false;
			}
		}
		return true;
	}
}
