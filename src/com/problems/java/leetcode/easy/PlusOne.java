package com.problems.java.leetcode.easy;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: digits = [1,2,3] Output: [1,2,4] Explanation: The array represents the
 * integer 123. Incrementing by one gives 123 + 1 = 124. Thus, the result should
 * be [1,2,4]. Example 2:
 * 
 * Input: digits = [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents
 * the integer 4321. Incrementing by one gives 4321 + 1 = 4322. Thus, the result
 * should be [4,3,2,2]. Example 3:
 * 
 * Input: digits = [9] Output: [1,0] Explanation: The array represents the
 * integer 9. Incrementing by one gives 9 + 1 = 10. Thus, the result should be
 * [1,0].
 * 
 * 
 * Constraints:
 * 
 * 1 <= digits.length <= 100 0 <= digits[i] <= 9 digits does not contain any
 * leading 0's.
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] arr = { 9 };
		System.out.println(Arrays.toString(new PlusOne().plusOne(arr)));
	}

	public int[] plusOne(int[] digits) {

		int carry = 0;
		digits[digits.length - 1] = digits[digits.length - 1] + 1;
		if (digits[digits.length - 1] > 9) {
			digits[digits.length - 1] = 0;
			carry = 1;
		}
		for (int i = digits.length - 2; i >= 0; i--) {
			digits[i] = digits[i] + carry;
			if (digits[i] > 9) {
				digits[i] = 0;
				carry = 1;
			} else {
				carry = 0;
			}
		}
		if (carry == 1) {
			int res[] = new int[digits.length + 1];
			res[0] = carry;
			for (int i = 1; i < res.length; i++) {
				res[i] = digits[i - 1];
			}
			return res;
		}
		return digits;
	}

	public int[] approach2(int[] digits) {
		int index;

		for (index = digits.length - 1; index >= 0 && digits[index] == 9; index--) {
			digits[index] = 0;
		}

		if (index == -1) { // If all the element were 9 then index became -1
			int newDigits[] = new int[digits.length + 1];
			newDigits[0] = 1; // Set first index 1 and rest of set to be zero
			return newDigits;
		}

		digits[index]++; // Here we found non 9 so we just added plus 1
		return digits;
	}

	public int[] approach2Similar(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		int[] ans = new int[n + 1];
		ans[0] = 1;
		return ans;

	}
}
