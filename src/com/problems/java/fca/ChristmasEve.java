package com.problems.java.fca;

public class ChristmasEve {

	public static void main(String[] args) {

		int moneyRequired = 5;
		int houses = 5;

		int count = 0;
		int rem = 0;
		while (houses > 0) {
			if (moneyRequired > rem) {
				moneyRequired--;
				rem++;
				count++;
			}
			houses--;
		}
		System.out.println(count);
	}

}
