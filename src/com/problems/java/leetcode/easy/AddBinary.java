package com.problems.java.leetcode.easy;

import java.util.Arrays;

/*
 * Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

* 1 <= a.length, b.length <= 104
* a and b consist only of '0' or '1' characters.
* Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {

	public static void main(String[] args) {
		System.out.println(getBinaryAddition("100", "110010"));
		System.out.println((int) '0' - 48);

	}

	public static int binaryToInteger(String s) {
		int sum = 0;
		int n = s.length() - 1;
		for (int i = n; i >= 0; i--) {
			int num = Integer.parseInt("" + s.charAt(i));
			double pow = Math.pow(2, (n - i));
			sum += num * pow;
		}
		return sum;
	}

	public static String getBinaryAddition(String a, String b) {
		int carry = 0;
		String res = "";
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
			int iVal = 0;
			int jVal = 0;
			if (i >= 0 && a.charAt(i) == '1')
				iVal = 1;
			if (j >= 0 && b.charAt(j) == '1')
				jVal = 1;
			int sum = iVal + jVal + carry;
			res = (sum % 2) + res;
			carry = sum / 2;
		}
		return res;
	}

	public static String addBinary(String a, String b) {

		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		String res = "";
		for (; i >= 0 && j >= 0; i--, j--) {
			int digSum = a.charAt(i) + b.charAt(j) + carry - 2 * 48;
			if (digSum > 2) {
				carry = 1;
				res = "1" + res;
			} else {
				if (digSum == 2) {
					carry = 1;
					res = "0" + res;
				} else {
					carry = 0;
					res = digSum + res;
				}
			}
		}
		if (i >= 0) {
			int digSum = a.charAt(i) + carry - 48;
			if (digSum > 1) {
				for (; i >= 0; i--) {
					digSum = a.charAt(i) + carry - 48;
					if (digSum == 2) {
						carry = 1;
						res = "0" + res;
					} else {
						carry = 0;
						res = digSum + res;
					}
				}
				if (carry == 1) {
					return carry + res;
				}
			} else {
				return a.substring(0, i) + digSum + res;
			}
		}
		if (j >= 0) {
			int digSum = b.charAt(j) + carry - 48;
			if (digSum > 1) {
				for (; j >= 0; j--) {
					digSum = b.charAt(j) + carry - 48;
					if (digSum == 2) {
						carry = 1;
						res = "0" + res;
					} else {
						carry = 0;
						res = digSum + res;
					}
				}
				if (carry == 1) {
					return carry + res;
				}
			} else {
				return b.substring(0, j) + digSum + res;
			}

		}
		if (carry == 1) {
			return carry + res;
		}
		return res;
	}

}
