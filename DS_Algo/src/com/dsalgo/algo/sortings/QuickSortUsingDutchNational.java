package com.dsalgo.algo.sortings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSortUsingDutchNational {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		Random rand = new Random();

		for (int i = 0; i < 10; i++) {
			list.add(rand.nextInt(10));
		}

		QuickSortUsingDutchNational obj = getInstance();

		System.out.println(list);

		obj.quickSort(list, 0, list.size() - 1);

		System.out.println(list);
	}

	public void quickSort(List<Integer> arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	private int partition(List<Integer> arr, int low, int high) {
		int pivot = arr.get(high);
		int i = low;
		int start = low;
		int end = high;

		while (i <= end) {
			if (arr.get(i) < pivot) {
				int temp = arr.get(i);
				arr.set(i, arr.get(start));
				arr.set(start, temp);
				start++;
				i++;
			} else if (arr.get(i) > pivot) {
				int temp = arr.get(i);
				arr.set(i, arr.get(end));
				arr.set(end, temp);
				end--;
			} else {
				i++;
			}
		}
		return start;
	}

	private static QuickSortUsingDutchNational instance;

	private QuickSortUsingDutchNational() {

	}

	public static QuickSortUsingDutchNational getInstance() {
		if (instance == null)
			instance = new QuickSortUsingDutchNational();
		return instance;
	}
}
