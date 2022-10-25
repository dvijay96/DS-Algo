package com.problems.java.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 2, 4 };
		int[] expectedArr = { 1, 2, 4 };

		int k = new RemoveDuplicatesFromSortedArray()
				.approach1(arr);

		if (k != expectedArr.length)
			throw new RuntimeException("Incorrect");

		for (int i = 0; i < k; i++) {
			if (arr[i] != expectedArr[i])
				throw new RuntimeException("Incorrect");
		}

		System.out.println("Passed");
		
	}

	// 47ms
	public int removeDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i : nums) {
			if (!list.contains(i))
				list.add(i);
		}
		for (int i = 0; i < nums.length && i < list.size(); i++) {
			nums[i] = list.get(i);
		}
		return list.size();
	}

	public int approach1(int[] arr) {
		/*
		 * k -> last index where unique element is present 
		 * i -> iterate over the array
		 */
		int k = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1])
				arr[++k] = arr[i];
		}
		return k + 1;
	}
}
