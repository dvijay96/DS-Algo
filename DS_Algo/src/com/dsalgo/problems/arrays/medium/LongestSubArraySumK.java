package com.dsalgo.problems.arrays.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dsalgo.tags.Important;

/*
/**
 * Prefix sum pattern
 * while traversing the array, count the prefix sum keep storing it in a hashmap along with 
 * its occurring index.
 * see if Prefix sum equal k which means sub array sums to k, then len = currIdx + 1
 * also check if previously the sum-k has been encountered by looking into the prefix sum map.
 * if yes, then len = max( len , currIdx - map.get(sum-k))
 * THIS MEANS, between the sum's first encounter and the latest encounter, integer k has been added.
 *  
 *    for Ex: 
 *    
 *    let arr[] = {a1, a2, a3, a4, a5, a6}
 *    
 *    k = 4 which lies in (a4 + a5 + a6) hence this is the sub array we are looking for.
 *    
 *    if a4 + a5 + a6 = k 
 *    and
 *    a1 +...+ a6 = sum
 *    then
 *    a1 + a2 + a3 = sum - k 
 *    
 *     Hence we shall be looking for (sum - k) in our map to find the subArray which equals k
 */
@Important
public class LongestSubArraySumK {

	public static void main(String[] args) {
		LongestSubArraySumK obj = new LongestSubArraySumK();

		int[] arr = { -13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2 };

//		System.out.println(lenOfLongSubarr(arr, 6));

		obj.printMaxSumSubArray(arr);
	}

	private int lenOfLongSubarr(int arr[], int k) {

		int max = 0;
		int sum = 0;
		Map<Integer, Integer> map = new LinkedHashMap<>();
//		map.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == k)
				max = i + 1;
			if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return max;
	}

	void printMaxSumSubArray(int[] arr) { // O(n^2)

		int maxSum = findLargestSumArraySum(arr); // O(n)
		System.out.println("Max SubArray sum = " + maxSum);
		System.out.println(
				"Length of Largest subArray \n whose sum eqauls " + maxSum + " = " + lenOfLongSubarr(arr, maxSum)); // O(n)
		printAllSubArraysEqaulsSum(arr, maxSum); // O(n^2)

	}

	private void printAllSubArraysEqaulsSum(int[] arr, int k) {
		int sum = 0;
		int max = 0;
		int[] pos = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println("Sub arrays whose sum eqauls " + k);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == k) {
				print(arr, 0, i);
				max = i + 1;
				pos[1] = i;
			}
			if (map.containsKey(sum - k)) {
				int start = map.get(sum - k) + 1;
				print(arr, start, i);
				if (i - start > max) {
					max = i - start;
					pos[0] = start;
					pos[1] = i;
				}
			}
			if (!map.containsKey(sum))
				map.put(sum, i);
		}

		System.out.println("Longest SubArray ");

		print(arr, pos[0], pos[1]);
	}

	private void print(int[] arr, int i, int j) {
		while (i <= j) {
			System.out.print(arr[i++] + " ");
		}
		System.out.println();
	}

	/*
	 * Using Kadane's Algorithm
	 */
	private int findLargestSumArraySum(int[] arr) {
		int sum = 0;
		int max = arr[0];
		for (int i : arr) {
			sum += i;
			if (sum > max)
				max = sum;
			if (sum < 0)
				sum = 0;
		}
		return max;
	}
}
