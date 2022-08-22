package com.dsalgo.algo.search.binary.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * You have been given a sorted array/list ARR consisting of ‘N’ elements. You are also given an integer ‘K’.
Now, your task is to find the first and last occurrence of ‘K’ in ARR.
Note :
1. If ‘K’ is not present in the array, then the first and the last occurrence will be -1. 
2. ARR may contain duplicate elements.
For example, if ARR = [0, 1, 1, 5] and K = 1, then the first and last occurrence of 1 will be 1(0 - indexed) and 2.
 */
public class FirstAndLastElement {

	public static void main(String[] args) {

	}

	public int[] firstAndLastPositionBinary(ArrayList<Integer> arr, int n, int k) {

		int first = getFirstOccurrence(arr, k);
		int last = getLastOccurrence(arr, k);

		return new int[] { first, last };
	}

	public int getFirstOccurrence(List<Integer> arr, int k) {
		int s = 0;
		int e = arr.size() - 1;
		int res = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			// when element found at mid , keep searching for the element
			// in the left half of the array
			if (arr.get(mid) == k) {
				res = mid;
				e = mid - 1;
			} else if (k > arr.get(mid))
				s = mid + 1;
			else
				e = mid - 1;
		}
		return res;
	}

	public int getLastOccurrence(List<Integer> arr, int k) {
		int s = 0;
		int e = arr.size() - 1;
		int res = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			// when element found at mid , keep searching for the element
			// in the right half of the array
			if (arr.get(mid) == k) {
				res = mid;
				s = mid + 1;
			} else if (k > arr.get(mid))
				s = mid + 1;
			else
				e = mid - 1;
		}
		return res;
	}

	public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {

		int i = 0;
		int j = arr.size() - 1;
		boolean first = false;
		boolean last = false;
		int[] res = { -1, -1 };
		while (i <= j) {
			if (arr.get(i) == k) {
				res[0] = i;
				first = true;
			} else {
				i++;
			}
			if (arr.get(j) == k) {
				res[1] = j;
				last = true;
			} else {
				j--;
			}
			if (first && last)
				break;
		}
		return res;
	}
}
