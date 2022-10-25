package com.problems.java.fca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WeddingInvitation {

	public static void main(String[] args) {

		int boyPos = 4, girlPos = 6;
		int[][] arr = new int[6][2];

		System.out.println("Enter relation matrix (p1,p2) : ");

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();
		int count = relatives(arr, boyPos, girlPos);

		System.out.println(count);

	}

	private static int relatives(int[][] arr, int boyPos, int girlPos) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (map.containsKey(arr[i][j])) {
					if (j == 0)
						map.get(arr[i][j]).add(arr[i][1]);
					else
						map.get(arr[i][j]).add(arr[i][0]);
				} else {
					Set<Integer> set = new HashSet<>();
					if (j == 0)
						set.add(arr[i][1]);
					else
						set.add(arr[i][0]);
					map.put(arr[i][j], set);
				}

			}
		}

		int count = 0;
		System.out.println(map);

//		boolean hasPath = true;
//
//		while (hasPath) {
//
//		}

		return count;
	}

}
