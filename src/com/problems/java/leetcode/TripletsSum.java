package com.problems.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * <br/>
 * 
 * <strong>Example 1:</strong><br/>
 * 
 * Input: nums = [-1,0,1,2,-1,-4] 
 * <br/>
 * Output: [[-1,-1,2],[-1,0,1]] 
 * <br/>
 * Explanation:
 * nums[0] + nums[1] + nums[1] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
 * output and the order of the triplets does not matter.
 *
 */
public class TripletsSum {

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		int targetSum = 0;
		System.out.println(new TripletsSum().findTriplets(arr, targetSum));
	}

	public List<List<Integer>> threeSum(int[] arr) {
		if (arr != null) {
			Arrays.sort(arr);
			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i < arr.length - 2; i++) {
				for (int j = i + 1; j < arr.length - 1; j++) {
					for (int k = j + 1; k < arr.length; k++) {
						if (arr[i] + arr[j] + arr[k] == 0) {
							if (!list.contains(Arrays.asList(arr[i], arr[j], arr[k])))
								list.add(Arrays.asList(arr[i], arr[j], arr[k]));
						}
					}
				}
			}
			return list;
		}
		return Collections.emptyList();
	}

	public List<List<Integer>> betterApproach1(int[] nums) {
		if (nums != null) {
			Arrays.sort(nums);
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < nums.length - 2; i++) {

				int target = 0 - nums[i];

				int start = i + 1, end = nums.length - 1;
				while (start < end) {

					if (nums[start] + nums[end] == target) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[start]);
						temp.add(nums[end]);
						result.add(temp);

						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (start < end && nums[end] == nums[end - 1])
							end--;

						start++;
						end--;
					} else if (nums[start] + nums[end] > target)
						end--;
					else
						start++;
				}
				while (i < nums.length - 1 && nums[i] == nums[i + 1])
					i++;

			}
			return result;
		}
		return Collections.emptyList();
	}

	public Set<List<Integer>> findTriplets(int[] arr, int sum) {
		Arrays.sort(arr);
		Set<List<Integer>> tripletSets = new HashSet<>();

		for (int i = 0; i < arr.length - 2; i++) {
			int first = arr[i];
			int target = sum - arr[i];

			int start = i + 1;
			int end = arr.length - 1;

			while (start < end) {
				if (arr[start] + arr[end] == target) {
					List<Integer> tripletSet = new ArrayList<>();
					tripletSet.add(first);
					tripletSet.add(arr[start++]);
					tripletSet.add(arr[end--]);
					tripletSets.add(tripletSet);
				} else if (arr[start] + arr[end] < target) {
					start++;
				} else {
					end--;
				}
			}
		}
		return tripletSets;
	}
}
