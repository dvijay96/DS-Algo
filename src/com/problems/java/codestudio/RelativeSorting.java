package com.problems.java.codestudio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RelativeSorting {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = 6, m = 3;

		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++)
			arr.add(scan.nextInt());

		List<Integer> brr = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			brr.add(scan.nextInt());
		}

		arr = relativeSorting(arr, brr, n, m);

		System.out.println(arr);

		scan.close();

	}

	public static List<Integer> relativeSorting(List<Integer> arr, List<Integer> brr, int n, int m) {
		// Write your code here
		List<Integer> res = new ArrayList<>();

		for (Integer i : brr) {
			while (arr.contains(i)) {
				res.add(i);
				arr.remove(i);
			}
		}
		if (!arr.isEmpty()) {
			Collections.sort(arr);
			res.addAll(arr);
		}
		return res;
	}
}
