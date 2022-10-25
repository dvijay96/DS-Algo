package com.problems.java.codestudio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer
 * ‘K’. Your task is to group all the array elements with ‘K-th’ bit (rightmost
 * bit is ‘1st’ bit) equal to 0 followed by all the elements with ‘K-th’ bit
 * equal to 1. </br>
 * Note 1: The relative order inside both the groups should remain as it was in
 * the input. </br>
 * Note 2: You have to return the modified array/list.. For Example : If ‘ARR’
 * is {1,2,3,4} and ‘K’ = 1, then after modification, ‘ARR’ should be {2,4,1,3}
 * because ‘K-th’ (‘K’ = 1) of {2,4} is 0 and ‘K-th’ bit of {1,3} is 1.
 *
 * </br>
 * Sample Input:</br>
 * 
 * <pre>
5 1
3 6 2 1 4
5 3
7 6 2 9 3
Sample Output :
6 2 4 3 1
2 9 3 7 6
Explanation For Sample Input 2:

In example 1, the original ‘ARR’ is {3,6,2,1,4} and ‘K’ = 1. After modification the ‘ARR’ should be {6,2,4,3,1} because {6,2,4} will come first as their 1st bit is 0 and {3,1} will come after that as their 1st bit is 1.

In example 2, the original ‘ARR’ is {7,6,2,9,3} and ‘K’ = 3. After modification the ‘ARR’ should be {2,9,3,7,6} because {2,9,3} will come first as their 3rd bit is 0 and {7,6} will come after that as their 3rd bit is 1.
 * </pre>
 * 
 */
public class SortByKthBit {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 2, 1 };
		int k = 1;
		arr = sortArrayByKBit(k, arr);

		System.out.println(Arrays.toString(arr));
	}

	public static int[] sortArrayByKBit(int k, int arr[]) {

		List<Integer> list0 = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();

		for (int i : arr) {
			int temp = i;
			if ((temp >> (k - 1)) % 2 == 0) {
				list0.add(i);
			} else {
				list1.add(i);
			}
		}

		int i = 0;
		for (int j = 0; j < list0.size(); j++)
			arr[i++] = list0.get(j);

		for (int j = 0; j < list1.size(); j++)
			arr[i++] = list1.get(j);

		return arr;
	}
}
