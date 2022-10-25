package com.problems.java.fca;

public class LongNumberPossibilities {

	public static void main(String[] args) {
		int[] arr = { 9, 9 };

		int add = 0;
		int max = 0;
		int pos = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] + 1 > 9) {
				add = 1;
				arr[i] = 0;
			} else {
				arr[i] = arr[i] + add;
				add = 0;
				if (arr[i] > max) {
					max = arr[i];
					pos = i + 1;
				}
			}
		}

//		System.out.println(Arrays.toString(arr));
		System.out.println(pos);
	}

}
