package com.problems.java.fca;

public class Swapper {

	public static void main(String[] args) {

		String str = "aabaa";

		int swaps = countSwaps(str);
		System.out.println(swaps);

	}

	public static int countSwaps(String str) {
		if (str.equals(getReverse(str)))
			return 0;

		char[] arr = str.toCharArray();
		int swaps = 0;
		for (int i = 0, j = arr.length - 1; i != j && i < arr.length && j >= 0; i++, j--) {
			if (arr[i] != arr[j]) {
				char temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				swaps++;
			}
		}
		str = new String(arr);

		if (str.equals(getReverse(str)))
			return swaps;
		else
			return -1;
	}

	private static String getReverse(String str) {
		StringBuilder builder = new StringBuilder(str);
		return builder.reverse().toString();
	}

}
