package com.dsalgo.basicmath;

public class Divisors {

	public static void main(String[] args) {

		printDivisors(36);
		System.out.println();
		print(36);
	}

	static void printDivisors(int n) {
		System.out.print(1 + " ");

		for (int i = 2; i <= n / 2; i++)
			if (n % i == 0)
				System.out.print(i + " ");
		System.out.print(n);
	}

	static void print(int n) {
		for (int i = 1; i <= Math.sqrt(n); i++)
			if (n % i == 0) {
				System.out.print(i + " ");
				if (i != n / i)
					System.out.print(n / i + " ");
			}
	}
}
