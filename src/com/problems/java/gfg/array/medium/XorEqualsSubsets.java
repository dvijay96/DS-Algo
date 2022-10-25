package com.problems.java.gfg.array.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class XorEqualsSubsets {

	public static void main(String[] args) {
		XorEqualsSubsets obj = new XorEqualsSubsets();
		int[] arr = { 6, 9, 4, 2 };

		System.out.println(obj.subsetXOR(arr, arr.length, 6));
//		obj.printSubsets(arr);
	}

	public int subsetXOR(int arr[], int n, int k) {

		int count = 0;

		int currSubset = 0;

		int totalSubsets = (int) Math.pow(2, n);

		while (currSubset <= totalSubsets) {
			int temp = currSubset;
			Set<Integer> set = new HashSet<>();

			for (int i = n - 1; i >= 0; i--) {
				int rem = temp % 2;
				if (rem == 1) {
					set.add(arr[i]);
				}
				temp = temp >> 1;
			}
			int xor = 0;
			for (int i : set) {
				xor ^= i;
			}
			if (xor == k) {
				count++;
			}
			currSubset++;
		}

		return count;
	}

	public void printSubsets(int[] arr) {
		int n = arr.length;
		int count = 0;
		int subsetCount = (int) Math.pow(2, n);

		while (count < subsetCount) {
			int temp = count;
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = n - 1; i >= 0; i--) {
				int rem = temp % 2;
				if (rem == 1)
					list.addFirst(arr[i]);
				temp = temp / 2;
			}
			System.out.println(list);
			count++;
		}
	}
}
