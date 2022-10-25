package com.problems.java;

import java.util.Set;
import java.util.TreeSet;

public class PrimeNumber {

	public static void main(String[] args) {

		PrimeNumber obj = new PrimeNumber();
		System.out.println(obj.getPrimeNumbers(6));

	}

	public boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public Set<Integer> getPrimeNumbers(int size) {
		Set<Integer> set = new TreeSet<>();

		set.add(2);
		set.add(3);
		size = size - 2;
		for (int i = 1; i <= size / 2; i++) {
			set.add(6 * i + 1);
			set.add(6 * i - 1);
		}
		return set;
	}

	public boolean isPrime2(int n) {
		if (n > 1) {
			
		}
		return false;
	}
}
