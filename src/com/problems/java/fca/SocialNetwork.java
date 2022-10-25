package com.problems.java.fca;

public class SocialNetwork {

	public static void main(String[] args) {

		int n = 10;
		int count = 1;
		for (int i = 2; i <= n + 1; i++) {
			if(isPrime(i) && 2*i>(n+1))
				count++;
		}
		System.out.println(count);

	}

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
