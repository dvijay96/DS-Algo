package com.dsalgo.algo.sortings.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dsalgo.algo.sortings.examples.model.Student;
import com.dsalgo.utility.Utility;

public class StableQuickSort {

	public static void main(String[] args) {
		stableQuickSortExample();
	}

	public static void stableQuickSortExample() {
		System.out.println("Stable quick sort!!!");
		Student[] arr = Utility.generateInput();
		System.out.println("Before -> " + Arrays.toString(arr));
		arr = stableQuickSort(arr);
		System.out.println("After -> " + Arrays.toString(arr));
	}

	private static Student[] stableQuickSort(Student[] arr) {
		if (arr.length <= 1)
			return arr;

		int mid = arr.length / 2;
		Student pivot = arr[mid];

		List<Student> smaller = new ArrayList<>();
		List<Student> greater = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (i != mid) {
				if (arr[i].age < pivot.age)
					smaller.add(arr[i]);
				else if (arr[i].age > pivot.age)
					greater.add(arr[i]);
				else {
					if (i < mid)
						smaller.add(arr[i]);
					else
						greater.add(arr[i]);
				}
			}
		}

		List<Student> ans = new ArrayList<>();
		Student[] sa1 = stableQuickSort(smaller.toArray(new Student[0]));
		Student[] sa2 = stableQuickSort(greater.toArray(new Student[0]));

		for (Student s : sa1)
			ans.add(s);

		ans.add(pivot);

		for (Student s : sa2)
			ans.add(s);

		return ans.toArray(new Student[0]);
	}
}
