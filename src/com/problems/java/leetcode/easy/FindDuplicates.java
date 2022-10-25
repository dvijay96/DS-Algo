package com.problems.java.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (5 - 1) + 1);
		}

		System.out.println(Arrays.toString(arr));

		System.out.println(findDuplicates2(arr));

		System.out.println(Arrays.toString(arr));

	}

	protected static Set<Integer> findDuplicates(int[] arr) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else {
				set.add(Math.abs(arr[i]));
			}
		}
		return set;
	}

	protected static Set<Integer> findDuplicates2(int[] arr) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			arr[arr[i] % arr.length] += arr.length;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] / arr.length >= 2)
				set.add(i);
		}
		return set;
	}
}
