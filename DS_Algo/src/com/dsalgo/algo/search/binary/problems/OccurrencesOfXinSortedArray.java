package com.dsalgo.algo.search.binary.problems;

public class OccurrencesOfXinSortedArray {

	public static void main(String[] args) {

	}

	public int countOccurences(int arr[], int x) {
		int first = firstOccurrence(arr, x);
		int last = lastOccurence(arr, x);
		
		if (last == -1 || first == -1)
			return 0;
		else if (last == first) {
			return 1;
		} else
			return last - first + 1;
	}

	private int firstOccurrence(int[] arr, int x) {
		int s = 0;
		int e = arr.length - 1;
		int res = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (arr[mid] == x) {
				res = mid;
				e = mid - 1;
			} else if (x > arr[mid])
				s = mid + 1;
			else
				e = mid - 1;
		}
		return res;
	}

	private int lastOccurence(int[] arr, int x) {
		int s = 0;
		int e = arr.length - 1;
		int res = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (arr[mid] == x) {
				res = mid;
				s = mid + 1;
			} else if (x > arr[mid])
				s = mid + 1;
			else
				e = mid - 1;
		}
		return res;
	}
}
