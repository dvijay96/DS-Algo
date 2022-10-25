package com.problems.java.leetcode.easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] arr = { "flower","flower","flower" };
		long start = System.currentTimeMillis();
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(arr));
		System.out.println(System.currentTimeMillis()-start);
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs != null && strs.length > 0) {
			String commonPrefix = "";
			String first = strs[0];

			for (int i = 0; i < first.length(); i++) {
				boolean isCommon = true;
				for (int j = 1; j < strs.length; j++) {
					if (i < strs[j].length()) {
						if (!(strs[j].charAt(i) == first.charAt(i))) {
							isCommon = false;
							break;
						}
					} else {
						isCommon = false;
						break;
					}
				}
				if (isCommon)
					commonPrefix = commonPrefix + first.charAt(i);
				else
					break;
			}
			return commonPrefix;
		}
		return "";
	}
}
