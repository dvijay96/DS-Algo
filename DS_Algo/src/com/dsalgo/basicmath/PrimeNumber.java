package com.dsalgo.basicmath;

public class PrimeNumber {

	public static void main(String[] args) {

		for (int i = 1; i <= 20; i++)
			System.out.println(i + " -> " + isPrime(i));
	}

	static boolean isPrime(int n) {
		if (n < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
