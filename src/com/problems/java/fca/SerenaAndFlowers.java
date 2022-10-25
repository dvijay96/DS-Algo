package com.problems.java.fca;

import java.util.HashSet;
import java.util.Set;

public class SerenaAndFlowers {

	public static void main(String[] args) {

		int input1 = 5;
		int input2 = 3;
		int arr1[] = new int[] { 1,1,2,1,5 };
		
		Set<Integer> res=new HashSet<>();
		
		for(int i=0;i<input2 && i<arr1.length;i++) {
			res.add(arr1[i]);
		}

		System.out.println(res.size());
	}

	public static void approach1(int input2, int[] arr1) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr1.length && input2 > 0; i++, input2--) {
			set.add(arr1[i]);
		}

		System.out.println(set.size());
	}

}
