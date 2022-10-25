package com.problems.java.microsoft.easy;

/**
 * <pre>
 Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. 
 Find the missing element.
 
 Input:
N = 10
A[] = {6,1,2,8,3,4,7,10,5}
Output: 9
 * </pre>
 * 
 */
public class MissingNumber {

	public static void main(String[] args) {

		int[] arr = { 6, 1, 2, 8, 3, 4, 7, 10, 5 };

		System.out.println(missingNumber(arr, 10));
	}

//	Find the sum of N numbers A.
//	Find the sum of array elements B.
//	Missing number is A-B.
	public static int missingNumber(int arr[], int n) {

		int sumOfN = (n * (n + 1)) / 2;
		int arrSum = 0;

		for (int i : arr) {
			arrSum += i;
		}
		return sumOfN - arrSum;
	}
}
