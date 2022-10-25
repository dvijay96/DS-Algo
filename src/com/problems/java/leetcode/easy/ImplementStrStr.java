package com.problems.java.leetcode.easy;

public class ImplementStrStr {

	public static void main(String[] args) {

		String haystack = "mississippi";

		String needle = "issipi";

		System.out.println(strStr(haystack, needle));

	}

	private static int strStr(String haystack, String needle) {

		if (needle.length() == 0)
			return 0;

		if (needle.length() <= haystack.length()) {
			for (int i = 0; i < haystack.length(); i++) {

				if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() - 2 < haystack.length()) {
					boolean isMatch = true;
					for (int j = 1, k = i + 1; j < needle.length() && k < haystack.length(); j++, k++) {
						if (haystack.charAt(k) != needle.charAt(j)) {
							isMatch = false;
							break;
						}
					}
					if (isMatch)
						return i;
				}
			}
		}
		return -1;
	}

}
