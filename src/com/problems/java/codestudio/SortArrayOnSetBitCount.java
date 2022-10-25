package com.problems.java.codestudio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * <pre>
 * You are given an array consisting of N positive integers, and your task is to sort the array in decreasing order of count of set bits in the binary representation of the integers present in the array.
In other words, you have to modify the array such that an integer with more number of set bits should appear before the integer which has lesser number of set bits in its binary representation.
The number of set bits is nothing but the number of 1s present in the binary representation of the integer. For example, the number of set bits in 5(0101) is equal to 2.
Note :
1. If any two numbers have the same count of set bits, then in the sorted array they will appear in the order in which they appear in the original array. For example, let the array be { 2, 4, 3}, in this case, both 2 and 4 have the same number of set bits so the answer will be {3, 2, 4} and not {3, 4, 2}, because in the original array 2 appears before 4.

2. The array may contain duplicate elements.
 * 
 * 
 * Sample Input 2 :
3
4 3 8
Sample Output 2 :
3 4 8
Explanation For Sample Input 2 :
The binary representation of 3,4 and 8 will be {11, 100, 1000}, respectively. The count of set bits for 3,4, and 8 is 2,1 and 1 respectively. So the sorted order will be {3, 4, 8}.
 * 
 * </pre>
 *
 */
public class SortArrayOnSetBitCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		List<Integer> arr = new ArrayList<>();
		int n = 6;
		for (int i = 0; i < n; i++)
			arr.add(scan.nextInt());

		sortSetBitsCount(arr);

		System.out.println(arr);

		scan.close();
	}

	public static void sortSetBitsCount(List<Integer> arr) {
		// Write your code here
		Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());

		for (int i = 0; i < arr.size(); i++) {
			int k = 0;
			int count = 0;

			int curr = arr.get(i);
			while (1 << k < curr) {
				int setBit = 1 << k;
				int bitCheck = curr & setBit;
				if (bitCheck > 0)
					count++;
				k++;
			}
			if (map.containsKey(count)) {
				map.get(count).add(curr);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(curr);
				map.put(count, list);
			}
		}
		arr.clear();
		for (List<Integer> list : map.values())
			arr.addAll(list);
	}

}
