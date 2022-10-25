package com.problems.java.leetcode.easy;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and
 * only the integer part of the result is returned.
 * 
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 4 Output: 2 Example 2:
 * 
 * Input: x = 8 Output: 2 Explanation: The square root of 8 is 2.82842..., and
 * since the decimal part is truncated, 2 is returned.
 *
 */
public class Sqrt {

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;

		long start = System.nanoTime();

		long res = (long) Math.sqrt(a);

		long end = System.nanoTime();

		System.out.println("Math.sqrt() " + res + "    Time taken = " + (end - start));

		Sqrt obj = new Sqrt();

		start = System.nanoTime();

		res = obj.getSqrt(a);

		end = System.nanoTime();

		System.out.println("BS approach = " + res + "   time taken = " + (end - start));

		start = System.nanoTime();

		res = obj.approach2(a);

		end = System.nanoTime();

		System.out.println("Approach 2 = " + res + "  time taken =" + (end - start));
	}

	public int getSqrt(int x) {
		int start = 1;
		int end = x;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid == x / mid)
				return mid;
			else if (mid > x / mid)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return end;
	}

	public int approach2(int x) {
		int temp;
		int sqrt = x / 2;
		do {
			temp = sqrt;
			sqrt = (temp + (x / temp)) / 2;
		} while ((temp - sqrt) != 0);

		return sqrt;
	}
}
