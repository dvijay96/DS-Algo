package com.problems.java.arrays.basic;

import java.util.ArrayList;
import java.util.List;

public class BasicOf2DArray {

	public static void main(String[] args) {

		int[][] arr = { { 10 }, { 20 }, { -10 } };

		System.out.println(spiralPathMatrix(arr, arr.length, arr[0].length));
	}

	/**
	 * You are given a 2D array with dimensions ‘N*M’. You need to read the array
	 * elements row-wise and return a linear array that stores the elements like a
	 * wave i.e the 1st-row elements are stored from left to right, 2nd-row elements
	 * are stored from right to left, and so on.
	 * 
	 * 
	 * @param mat
	 * @return
	 */
	public static ArrayList<Integer> rowWaveForm(ArrayList<ArrayList<Integer>> mat) {

		// Write your code here
		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < mat.size(); i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < mat.get(i).size(); j++)
					res.add(mat.get(i).get(j));
			} else {
				for (int j = mat.get(i).size() - 1; j >= 0; j--)
					res.add(mat.get(i).get(j));
			}
		}

		return res;
	}

	/**
	 * You are given a 2-D array 'MATRIX' of dimensions N x M, of integers. You need
	 * to return the spiral path of the matrix.
	 * 
	 * @param matrix
	 * @param n
	 * @param m
	 * @return
	 */
	public static List<Integer> spiralPathMatrix(int[][] matrix, int n, int m) {
		// Write you code here.

		int top = 0, left = 0;
		int bottom = n - 1, right = m - 1;
		int total = n * m;

		List<Integer> list = new ArrayList<>();

		while (left <= right && top <= bottom) {

			for (int i = left; i <= right && list.size() < total; i++)
				list.add(matrix[top][i]);
			top++;

			for (int i = top; i <= bottom && list.size() < total; i++)
				list.add(matrix[i][right]);
			right--;

			for (int i = right; i >= left && list.size() < total; i--)
				list.add(matrix[bottom][i]);
			bottom--;

			for (int i = bottom; i >= top && list.size() < total; i--)
				list.add(matrix[i][left]);
			left++;
		}
		return list;
	}

}
