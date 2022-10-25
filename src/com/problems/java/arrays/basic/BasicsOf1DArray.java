package com.problems.java.arrays.basic;

import java.util.Arrays;

public class BasicsOf1DArray {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 3, 8, 3, 32, 24, 1, 23, 8 };

		BasicsOf1DArray obj = new BasicsOf1DArray();

		// sum
		System.out.println(obj.sumOfElements(arr));

		// reverse
//		arr = obj.reverseArray(arr);
		System.out.println(Arrays.toString(arr));

		// index of
		System.out.println(obj.indexOf(arr, 8));

		// min and max
		obj.displyMinAndMax(arr);

		// Pair Sum
		System.out.println(obj.countPairSum(arr, 5));

		// left rotate
		System.out.println(Arrays.toString(obj.leftRotateByReversing(arr, 5)));

		// kth smallest
		System.out.println(obj.kthSmallestElement(arr, 3));

		// kth largest
		System.out.println(obj.kthLargetElement(arr, 3));

	}

	public int sumOfElements(int[] arr) {
		int sum = 0;

		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	public int[] reverseArray(int[] arr) {
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}

	/*
	 * returns 1st occurrence of the key in the array
	 */
	public int indexOf(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i])
				return i;
		}
		return -1;
	}

	public void displyMinAndMax(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i : arr) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}
		System.out.println("Max = " + max);
		System.out.println("Min = " + min);
	}

	public int countPairSum(int[] arr, int sum) {
		int count = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					count++;
					System.out.print(arr[i] + "," + arr[j] + " | ");
				}
			}
		}
		System.out.println();
		return count;
	}

	public int lastIndexOf(int[] arr, int key) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i])
				index = i;
		}
		return index;
	}

	public int[] leftRotate(int[] arr, int k) {
		while (k > 0) {
			int temp = arr[0];
			for (int i = 1; i < arr.length; i++) {
				arr[i - 1] = arr[i];
			}
			arr[arr.length - 1] = temp;
			k--;
		}
		return arr;
	}

	public int[] leftRotateByReversing(int[] arr, int k) {
		if (k == 0 || k == arr.length)
			return arr;

		k = k % arr.length;
		reverseArray(arr, 0, k - 1);
		reverseArray(arr, k, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);
		return arr;
	}

	public void reverseArray(int[] arr, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public int kthSmallestElement(int[] arr, int k) {
		Arrays.sort(arr);
		System.out.println("Sorted array => " + Arrays.toString(arr));
		int min = arr[0];
		int count = 1;
		boolean flag = false;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > min) {
				min = arr[i];
				count++;
			}
			if (count == k) {
				flag = true;
//				System.out.println(min + " ");
				break;
			}
		}
		if (!flag) {
//			System.out.println(-1 + " ");
			return -1;
		} else {
			return min;
		}

	}

	public int kthLargetElement(int[] arr, int k) {
		Arrays.sort(arr);
		System.out.println("Sorted array => " + Arrays.toString(arr));
		int max = arr[arr.length - 1];
		int count = 1;
		boolean flag = false;

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < max) {
				max = arr[i];
				count++;
			}
			if (count == k) {
				flag = true;
//				System.out.println(max + " ");
				break;
			}
		}
		if (!flag) {
//			System.out.println(-1 + " ");
			return -1;
		} else {
			return max;
		}
	}

	public void kthSmallestLargest(int arr[], int k) {
		Arrays.sort(arr);
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		int countMin = 0;
		int countMax = 0;
		boolean minFlag = false;
		boolean maxFlag = false;

		for (int i = 0, j = arr.length - 1; i < arr.length && j >= 0; i++, j--) {
			if (!minFlag && arr[i] > min) {
				min = arr[i];
				countMin++;
			}
			if (countMin == k) {
				minFlag = true;
			}
			if (!maxFlag && arr[j] < max) {
				max = arr[j];
				countMax++;
			}
			if (countMax == k) {
				maxFlag = true;
			}
		}

		if (!minFlag || !maxFlag) {
			System.out.println(-1 + " " + -1);
		} else {
			System.out.println(max + " " + min);
		}
	}

	/**
	 * takes unsorted array containing only 0, 1 & 2 and returns it sorted
	 * 
	 * @param arr
	 */
	public void sort012(int arr[]) {
		// Taking two pointer one at begining and other at the end of array.
		int low = 0;
		int high = arr.length - 1;
		int i = 0;

		while (i <= high) {

			// if arr[i] is equal to 0
			if (arr[i] == 0) {
				// swap (arr[i],arr[low])
				int t = arr[low];
				arr[low] = arr[i];
				arr[i] = t;
				low++;
				i++;
			} else if (arr[i] == 2) {
				// swap (arr[i],arr[high])
				int t = arr[high];
				arr[high] = arr[i];
				arr[i] = t;
				high--;
			}
			// if arr[i] is not equal to 0 and 2.
			else {
				i++;
			}
		}
	}
}
