package com.problems.java.leetcode;

import java.util.Collections;
import java.util.List;

public class LetterComboPhoneNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> letterCombinations(String digits) {

		return Collections.emptyList();
	}

	public String getChars(int digit) {
		String[] arr = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if (digit - 2 >= 0 && digit - 2 < arr.length) {
			return arr[digit - 2];
		}
		return null;
	}
}
