package com.problems.java.leetcode.medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();

		int[] arr = { -1, -1, 2, 0, -2, 4 };
		System.out.println(obj.findTriplets(arr, arr.length, 2));

		BigInteger big = new BigInteger(Integer.MAX_VALUE + "");

		for (int i = 1; i <= 200; i++)
			big = big.add(new BigInteger(Integer.MAX_VALUE + ""));

		System.out.println(big);
		System.out.println(big.longValue());
	}

	/**
	 * Finding all the triplets whose sum equals the target sum
	 * 
	 * <pre>
	 * 	TC -> O(nlogn) + O(n^2)
	 * 	SC -> O(m)  , where m is the no. of triplets
	 * </pre>
	 * 
	 * @param arr
	 * @param size
	 * @param targetSum
	 * @return
	 */
	public List<List<Integer>> findTriplets(int[] arr, int size, int targetSum) {

		Arrays.sort(arr);

		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < size - 2;) {
			int low = i + 1;
			int high = size - 1;

			int reqSum = targetSum - arr[i];
			while (low < high) {
				if (arr[low] + arr[high] == reqSum) {
					List<Integer> list = new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[low]);
					list.add(arr[high]);
					res.add(list);
					int b = arr[low++];
					while (low < high && arr[low] == b)
						low++;
					int c = arr[high--];

					while (low < high && arr[high] == c)
						high--;
				} else if (arr[low] + arr[high] < reqSum) {
					low++;
				} else
					high--;
			}

			int a = arr[i];

			while (i < size && arr[i] == a)
				i++;
		}
		return res;
	}

	/**
	 * Finding out triplet sum that is closest to the given target sum
	 * 
	 * <pre>
	 * 	TC -> O(nlogn) + O(n^2)
	 * 	SC -> O(1)
	 * </pre>
	 * 
	 * @param arr
	 * @param size
	 * @param targetSum
	 * @return
	 */
	static int closest3Sum(int arr[], int size, int targetSum) {
		int res = 0, diff = Integer.MAX_VALUE;
		// sort the array as we have to use the two pointers/ 2-sum approch..
		Arrays.sort(arr);
		for (int i = 0; i < size; i++) {
			// pick the first element out of 3..
			int a = arr[i];
			// now set the pointers after i'th position and at the last of the array..
			int l = i + 1, r = size - 1;
			// check how much is required to make the sum upto X.. i.e. first + second +
			// third = X ...
			int req = targetSum - a;
			while (l < r) {
				// calculate the sum of second and third element...
				int currSum = arr[l] + arr[r];
				// actual sum means.. sum of all the 3 elements..
				int actualSum = a + currSum;
				// this function is like Math.abs.. which will give us positive number even the
				// difference is negative..
				int tmpDiff = getDiff(actualSum, targetSum);
				// if this diff. is minimum till now.. store the actualSum...
				res = tmpDiff < diff ? actualSum : res;
				// update the diff as well..
				diff = diff < tmpDiff ? diff : tmpDiff;
				// if currSum is less so move the left pointer to the right... i.e l++
				if (currSum < req) {
					l++;
				}
				// if currSum is more... then move the right pointer to the left...
				else if (currSum > req) {
					r--;
				}
				// when we got the required sum..
				else {
					return targetSum;
				}
			}
		}
		return res;
	}

	static int getDiff(int first, int second) {
		if (first - second < 0) {
			return second - first;
		} else {
			return first - second;
		}
	}
}
