package com.problems.java.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		NextPermutation obj = new NextPermutation();

		int[] arr = { 1, 5, 1 };

//		obj.nextPermutation(arr);

		obj.nextPermutation(arr, arr.length);

	}

	// TC -> n!*n
	// SC -> n
	public void nextPermutation(int[] nums) {
		int[] temp = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			temp[i] = nums[i];
		}

		Arrays.sort(nums);

		List<List<Integer>> permutations = new ArrayList<>();

		List<Integer> permutation = new ArrayList<>();

		boolean[] pos = new boolean[nums.length];

		permutate(nums, permutations, permutation, pos);

		for (int i = 0; i < permutations.size(); i++) {
			permutation = permutations.get(i);
			boolean original = true;

			for (int j = 0; j < permutation.size(); j++) {
				if (!permutation.get(j).equals(temp[j])) {
					original = false;
					break;
				}
			}
			if (original) {
				System.out.println(permutations.get((i + 1) % permutations.size()));
				break;
			}
		}
	}

	private void permutate(int[] arr, List<List<Integer>> permutations, List<Integer> permutation, boolean[] pos) {
		if (permutation.size() == arr.length) {
			permutations.add(new ArrayList<>(permutation));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!pos[i]) {
				pos[i] = true;
				permutation.add(arr[i]);
				permutate(arr, permutations, permutation, pos);
				permutation.remove(permutation.size() - 1);
				pos[i] = false;
			}
		}
	}

	// TC -> n
	// Sc -> 1
	private void nextPermutation(int[] arr, int n) {
		if (arr == null || n <= 1) {
			return;
		}
		int k = arr.length - 2;

		while (k >= 0 && arr[k] >= arr[k + 1])
			k--;

		if (k >= 0) {
			int l = arr.length - 1;

			while (l >= k + 1 && arr[l] < arr[k])
				l--;

			swap(arr, k, l);
		}
		reverse(arr, k + 1);

		System.out.println(Arrays.toString(arr));
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void reverse(int[] arr, int i) {
		int j = arr.length - 1;

		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}

}
