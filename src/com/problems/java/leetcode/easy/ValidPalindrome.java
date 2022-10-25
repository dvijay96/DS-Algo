package com.problems.java.leetcode.easy;

/**
 * <pre>
 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 * </pre>
 */
public class ValidPalindrome {

	public static void main(String[] args) {

		String s = "a b 101_b_a";

		ValidPalindrome obj = new ValidPalindrome();

		System.out.println(obj.isPalindrome(s));
		System.out.println(obj.isPalindromeIterative(s));
		System.out.println(obj.isPalindromeRecursive(s.toLowerCase(), 0, s.length() - 1));
	}

//	1. lowerCase the string
//	2. Two pointers , begin and end
//	3. if begin and end alphaNumeric and not equal , then false
//	4. if begin nonAlphaNumeric , increment begin
//	5. if end nonAplhaNumeric , decrement end
//	6. else increment begin and decrement end.
	public boolean isPalindromeIterative(String s) {
		s = s.toLowerCase();

		for (int i = 0, j = s.length() - 1; i < j;) {
			if (isAlphaNumeric(s.charAt(i)) && isAlphaNumeric(s.charAt(j)) && s.charAt(i) != s.charAt(j)) {
				return false;
			} else if (!isAlphaNumeric(s.charAt(i))) {
				i++;
			} else if (!isAlphaNumeric(s.charAt(j))) {
				j--;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

	boolean isAlphaNumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}

//	1. Same as recursive , but requires string to be lower cased already.
	public boolean isPalindromeRecursive(String s, int begin, int end) {
		while (begin < end) {
			if (isAlphaNumeric(s.charAt(begin)) && isAlphaNumeric(s.charAt(end)) && s.charAt(begin) != s.charAt(end)) {
				return false;
			} else if (!isAlphaNumeric(s.charAt(begin))) {
				return isPalindromeRecursive(s, begin + 1, end);
			} else if (!isAlphaNumeric(s.charAt(end))) {
				return isPalindromeRecursive(s, begin, end - 1);
			} else {
				return isPalindromeRecursive(s, begin + 1, end - 1);
			}
		}
		return true;
	}

//	Best solution found
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			while (!Character.isLetterOrDigit(s.charAt(start))) {
				start++;
				continue;
			}
			while (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
				continue;
			}

			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
				return false;

			start++;
			end--;
		}
		return true;
	}
}
