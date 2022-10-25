package com.dsalgo.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

		List<List<Integer>> subsets = new ArrayList<>();

		findSubsets(subsets, arr, new ArrayList<>(), 0);

		System.out.println(subsets);
	}

	public static void findSubsets(List<List<Integer>> subset, int[] arr, ArrayList<Integer> output, int index) {
		// Base Condition
		if (index == arr.length) {
			subset.add(output);
			return;
		}

		// Not Including Value which is at Index
		findSubsets(subset, arr, new ArrayList<>(output), index + 1);

		// Including Value which is at Index
		output.add(arr[index]);
		findSubsets(subset, arr, new ArrayList<>(output), index + 1);
	}
}
