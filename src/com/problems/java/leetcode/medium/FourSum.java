package com.problems.java.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {

		FourSum obj = new FourSum();

		int[] arr = { 1, 0, -1, 0, -2, 2 };

		int target = 0;

		System.out.println(obj.fourSum(arr, target));

//		Arrays.sort(arr);
//		ArrayList<List<Integer>> kSums = obj.kSum(arr, target, 4, 0);
//
//		System.out.println(kSums);

//		System.out.println(obj.fourSumDiffApproach(arr, target));

	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();

		Set<List<Integer>> tempSet = new HashSet<>();
		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				long currSum = (long) nums[i] + (long) nums[j];
				long reqSum = (long) target - (long) currSum;
				int low = j + 1;
				int high = n - 1;

				while (low < high) {
					long remSum = (long) nums[low] + (long) nums[high];
					if (remSum == reqSum) {
						List<Integer> fourSum = new ArrayList<>();
						fourSum.add(nums[i]);
						fourSum.add(nums[j]);
						fourSum.add(nums[low]);
						fourSum.add(nums[high]);
						tempSet.add(fourSum);
//						int a = nums[low];
//						while (low < high && nums[low] == a) {
//							low++;
//						}
//						int b = nums[high];
//						while (high > low && nums[high] == b) {
//							high--;
//						}
						low++;
						high--;
					} else if (remSum < reqSum) {
						low++;
					} else {
						high--;
					}
				}

//				int c = nums[j];
//
//				while (j < n - 2 && nums[j] == c) {
//					j++;
//				}
			}

//			int a = nums[i];
//
//			while (i < n - 3 && nums[i] == a) {
//				i++;
//			}
		}

		ans.addAll(tempSet);
		return ans;
	}

	private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
//		if (index >= len) {
//			return res;
//		}
		if (k == 2) {
			int i = index, j = len - 1;
			while (i < j) {
				// find a pair
				if (target - nums[i] == nums[j]) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(target - nums[i]);
					res.add(temp);
					// skip duplication
					while (i < j && nums[i] == nums[i + 1])
						i++;
					while (i < j && nums[j - 1] == nums[j])
						j--;
					i++;
					j--;
					// move left bound
				} else if (target - nums[i] > nums[j]) {
					i++;
					// move right bound
				} else {
					j--;
				}
			}
		} else {
			for (int i = index; i < len - k + 1; i++) {
				// use current number to reduce ksum into k-1sum
				ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
				if (temp != null) {
					// add previous results
					for (List<Integer> t : temp) {
						t.add(0, nums[i]);
					}
					res.addAll(temp);
				}
				while (i < len - 1 && nums[i] == nums[i + 1]) {
					// skip duplicated numbers
					i++;
				}
			}
		}
		return res;
	}

	public List<List<Integer>> fourSumDiffApproach(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];

		// check if targetSum lies between 4*min < targetSum < 4*max
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target in
	 * sorted array nums[] between indices low and high. If there are, add all of
	 * them into the ArrayList fourSumList, using fourSumList.add(Arrays.asList(z1,
	 * the three numbers))
	 */
	public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target in sorted
	 * array nums[] between indices low and high. If there are, add all of them into
	 * the ArrayList fourSumList, using fourSumList.add(Arrays.asList(z1, z2, the
	 * two numbers))
	 */
	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}
}
