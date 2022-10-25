package com.dsalgo.algo.arrays;

public class MatrixTraversal {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int row = arr.length;
		int col = arr[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		rortate90AntiClock(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void rortate90AntiClock(int[][] arr) {
		transpose(arr);
		int i = 0, j = arr.length - 1;
		while (i < j) {
			for (int k = 0; k < arr[i].length; k++) {
				int temp = arr[i][k];
				arr[i][k] = arr[j][k];
				arr[j][k] = temp;
			}
			i++;
			j--;
		}
	}

	public static void transpose(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[i].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}

}
