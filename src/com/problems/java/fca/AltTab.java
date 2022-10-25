package com.problems.java.fca;

import java.util.Arrays;
import java.util.Scanner;

public class AltTab {

	public static void main(String[] args) {

		int n = 4, k = 8;
		int arr1[] = new int[] { 1, 2, 3, 4 };

		Scanner scanner = new Scanner(System.in);

		System.out.println("initial arr " + Arrays.toString(arr1));

		arr1 = altTab(n, k, arr1);

		System.out.println("final arr " + Arrays.toString(arr1));
		scanner.close();
	}

	private static int[] altTab(int n, int k, int[] arr) {
		if (k == 0) {
			return arr;
		}
		int pos = (k % n) - 1;
		if (pos == -1)
			pos = arr.length - 1;
		int[] res = new int[arr.length];
		res[0] = arr[pos];
		for (int i = 1, j = 0; i < res.length && j < arr.length; i++, j++) {
			if (j == pos) {
				i--;
				continue;
			}
			res[i] = arr[j];
		}
		return res;
	}

	private static int[] getResult(int n, int k, int[] arr1) {
		int topApp;
		if (k == 0) {
			return arr1;
		} else if (k == arr1.length || (k % n == 0)) {
			topApp = arr1.length;
		} else {
			topApp = k % n;
		}

		int[] temp = new int[arr1.length];
		temp[0] = arr1[topApp - 1];

		int key = temp[0];

		for (int i = 1, j = 0; i < temp.length; i++, j++) {
			if (arr1[j] != key) {
				temp[i] = arr1[j];
			} else {
				temp[i] = arr1[++j];
			}
		}

		return temp;
	}

}
