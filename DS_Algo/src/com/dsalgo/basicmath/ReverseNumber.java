package com.dsalgo.basicmath;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println(reverse(-121));
		System.out.println(isPalindrome(123));
	}

	static int reverse(int n) {
		int rev = 0;
		while (n != 0) {
			rev = (n % 10) + (rev * 10);
			n /= 10;
		}
		return rev;
	}

	static boolean isPalindrome(int n) {
		if (n < 0)
			return false;
		return n == reverse(n);
	}
}
