package com.problems.java.fca;

public class ReducingDishes {

	public static void main(String[] args) {

		int[] arr = { -1, 10, 3 ,-5};
		int max = 0;
		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			int num = i;
			int sum = 0;

			for (int j = arr.length - 1; j >= 0; j--) {
				int rem = num % 2;
				num = num / 2;
				if (rem == 1)
					sum += arr[j] * (j + 1);
			}
			if (sum > max)
				max = sum;
		}

		System.out.println(max);
	}

}
