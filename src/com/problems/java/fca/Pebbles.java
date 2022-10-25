package com.problems.java.fca;

public class Pebbles {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 5;

		int subsets = (int) Math.pow(2, arr.length);
		int count = 0;
		for (int i = 0; i < subsets; i++) {
			int n = i;
			int sum = 0;
			for (int j = arr.length - 1; j >= 0; j--) {
				int rem = n % 2;
				n = n / 2;
				if (rem == 1)
					sum += arr[j];
			}
			if (sum % k == 0)
				count++;
		}
		System.out.println(count);
	}
}
