package com.dsalgo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayPermutation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };

		List<Integer> permutation = new ArrayList<>();
		boolean[] pos = new boolean[arr.length];

//		permutate(arr, permutation, pos, 3);
//		System.out.println();
//		permutate(arr, 0);

		Set<List<Integer>> permutations = new HashSet<>();
		permutation.clear();
		pos = new boolean[arr.length];
		permutate(arr, pos, permutations, permutation);

		List<List<Integer>> list = new ArrayList<>(permutations);
		list.sort(new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				for (int i = 0; i < o1.size(); i++) {
					if (o1.get(i) != o2.get(i)) {
						return o1.get(i) - o2.get(i);
					}
				}
				return -1;
			}
		});

		System.out.println();
		list.forEach(System.out::println);
	}

	private static void permutate(int[] arr, boolean[] pos, Set<List<Integer>> permutations,
			List<Integer> permutation) {
		if (permutation.size() == arr.length) {
			permutations.add(new ArrayList<>(permutation));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!pos[i]) {
				pos[i] = true;
				permutation.add(arr[i]);
				permutate(arr, pos, permutations, permutation);
				permutation.remove(permutation.size() - 1);
				pos[i] = false;
			}
		}
	}

	private static void permutate(int[] arr, List<Integer> permutation, boolean[] pos, int size) {

		if (size > arr.length) {
			System.out.println("Invalid permutation size!");
			return;
		}
		if (permutation.size() == size) {
			System.out.println(permutation);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!pos[i]) {
				pos[i] = true;
				permutation.add(arr[i]);
				permutate(arr, permutation, pos, size);
				permutation.remove(permutation.size() - 1);
				pos[i] = false;
			}
		}
	}

	private static void permutate(int[] arr, int index) {
		if (index == arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = index; i < arr.length; i++) {
			swap(arr, i, index);
			permutate(arr, index + 1);
			swap(arr, index, i);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
