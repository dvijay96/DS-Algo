package com.dsalgo.algo.sortings;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {

		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter array size: ");
		n = scan.nextInt();

		int[] arr = new int[n];

		System.out.println("Enter elements: ");
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.println("Your array before sorting: " + Arrays.toString(arr));

		arr = sort(arr);

		System.out.println("Your array after sorting: " + Arrays.toString(arr));

	}

	private static int[] sort(int[] arr) {
		
		return null;
	}

}
