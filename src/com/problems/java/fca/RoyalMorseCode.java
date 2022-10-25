package com.problems.java.fca;

public class RoyalMorseCode {

	public static void main(String[] args) {

		String[] strArray = { "....---.-", ".-.-.-.-", "...---.-","...--- iwd" };
		int count = 0;
		for (String str : strArray) {
			if (str.charAt(0) == '.' && str.charAt(str.length() - 1) == '-') {
				int dashCount = 0, dotCount = 0;
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '.')
						dotCount++;
					else if (str.charAt(i) == '-')
						dashCount++;
					else {
						dotCount = 0;
						dashCount = 0;
						break;
					}
				}
				if (dashCount == dotCount)
					count++;
			}
		}
		System.out.println(count);

	}

}
