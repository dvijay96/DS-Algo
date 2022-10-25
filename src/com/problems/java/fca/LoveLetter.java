package com.problems.java.fca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoveLetter {

	public static void main(String[] args) {

		String given = "hello there";
		final int k = 3;

		approach2(given, k);
	}

	public static void approach2(String given, final int k) {
		String[] wordArr = given.split(" ");
		System.out.println(Arrays.toString(wordArr));
		List<String> chars;
		int count = 0;
		for (int i = 0; i < wordArr.length; i++) {
			chars = new ArrayList<>();
			char[] arr = wordArr[i].toCharArray();
			for (int j = 0; j < arr.length; j++) {
				chars.add("" + arr[j]);
			}
			System.out.println("Chars: " + chars.toString());
			Collections.rotate(chars, k);
			String res = "";
			for (String s : chars) {
				res = res + s;
			}
			System.out.println("Chars: " + chars.toString());
			if (res.equalsIgnoreCase(wordArr[i]))
				count++;
		}

		System.out.println(Arrays.toString(wordArr));
		System.out.println(count);
	}

	public static void approach1(String given, final int k) {
		String[] wordArr = given.split(" ");

		String[] finalArr = Arrays.copyOf(wordArr, wordArr.length);

		for (int j = 0; j < finalArr.length; j++) {
			char[] charArr = finalArr[j].toCharArray();
			int rot = k;
			while (rot > 0) {
				char[] tempArr = new char[charArr.length];
				tempArr[0] = charArr[charArr.length - 1];
				for (int i = 1; i < tempArr.length; i++) {
					tempArr[i] = charArr[i - 1];
				}
				charArr = tempArr;
				rot--;
			}
			finalArr[j] = new String(charArr);
		}

		int count = 0;

		for (int i = 0; i < wordArr.length; i++) {
			if (wordArr[i].equals(finalArr[i])) {
				count++;
			}
		}

		System.out.println(count);
	}

}
