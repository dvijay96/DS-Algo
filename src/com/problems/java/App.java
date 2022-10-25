package com.problems.java;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {

	public static void main(String[] args) {

		int[] arr = new int[100000000];
		int j = 3;
		for (int i = 0; i < 10000 * 10000; i++) {
			arr[i] = (i * j) % 11;
		}

		Instant start = Instant.now();
		Map<Integer, Integer> map = new HashMap<>();

//		for (int i : arr) {
//			map.put(i, map.getOrDefault(i, 0) + 1);
//		}

		generateMap(arr, 0, arr.length - 1, map);
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).getSeconds());
		map.entrySet().forEach(System.out::println);

	}

	private static void generateMap(int[] arr, int i, int j, Map<Integer, Integer> map) {
		if (i <= j) {
			int mid = i + (j - i) / 2;
			map.put(arr[mid], map.getOrDefault(arr[mid], 0) + 1);
			generateMap(arr, i, mid - 1, map);
			generateMap(arr, mid + 1, j, map);
		}
	}

	static void quickSort(ArrayList<Integer> arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	static int partition(ArrayList<Integer> arr, int low, int high) {
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

	public static boolean wordPattern(String pattern, String s) {

		Map<Character, List<Integer>> patternMap = new LinkedHashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			if (patternMap.containsKey(pattern.charAt(i))) {
				patternMap.get(pattern.charAt(i)).add(i);
			} else {
				List<Integer> indexList = new ArrayList<>();
				indexList.add(i);
				patternMap.put(pattern.charAt(i), indexList);
			}
		}

		Map<String, List<Integer>> stringMap = new LinkedHashMap<>();

		String[] strArr = s.split(" ");

		for (int i = 0; i < strArr.length; i++) {
			if (stringMap.containsKey(strArr[i])) {
				stringMap.get(strArr[i]).add(i);
			} else {
				List<Integer> indexList = new ArrayList<>();
				indexList.add(i);
				stringMap.put(strArr[i], indexList);
			}
		}
		for (Entry<Character, List<Integer>> e : patternMap.entrySet()) {

		}
		if (patternMap.size() == stringMap.size()) {

			List<List<Integer>> patternIndices = new ArrayList<>(patternMap.values());
			List<List<Integer>> wordIndices = new ArrayList<>(stringMap.values());

			boolean isMatch = true;
			for (int i = 0; i < patternIndices.size(); i++) {
				if (!patternIndices.get(i).equals(wordIndices.get(i))) {
					isMatch = false;
				}
			}
			return isMatch;
		}

		return false;
	}

	private static void sort(List<Student> list, int s, int e) {

		if (s >= e)
			return;
		int m = s + (e - s) / 2;
		sort(list, s, m);
		sort(list, m + 1, e);
		merge(list, s, m, e);
	}

	private static void merge(List<Student> list, int s, int m, int e) {
		Student[] arr = new Student[e - s + 1];
		int i = s;
		int j = m + 1;
		int k = 0;

		while (i <= m && j <= e) {
			if (list.get(i).age < list.get(j).age)
				arr[k++] = list.get(i++);
			else
				arr[k++] = list.get(j++);
		}

		while (i <= m)
			arr[k++] = list.get(i++);

		while (j <= e)
			arr[k++] = list.get(j++);

		for (i = 0, j = s; i < arr.length; i++, j++) {
			list.remove(j);
			list.add(j, arr[i]);
		}

	}

	public static String checkEvenSubArrSumZero(int[] arr) {
		for (int i = 0; i < arr.length - 1; i = i + 2) {
			if (arr[i] + arr[i + 1] != 0)
				return "NO";
		}
		return "YES";
	}

}

class Student {
	String name;
	int age;

	@Override
	public String toString() {
		return "{name=" + name + ", age=" + age + "}";
	}

}