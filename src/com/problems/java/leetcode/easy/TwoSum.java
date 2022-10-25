package com.problems.java.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1]. Example 2:
 * 
 * Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 * 
 * Input: nums = [3,3], target = 6 Output: [0,1]
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 10, 11, 16 };
		int target = 17;
		int[] result = new TwoSum().twoPointerApproach(arr, target);
		System.out.println(Arrays.toString(result));
	}

	/*
	 * 1.Create a HashMap and keep logging the visited value and its index. Together
	 * 2. In each iteration check if the map contains the compliment, then return
	 * that index.
	 */
	public int[] approach1(int[] nums, int target) {
		if (nums != null) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(target - nums[i])) {
					return new int[] { i, map.get(target - nums[i]) };
				}
				map.put(nums[i], i);
			}
		}
		return new int[] { -1, -1 };
	}

	/*
	 * Naive approach
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		for (int i = 0; i < nums.length - 1; i++) {
			boolean found = false;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					found = true;
					break;
				}
			}
			if (found)
				break;
		}
		return result;
	}

	/*
	 * Taken from 0ms time frame Starts from 1. Starts from index 1 with outer loop
	 * i=1 and inner loop j=i 2. compare arr[i] + arr[j-i] = target
	 */
	public int[] approach2(int[] arr, int target) {

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[j] + arr[j - i] == target)
					return new int[] { j - i, j };
			}
		}
		return null;
	}

	/*
	 * Works only when the array is sorted
	 * 
	 * 1. assign two pointers at start and end of the array. 2. compare arr[start] +
	 * arr[end] = sum 3. if equal, start++ , end-- 4. if < sum , then start++ becuz,
	 * since its sorted so if sumk is coming to be smaller that means we need to
	 * increment start so that it points to a larger number and hence the sum would
	 * be large. 4. if > sum , then end-- becuz, by decrementing the end pointer ,
	 * we may get a smaller number than before hence sumk would be smaller.
	 * 
	 */
	public int[] twoPointerApproach(int[] arr, int target) {

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			if (arr[i] + arr[j] == target)
				return new int[] { i, j };
			else if (arr[i] + arr[j] < target)
				i++;
			else
				j--;
		}
		return new int[] { -1, -1 };
	}
}
