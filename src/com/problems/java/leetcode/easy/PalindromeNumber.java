package com.problems.java.leetcode.easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		int x = 1;
		PalindromeNumber obj = new PalindromeNumber();
		System.out.println(obj.isPalindrome(x));
		System.out.println(obj.approach1(x));
	}

	public boolean isPalindrome(int x) {
		String str = x + "";
		StringBuilder strb = new StringBuilder(str);
		return str.equals(strb.reverse().toString());
	}

	public boolean approach1(int x) {
		if (x < 0)
			return false;
		int revnum = 0;
		int temp = x;
		while (temp != 0) {
			int digit = temp % 10;
			revnum = revnum * 10 + digit;
			temp = temp / 10;
		}
		return revnum == x;
	}
}
