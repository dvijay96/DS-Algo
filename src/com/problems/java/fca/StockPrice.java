package com.problems.java.fca;

public class StockPrice {

	public static void main(String[] args) {

		int[] arr = new int[] { -39957, -17136, 35466, 21820, -26711 };

		int least = leastPrice(arr);

		System.out.println(least);
		
	}

	private static int leastPrice(int[] arr) {
		int currentStockPrice = 0;
		int least = 0;
		for (int i = 0; i < arr.length; i++) {
			currentStockPrice = currentStockPrice + arr[i];
			if (currentStockPrice < least)
				least = currentStockPrice;
		}
		return least;
	}

	/*private static int stock(int[] arr) {
		int[] values = new int[arr.length];
		int min;
		values[0] = arr[0];
		min = values[0];
		for (int i = 1; i < arr.length; i++) {
			values[i] = values[i - 1] + arr[i];
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}*/

}
