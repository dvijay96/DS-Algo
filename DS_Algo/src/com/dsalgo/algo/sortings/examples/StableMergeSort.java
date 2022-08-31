package com.dsalgo.algo.sortings.examples;

import java.util.Arrays;

import com.dsalgo.algo.sortings.examples.model.Student;
import com.dsalgo.utility.Utility;

public class StableMergeSort {

	public static void main(String[] args) {
		stableMergeSortExample();
	}

	public static void stableMergeSortExample() {
		System.out.println("Stable Merge sort !!!");

		Student[] arr = Utility.generateInput();

		System.out.println("Before -> " + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("After -> " + Arrays.toString(arr));
	}

	private static void mergeSort(Student[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(Student[] arr, int low, int mid, int high) {
		Student[] temp = new Student[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= high) {
			if (arr[i].age < arr[j].age) {
				temp[k++] = arr[i++];
			} else if (arr[i].age > arr[j].age) {
				temp[k++] = arr[j++];
			} else {
				temp[k++] = arr[i++];
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}

		for (i = low, j = 0; j < temp.length; j++, i++) {
			arr[i] = temp[j];
		}
	}
}
