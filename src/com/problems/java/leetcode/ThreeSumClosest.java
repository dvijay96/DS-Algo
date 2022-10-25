package com.problems.java.leetcode;

import java.util.Arrays;

/**
 * 
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,1,-4], target = 1 Output: 2 Explanation: The sum that is
 * closest to the target is 2. (-1 + 2 + 1 = 2). Example 2:
 * 
 * Input: nums = [0,0,0], target = 1 Output: 0
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] arr = { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(new ThreeSumClosest().threeSumClosest(arr, target));

	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int gap = Integer.MAX_VALUE;
		int result = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (Math.abs(sum - target) < gap) {
					gap = Math.abs(sum - target);
					result = sum;
				}
				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
}
