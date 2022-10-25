package com.problems.java.leetcode.easy;

import java.util.Stack;

public class RomanToInteger {

	public static void main(String[] args) {
		String str = "III";
		System.out.println(new RomanToInteger().romanToIntApproach2(str));
	}

	public int romanToIntApproach1(String s) {
		int sum = 0;
		if (s.length() > 0) {
			Stack<Integer> stack = new Stack<>();
			stack.push(getIntegerValueOfRomanNumeral(s.charAt(0)));
			for (int i = 0; i < s.length(); i++) {
				int num = getIntegerValueOfRomanNumeral(s.charAt(i));
				if (stack.peek() < num) {
					int n = stack.pop();
					stack.push(num - n);
				} else {
					stack.push(num);
				}
			}
			while (!stack.isEmpty()) {
				sum = sum + stack.pop();
			}
		}
		return sum;
	}

	public int romanToIntApproach2(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()
					&& getIntegerValueOfRomanNumeral(s.charAt(i)) < getIntegerValueOfRomanNumeral(s.charAt(i + 1))) {
				sum = sum
						+ (getIntegerValueOfRomanNumeral(s.charAt(i + 1)) - getIntegerValueOfRomanNumeral(s.charAt(i)));
				i++;
			} else {
				sum = sum + getIntegerValueOfRomanNumeral(s.charAt(i));
			}
		}
		return sum;
	}

	public int getIntegerValueOfRomanNumeral(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
}
