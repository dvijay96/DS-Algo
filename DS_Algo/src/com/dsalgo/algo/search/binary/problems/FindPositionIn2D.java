package com.dsalgo.algo.search.binary.problems;

import java.util.ArrayList;
import java.util.List;

public class FindPositionIn2D {

	public static void main(String[] args) {

	}

	public static boolean findInMatrixWithBinary(int x, ArrayList<ArrayList<Integer>> arr) {
		int row = 0;
		int col = arr.get(0).size() - 1;

		while (row < arr.size() && col >= 0) {
			if (arr.get(row).get(col) == x)
				return true;
			else if (x < arr.get(row).get(col))
				col--;
			else
				row++;
		}
		return false;
	}

	/*
	 * applying binary search in each row for the element Time Complexity:- O(nlogm)
	 */
	public boolean findInMatrix(int x, ArrayList<ArrayList<Integer>> arr) {

		for (List<Integer> list : arr) {
			if (isPresent(x, list))
				return true;
		}
		return false;
	}

	private boolean isPresent(int x, List<Integer> arr) {
		int start = 0;
		int end = arr.size() - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr.get(mid) == x)
				return true;
			else if (x > arr.get(mid))
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}

}
