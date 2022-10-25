package com.dsalgo.algo.sortings;

import java.util.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 0, 2, 1, 0, 2 };

//		sort012(arr);

		approach2(arr);

		System.out.println(Arrays.toString(arr));
	}

	private static void sort012(int[] arr) {

		int low = 0;
		int high = arr.length - 1;
		int i = 0;

		while (i <= high) {
			if (arr[i] == 0) {
				swap(arr, i, low);
				i++;
				low++;
			} else if (arr[i] == 2) {
				swap(arr, i, high);
				high--;
			} else {
				i++;
			}
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void approach2(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int pointer = 0;
		while (pointer <= end) {
			if (nums[pointer] == 0) {
				nums[pointer] = nums[start];
				nums[start] = 0;
				start++;
			} else if (nums[pointer] == 2) {
				nums[pointer] = nums[end];
				nums[end] = 2;
				end--;
				pointer--;
			}
			pointer++;
			System.out.println(Arrays.toString(nums));
		}
	}

	private static void approach3(int[] arr) {
		int n0 = -1, n1 = -1, n2 = -1;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == 0) {
				arr[++n2] = 2;
				arr[++n1] = 1;
				arr[++n0] = 0;
			} else if (arr[i] == 1) {
				arr[++n2] = 2;
				arr[++n1] = 1;
			} else if (arr[i] == 2) {
				arr[++n2] = 2;
			}
		}
	}
}
