package com.dsalgo.problems.arrays.medium;

import java.util.Arrays;
import java.util.Scanner;

public class MakeZeroes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.out.println(i + " th row: ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = scan.nextInt();
			}
		}

		MakeZeroes obj = new MakeZeroes();

		System.out.println("Before");
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}

		obj.makeZeroesTwo(arr);

		System.out.println("After");
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}

		scan.close();
	}

	public void makeZeros(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int ans[][] = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				ans[i][j] = matrix[i][j];
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					int temp = 0;
					if (j - 1 >= 0) {
						temp += matrix[i][j - 1];
						ans[i][j - 1] = 0;
					}
					if (j + 1 < cols) {
						temp += matrix[i][j + 1];
						ans[i][j + 1] = 0;
					}
					if (i - 1 >= 0) {
						temp += matrix[i - 1][j];
						ans[i - 1][j] = 0;
					}
					if (i + 1 < rows) {
						temp += matrix[i + 1][j];
						ans[i + 1][j] = 0;
					}
					ans[i][j] = temp;
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = ans[i][j];
			}
		}

	}

	int setPostions(int[][] arr, int i, int j) {
		return arr[i][j];
	}

	public void makeZeroesTwo(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		boolean col0 = false;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0)
				col0 = true;
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
			}
		}

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
			if (col0)
				matrix[i][0] = 0;
		}
	}
}
