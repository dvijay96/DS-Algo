package com.dsalgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		String s = "Hello World i";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				count = 0;
			else
				count++;
		}
		System.out.println(count);
		
		List<Integer> list=new LinkedList<>();
		list.add(0, 2);
		System.out.println(list);
	}

	public static void approach1() {
		String digits = "0123456789";
		String s = "-13-46";
		List<String> list = new ArrayList<>();
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (digits.contains(s.charAt(i) + "")) {
				temp = temp + s.charAt(i);
				list.add(temp);
				temp = "";
			} else {
				temp = temp + s.charAt(i);
			}
		}
		System.out.println(list);
		int max = 0;
		for (int i = 0; i < Math.pow(2, list.size()); i++) {
			int n = i;
			int sum = 0;
			for (int j = list.size() - 1; j >= 0; j--) {
				int rem = n % 2;
				n = n / 2;
				if (rem == 1)
					sum = sum + Integer.parseInt(list.get(j));
			}
			if (sum > max)
				max = sum;
		}
		System.out.println(max);
	}
}
