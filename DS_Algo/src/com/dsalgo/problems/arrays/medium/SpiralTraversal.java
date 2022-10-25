package com.dsalgo.problems.arrays.medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralTraversal {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		SpiralTraversal obj = new SpiralTraversal();
		obj.print(matrix);

		System.out.println(obj.getSpriralTraversal(matrix));
	}

	public void print(int[][] matrix) {
		int top = 0;
		int left = 0;
		int right = matrix[0].length - 1;
		int bottom = matrix.length - 1;

		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				System.out.print(matrix[top][i] + " ");
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				System.out.print(matrix[i][right] + " ");
			}
			right--;
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					System.out.print(matrix[bottom][i] + " ");
				}
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(matrix[i][left] + " ");
				}
				left++;
			}
		}
		System.out.println();
	}

	private List<Integer> getSpriralTraversal(int[][] matrix) {
		List<Integer> res = new LinkedList<>();
		if (matrix == null || matrix.length == 0)
			return res;
		int n = matrix.length, m = matrix[0].length;
		int up = 0, down = n - 1;
		int left = 0, right = m - 1;
		while (res.size() < n * m) {
			for (int j = left; j <= right && res.size() < n * m; j++)
				res.add(matrix[up][j]);

			for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
				res.add(matrix[i][right]);

			for (int j = right; j >= left && res.size() < n * m; j--)
				res.add(matrix[down][j]);

			for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
				res.add(matrix[i][left]);

			left++;
			right--;
			up++;
			down--;
		}
		return res;
	}
}
