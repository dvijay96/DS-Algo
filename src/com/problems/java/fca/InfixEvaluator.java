package com.problems.java.fca;

import java.util.Stack;

public final class InfixEvaluator {

	public static void main(String[] args) {
		String str = "30+4*2/(1-5)";

		int result = evaluateInfixExpression(str);
		System.out.println(result);
	}

	public static int evaluateInfixExpression(String str) {
		Stack<Integer> numbers = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (Character.isDigit(c)) {
					num = num * 10 + Integer.parseInt("" + c);
					i++;
					if (i < str.length())
						c = str.charAt(i);
					else
						break;
				}
				i--;
				numbers.push(num);
			} else if (c == '(') {
				operators.push(c);
			} else if (c == ')') {
				while (operators.peek() != '(') {
					int output = performOperation(numbers, operators);
					numbers.push(output);
				}
				operators.pop();
			} else if (isOperator(c)) {
				while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
					int output = performOperation(numbers, operators);
					numbers.push(output);
				}
				operators.push(c);
			}
		}

		while (!operators.isEmpty()) {
			int output = performOperation(numbers, operators);
			numbers.push(output);
		}

		return numbers.pop();
	}

	private static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private static int performOperation(Stack<Integer> numbers, Stack<Character> operators) {
		int a = numbers.pop();
		int b = numbers.pop();
		char operator = operators.pop();
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			return b - a;
		case '*':
			return a * b;
		case '/':
			if (a == 0)
				throw new UnsupportedOperationException("Cannot divide by 0");
			return b / a;

		}
		return 0;
	}

}
