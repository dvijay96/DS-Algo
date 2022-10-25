package com.problems.java.gfg.array.medium;

import java.util.ArrayList;
import java.util.List;

// Pascal Triangle
//         1
//       1 2 1
//     1  3  3  1
//    1  4  6  4  1

// 1st row can be initialize as 1,
// then starting from 2rd row , we can refer the prevRow and 
// since the next row element = sum of prevRow's adjacent elements
// i.e whole of nthRow will be sum of adjacent elements from prevRow as shown. 
public class PascalTriangle {

	public static void main(String[] args) {
		int n = 5;
		PascalTriangle obj = new PascalTriangle();
		ArrayList<Long> output = obj.nthRowOfPascalTriangle(n);
		System.out.println(output);
//		List<List<Integer>> pascalT = obj.generate(74);
//
//		List<Integer> expected = pascalT.get(73);
//		System.out.println(expected);

		List<Integer> expected = new ArrayList<>();
		int[][] arr = printPascal(n);
		int j = arr.length - 1;
		for (int i = 0; i < arr[0].length; i++) {
//			System.out.print(arr[j][i] + " ");
			expected.add(arr[j][i]);
			Long.valueOf(arr[j][i]);
		}
		System.out.println(expected);

		obj.pascalTriangle(n).forEach(System.out::println);
		System.out.println("Done");
	}

	// my solution , GFG problem
	private ArrayList<Long> nthRowOfPascalTriangle(int n) {

		ArrayList<Long> ans = new ArrayList<>();
		ans.add(1l);

		if (n == 2) {
			ans.add(1l);
		} else if (n > 2) {
			ans.add(1l);
			n = n - 2;
			while (n > 0) {
				List<Integer> temp = new ArrayList<>();
				for (Long item : ans) {
					temp.add(item.intValue());
				}
				ans.clear();
				ans.add(1l);
				for (int i = 0; i < temp.size() - 1; i++) {
					ans.add(Long.valueOf(temp.get(i) + temp.get(i + 1)));
				}
				ans.add(1l);
				n--;
			}
		}
		return ans;
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row, pre = null;
		for (int i = 0; i < numRows; ++i) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; ++j)
				if (j == 0 || j == i)
					row.add(1);
				else
					row.add(pre.get(j - 1) + pre.get(j));
			pre = row;
			res.add(row);
		}
		return res;
	}

	// my solution , LeetCode problem
	public List<List<Integer>> pascalTriangle(int numRows) {
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			row.add(1);
			if (i >= 1) {
				List<Integer> prevRow = ans.get(i - 1);
				for (int j = 0; j < prevRow.size() - 1; j++) {
					row.add(prevRow.get(j) + prevRow.get(j + 1));
				}
				row.add(1);
			}
			ans.add(row);
		}
		return ans;
	}

	public static int[][] printPascal(int n) {
		// An auxiliary array to store generated pascal triangle values
		int[][] arr = new int[n][n];

		// Iterate through every line and print integer(s) in it
		for (int line = 0; line < n; line++) {
			// Every line has number of integers equal to line number
			for (int i = 0; i <= line; i++) {
				// First and last values in every row are 1
				if (line == i || i == 0)
					arr[line][i] = 1;
				else // Other values are sum of values just above and left of above
					arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
//				System.out.print(arr[line][i]);
			}
//			System.out.println("");
		}

		return arr;
	}

}
