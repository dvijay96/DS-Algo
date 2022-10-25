package com.dsalgo.basicmath;

public class CountDigits {

	public static void main(String[] args) {
		System.out.println(logApproach(0));
		System.out.println(moduloApproach(1));
	}

	static int logApproach(int n) {
		int base = 10;
		int ans = 0;
		int temp = 1;
		while (true) {
			temp *= base;
			if (temp > n)
				break;
			ans++;
		}
		return ans + 1;
	}

	static int moduloApproach(int n) {
		if (n == 0) {
			return 1;
		}
		int ans = 0;
		while (n != 0) {
			n /= 10;
			ans++;
		}
		return ans;
	}
}
