package com.problems.java.leetcode.easy;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1
 * and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
 * n, where the first m elements denote the elements that should be merged, and
 * the last n elements are set to 0 and should be ignored. nums2 has a length of
 * n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output:
 * [1,2,2,3,5,6] Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1. Example 2:
 * 
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0 Output: [1] Explanation: The
 * arrays we are merging are [1] and []. The result of the merge is [1]. Example
 * 3:
 * 
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1 Output: [1] Explanation: The
 * arrays we are merging are [] and [1]. The result of the merge is [1]. Note
 * that because m = 0, there are no elements in nums1. The 0 is only there to
 * ensure the merge result can fit in nums1.
 *
 */

@SuppressWarnings("unused")
public class MergeSortedArray {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 0, 0, 0 };
		int[] arr2 = { 2, 5, 6 };

		approach1(arr1, 3, arr2, 3);

		System.out.println(Arrays.toString(arr1));

	}

	/*
	 * Naive approach
	 */
	private static void merge(int[] arr1, int m, int[] arr2, int n) {

		for (int i = 0; i < n; i++) {
			arr1[m + i] = arr2[i];
		}
		Arrays.sort(arr1);
	}

	/*
	 * Best approach
	 * 
	 * #START FILLING FROM LAST #COMPARE THE BIGGEST ELEMENT #PLACE IT IN THE LAST
	 * OF arr1
	 */
	private static void approach1(int[] arr1, int m, int[] arr2, int n) {
		int p1 = m - 1, p2 = n - 1, i = m + n - 1;

		while (p2 >= 0) {
			if (p1 >= 0 && arr1[p1] > arr2[p2])
				arr1[i--] = arr1[p1--];
			else
				arr1[i--] = arr2[p2--];
		}
	}

	private static void approach2(int[] nums1, int m, int[] nums2, int n) {
		int[] res = new int[n + m];

		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j])
				res[k++] = nums1[i++];
			else
				res[k++] = nums2[j++];
		}

		while (i < m)
			res[k++] = nums1[i++];

		while (j < n)
			res[k++] = nums2[j++];

		for (i = 0; i < res.length; i++)
			nums1[i] = res[i];
	}
}
