package com.problems.java.leetcode.easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem Statement
You are given an array of integers 'ARR' of length 'N' and an integer Target. Your task is to return all pairs of elements such that they add up to Target.
Note:
We cannot use the element at a given index twice.
Follow Up:
Try to do this problem in O(N) time complexity. 
Input Format:
The first line of input contains an integer ‘T’ denoting the number of test cases to run. Then the test case follows.

The first line of each test case contains two single space-separated integers ‘N’ and ‘Target’ denoting the number of elements in an array and the Target, respectively.

The second line of each test case contains ‘N’ single space-separated integers, denoting the elements of the array.
Output Format :
For each test case, print a single line containing space-separated integers denoting all pairs of elements such that they add up to the target. A pair (a, b) and (b, a) is the same, so you can print it in any order.

Each pair must be printed in a new line. If no valid pair exists, print a pair of (-1, -1). Refer to sample input/output for more clarity.
Note:
You do not need to print anything; it has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 100
1 <= N <= 5000
-10 ^ 9 <= TARGET <=10 ^ 9
-10 ^ 9 <= ARR[i] <=10 ^ 9

Where 'T' denotes the number of test cases, 'N' represents the size of the array, 'TARGET' represents the sum required, and 'ARR[i]' represents array elements.

Time Limit: 1 sec.
Sample Input 1 :
2
4 9
2 7 11 13
5 1
1 -1 -1 2 2
Sample Output 1:
2 7
-1 2
-1 2
Explanation For Sample 1:
For the first test case, we can see that the sum of  2 and 7 is equal to 9 and it is the only valid pair.

For the second test case, there are two valid pairs (-1,2) and (-1,2), which add up to 1.
Sample Input 2 :
1
4 16
2 7 11 13
Sample Output 2 :
-1 -1
 */
public class TwoSumAdv1 {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 7, 10, 11, 16 };

		int target = 17;

		List<Integer[]> ans = twoPointerApproach(arr, target);

		for (Integer[] ar : ans) {
			System.out.println(Arrays.toString(ar));
		}

		BigInteger a = new BigInteger("55");
		BigInteger b = new BigInteger("55");

		BigInteger temp = a;

		System.out.println(a);
		System.out.println(b);
		System.out.println(temp);
		System.out.println(BigInteger.ONE);
		System.out.println(a.subtract(BigInteger.ONE));
		
	}

	public static void approach1(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
		}

		ArrayList<String> ans = new ArrayList<>();

		for (int curr : arr) {
			int comp = target - curr;
			if (comp == curr) {
				if (map.get(curr) > 1) {
					ans.add("" + curr + "+" + comp);
					map.put(curr, map.get(curr) - 2);
				}
			} else if (map.get(curr) > 0 && map.containsKey(comp) && map.get(comp) > 0) {
				ans.add("(" + curr + "," + comp + ")");
				map.put(curr, map.get(curr) - 1);
				map.put(comp, map.get(comp) - 1);
			}
		}

		if (ans.size() == 0)
			ans.add("(-1,-1)");

		System.out.println(ans);
	}

	/*
	 * Works only when array is sorted
	 */
	public static List<Integer[]> twoPointerApproach(int[] arr, int target) {

		int i = 0;
		int j = arr.length - 1;

		List<Integer[]> res = new ArrayList<>();
		while (i < j) {
			if (arr[i] + arr[j] == target) {
				res.add(new Integer[] { i, j });
				i++;
				j--;
			} else if (arr[i] + arr[j] < target)
				i++;
			else
				j--;
		}
		return res;
	}

	/*
	 * Given an array of N integers, and an integer K, find the number of pairs of
	 * elements in the array whose sum is equal to K.
	 * 
	 * Example 1:
	 * 
	 * Input: N = 4, K = 6 arr[] = {1, 5, 7, 1} Output: 2 Explanation: arr[0] +
	 * arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
	 * 
	 * Example 2:
	 * 
	 * Input: N = 4, K = 2 arr[] = {1, 1, 1, 1} Output: 6 Explanation: Each 1 will
	 * produce sum 2 with any 1.
	 */

	/*
	 * 
	 */
	protected int getPairsCount(int[] arr, int n, int k) {
		int ans = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : arr) {
			if (map.containsKey(k - i))
				ans += map.get(k - i);
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}
		return ans;
	}
}
