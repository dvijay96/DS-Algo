package com.problems.java.fca;

import java.util.HashSet;
import java.util.Set;

public class WeddingGame {

	public static void main(String[] args) {

		String str = "1234";
		int k = 30;

		int count = 0;
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < Math.pow(2, str.length()); i++) {
			int n = i;
			String s = "";
			for (int j = str.length() - 1; j >= 0; j--) {
				int rem = n % 2;
				n = n / 2;
				if (rem == 1) {
					if (!set.contains(str.charAt(j))) {
						set.add(str.charAt(j));
						s = "" + str.charAt(j) + s;
					}
				}

			}
			if (s.length() > 0 && Integer.parseInt(s) <= k) {
				System.out.println(s);
			}
//				count++;
		}
		System.out.println(count);
	}

}
