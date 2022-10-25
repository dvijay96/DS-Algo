package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		System.out.println(log(81234, 10) + 1);
		System.out.println(reverse(-121));
		System.out.println(gcd(5, 10));
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static int reverse(int n) {
		int rev = 0;
		while (n != 0) {
			int digit = n % 10;
			rev = digit + (rev * 10);
			n = n / 10;
		}
		return rev;
	}

	static int log(int n, int base) {
		int ans = 0;
		int temp = 1;
		while (true) {
			temp *= base;
			if (temp > n)
				break;
			ans++;
		}
		return ans;
	}

	public static void countLastWordLength() {
		String s = "Hello World iam";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				count = 0;
			else
				count++;
		}
		System.out.println(count);
	}

	public static void approach1() {
		String digits = "0123456789";
		String s = "-13-46";
		List<String> list = new ArrayList<>();
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (digits.contains(s.charAt(i) + "")) {
				temp = temp + s.charAt(i);
				list.add(temp);
				temp = "";
			} else {
				temp = temp + s.charAt(i);
			}
		}
		System.out.println(list);
		int max = 0;
		for (int i = 0; i < Math.pow(2, list.size()); i++) {
			int n = i;
			int sum = 0;
			for (int j = list.size() - 1; j >= 0; j--) {
				int rem = n % 2;
				n = n / 2;
				if (rem == 1)
					sum = sum + Integer.parseInt(list.get(j));
			}
			if (sum > max)
				max = sum;
		}
		System.out.println(max);
	}
}
