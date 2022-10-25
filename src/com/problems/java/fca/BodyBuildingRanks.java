package com.problems.java.fca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * E-litmus coding test
 *
 */
public class BodyBuildingRanks {

	public static void main(String[] args) {

		int[] arr = { 128, 66, 345, 999, 200 };

		int k = 87;

		Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] % k)) {
				map.get(arr[i] % k).add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(arr[i] % k, list);
			}
		}

		List<Integer> result = new ArrayList<>();

		for (List<Integer> i : map.values()) {
			i.forEach(index -> result.add(arr[index]));
		}

		System.out.println(result);
	}

}
