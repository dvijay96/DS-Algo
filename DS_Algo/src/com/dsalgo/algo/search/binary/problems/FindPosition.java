package com.dsalgo.algo.search.binary.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * You have been given a sorted array/list ARR consisting of ‘N’ elements. You
 * are also given an integer ‘K’. Now the array is rotated at some pivot point
 * unknown to you. For example, if ARR = [ 1, 3, 5, 7, 8]. Then after rotating
 * ARR at index 3, the array will be ARR = [7, 8, 1, 3, 5]. Now, your task is to
 * find the index at which ‘K’ is present in ARR. Note : 1. If ‘K’ is not
 * present in ARR then print -1. 2. There are no duplicate elements present in
 * ARR. 3. ARR can be rotated only in the right direction. For example, if ARR =
 * [12, 15, 18, 2, 4] and K = 2, then the position at which K is present in the
 * array is 3 (0-indexed).
 */
public class FindPosition {

	public static void main(String[] args) {

		FindPosition obj = new FindPosition();

		int[] arr = { 10, 20, 30, 30, 40, 50 };

		List<Integer> list = new ArrayList<>();

		for (int i : arr) {
			list.add(i);
		}

		Collections.rotate(list, 4);
		System.out.println(list);
		System.out.println(obj.findPositionWithBinary(list, 40));
	}

	/*
	 * Naive approach -> O(n)
	 */
	public int findPosition(List<Integer> arr, int n, int k) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == k)
				return i;
		}
		return -1;
	}

	/*
	 * Binary approach -> O(logn)
	 */
	public int findPositionWithBinary(List<Integer> arr, int key) {

		int start = 0;
		int end = arr.size() - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if (arr.get(mid) == key)
				return mid;

			// check if left half is sorted or not
			
			else if (arr.get(start) <= arr.get(mid)) {

				// check if the key falls in the range start -> mid
				
				if (key >= arr.get(start) && key <= arr.get(mid))
					end = mid - 1;

				// search in right half in the next iteration
				else
					start = mid + 1;
			}
			// means right half is sorted
			else {

				// check if key falls in the range mid -> end
				if (key >= arr.get(mid) && key <= arr.get(end))
					start = mid + 1;

				// search in left half in the next iteration
				else
					end = mid - 1;
			}
		}
		return -1;
	}
}
