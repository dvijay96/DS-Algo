package com.problems.java.fca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Numbers {

	public static void main(String[] args) {
		int n = 10;
		for (int i = 0; i <= n; i++) {
			if (isPrime(i))
				System.out.println(i);
		}
	}

	private static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void approach1() {
		int d = 8;
		int k = 2;

		List<Integer> primeNums = new ArrayList<>();
		int i = 2;
		while (k > 0) {
			if (isPrime(i)) {
				primeNums.add(i);
				k--;
			}
			i++;
		}
		System.out.println("Diff exercises: " + primeNums);

		int sum = 0, count = 0;
		k = primeNums.size();
		while (sum != d) {
			count++;
			sum = sum + primeNums.get(k - 1);
			if (!((d - sum) % primeNums.get(k - 1) == 0)) {
				k--;
			}
		}

		System.out.println("Count : " + count);
	}

	private static boolean isPrime(Integer num) {
		if (num <= 1)
			return false;
		return IntStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);
	}
}
