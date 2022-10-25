package com.problems.java.fca;

import java.util.TreeSet;

public class StreetLights {

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 5, 10 }, { 8, 12 } };

		int count = streetLights(arr);

		System.out.println(count);

	}

	private static int streetLights(int[][] arr) {
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i][0]; j < arr[i][1]; j++) {
				set.add(j);
			}
		}
		return set.size();
	}

}
