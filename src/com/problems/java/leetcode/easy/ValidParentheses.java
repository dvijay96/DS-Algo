package com.problems.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {

		String s = "[][](){{{{}}}}";
		ValidParentheses obj = new ValidParentheses();
		System.out.println(obj.isValid(s));
	}

	/**
	 * 4ms runtime
	 */
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty() && map.get(stack.peek()) != null && s.charAt(i) == map.get(stack.peek()))
					stack.pop();
				else
					stack.push(s.charAt(i));
			}
		}
		return stack.isEmpty();
	}

	/**
	 * 
	 * 5ms runtime
	 */
	public boolean approach1(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if (stack.size() == 0) { // if string starts with closed bracket then its always false
					return false;
				}
				if ((s.charAt(i) == ')' && stack.peek() != '(') || (s.charAt(i) == '}' && stack.peek() != '{')
						|| (s.charAt(i) == ']' && stack.peek() != '[')) {
					return false;
				}

				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	/**
	 * 
	 * 115ms runtime
	 */
	public boolean approach2(String s) {
		while (s.indexOf("{}") != -1 || s.indexOf("[]") != -1 || s.indexOf("()") != -1) {
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");

		}
		return s.isEmpty();
	}
}
