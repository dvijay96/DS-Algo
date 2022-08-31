package com.dsalgo.algo.sortings.examples;

import java.util.Arrays;

import com.dsalgo.algo.sortings.examples.model.Student;
import com.dsalgo.utility.Utility;

@Deprecated
public final class StableQuickSortDutchNational {

	public static void main(String[] args) {
		StableQuickSortDutchNational obj = new StableQuickSortDutchNational();

		Student[] arr = Utility.generateInput();

		System.out.println("Before -> " + Arrays.toString(arr));

		obj.quickSort(arr, 0, arr.length - 1);

		System.out.println("After -> " + Arrays.toString(arr));

	}

	public void quickSort(Student[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	private int partition(Student[] arr, int low, int high) {

		int pivot = arr[high].age;
		int start = low;
		int end = high;
		int i = start;

		while (i <= end) {
			if (arr[i].age < pivot) {
				swap(arr, i, start);
				i++;
				start++;
			} else if (arr[i].age > pivot) {
				swap(arr, i, end);
				end--;
			} else {
				i++;
			}
		}
		return start;
	}

	private void swap(Student[] arr, int i, int j) {
		Student temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
