package com.problems.java.fca;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyersExam {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1, 2, 5 };

		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();

		for (int n : arr) {
			if (!set.contains(n))
				set.add(n);
			else {
				int num = n;
				while (set.contains(num) || Arrays.binarySearch(arr, num) >= 0) {
					num++;
				}
				set.add(num);
			}
		}

		System.out.println(set);
		
	}

}
