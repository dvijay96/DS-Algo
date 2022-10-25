package com.problems.java.hakerrank;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given unsorted array of size n with elements ranging from 1 to n.<br/>
 * Find the minimum number of swaps required to sort the array in ascending
 * order. <br/>
 * Given array [4, 3, 1, 2] <br/>
 * After swapping (0,2) we get [1, 3, 4, 2] <br/>
 * After swapping (1,2) we get [1, 4, 3, 2] <br/>
 * After swapping (1,3) we get [1, 2, 3, 4] <br/>
 * So, we need a minimum of 3 swaps to sort the array in ascending order.
 *
 */
public class MinimumSwaps {

	public static void main(String[] args) {

		int[] arr = { 5, 4, 3, 2, 1 };

		new AtomicInteger();
		
		System.out.println(minimumSwaps(arr));
	}

	static int minimumSwaps(int[] arr) {
		int swapCount = 0;
		for (int i = 0; i < arr.length;) {
			if (i != arr[i] - 1) {
				int temp1 = arr[i];
				arr[i] = arr[arr[i] - 1];
				arr[temp1 - 1] = temp1;
				swapCount++;
			} else {
				i++;
			}
		}
		return swapCount;
	}
}
