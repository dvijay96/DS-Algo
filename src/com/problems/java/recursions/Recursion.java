package com.problems.java.recursions;

import java.util.Arrays;

public class Recursion {

	public static void main(String[] args) {

		Recursion obj = new Recursion();
		obj.printNumberDesc(5);
		System.out.println();
		obj.printNumberAsc(1);
		System.out.println("\n" + obj.sumOfNumbersDesc(10));

		System.out.println(obj.printSum(1, 10, 0));

		System.out.println(obj.factorial(5));

		System.out.print(0 + " " + 1 + " ");
		obj.printFibonacci(0, 1, 6);
		System.out.println("\n Power = " + obj.pow(2, 2));

		
		System.out.println(obj.printReverse("abcd", 4));

		String str = "abcdabsaabsca";
		char ch = 'v';
		System.out.println(obj.firstOccurence(str, ch, 0));
		System.out.println(obj.lastOccurence(str, ch, str.length() - 1));

		System.out.println(Arrays.toString(obj.firstAndLastOccurrence(str, ch, 0, -1, -1)));
	}

	/**
	 * print n to 1
	 * 
	 * @param n
	 */
	void printNumberDesc(int n) {
		if (n < 1) // Base case
			return;
		System.out.print(n + " "); // print activity
		printNumberDesc(n - 1); // recursive call
	}

	/**
	 * print 1 to n
	 * 
	 * @param n
	 */
	void printNumberAsc(int n) {
		if (n > 5) // Base case
			return;
		System.out.print(n + " "); // print activity
		printNumberAsc(n + 1); // recursive call
	}

	/**
	 * 
	 * @param n
	 * @return sum of n natural numbers
	 */
	int sumOfNumbersDesc(int n) {
		if (n == 0)
			return 0;
		return n + sumOfNumbersDesc(n - 1);
	}

	/**
	 * 
	 * @param i
	 * @param n
	 * @param sum
	 * @return sum of natural numbers from i to n
	 */
	int printSum(int i, int n, int sum) {
		if (i == n) {
			return sum + i;
		}
		sum = sum + i;
		return printSum(i + 1, n, sum);
	}

	/**
	 * 
	 * @param n
	 * @return factorial of n
	 */
	int factorial(int n) {
		if (n == 1 || n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	void printFibonacci(int a, int b, int n) {
		if (n == 0)
			return;
		System.out.print((a + b) + " ");
		printFibonacci(b, a + b, n - 1);
	}

	/**
	 * 
	 * @param n
	 * @param e
	 * @param height
	 * @return power n^e in O(n) stack height or O(n) TC
	 */
	int pow(int n, int e, int height) {
		if (n == 0 || e == 0) {
			height++;
			System.out.println("\nHeight of stack =" + height);
			return 1;
		}
		if (e == 1) {
			height++;
			System.out.println("\nHeight of stack =" + height);
			return n;
		}
		height++;
		return n * pow(n, e - 1, height);
	}

	/**
	 * 
	 * @param n
	 * @param e
	 * @return power n^e in O(logn) TC
	 */
	int pow(int n, int e) {

		if (e == 0 || n == 0)
			return 1;
		if (e == 1)
			return n;

		// logic
		// x^2 = x^(2/2) * x^(2/2); if power is even

		// x^3 = x^(2/2) * x^(2/2) * x; if power is odd
		if (e % 2 == 0)
			return pow(n, e / 2) * pow(n, e / 2);
		else
			return pow(n, e / 2) * pow(n, e / 2) * n;
	}

	/**
	 * 
	 * @param str
	 * @param len
	 * @return the reverse of the string
	 */
	String printReverse(String str, int len) {
		if (len == 1) {
			return str.charAt(len - 1) + "";
		}
		return str.charAt(len - 1) + printReverse(str, len - 1);
	}

	/**
	 * 
	 * @param str       - input string
	 * @param ch        - the character value that is to be searched in the input
	 *                  string
	 * @param fromIndex - the index from which the required character is to be
	 *                  searched
	 * @return 1st occurrence of the char <strong>ch</strong> in String
	 *         <strong>str</strong>
	 */
	int firstOccurence(String str, char ch, int fromIndex) {

		if (fromIndex == str.length())
			return -1;
		else if (str.charAt(fromIndex) == ch) {
			return fromIndex;
		}
		return firstOccurence(str, ch, fromIndex + 1);
	}

	/**
	 * 
	 * @param str       - input string
	 * @param ch        - the character value that is to be searched in the input
	 *                  string
	 * @param fromIndex - the index from which the required character is to be
	 *                  searched
	 * @return last occurrence of the char <strong>ch</strong> in String
	 *         <strong>str</strong>
	 */
	int lastOccurence(String str, char ch, int fromIndex) {

		if (fromIndex < 0)
			return -1;
		else if (str.charAt(fromIndex) == ch) {
			return fromIndex;
		}
		return lastOccurence(str, ch, fromIndex - 1);
	}

	/**
	 * 
	 * @param str
	 * @param ch
	 * @param index
	 * @param first
	 * @param last
	 * @return
	 */
	int[] firstAndLastOccurrence(String str, char ch, int index, int first, int last) {
		if (index == str.length())
			return new int[] { first, last };
		if (str.charAt(index) == ch) {
			if (first <= -1)
				first = index;
			last = index;
		}
		return firstAndLastOccurrence(str, ch, index + 1, first, last);
	}
}
