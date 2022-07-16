package com.dsalgo.algo.stacks;

import java.util.ArrayList;
import java.util.List;

import com.dsalgo.exceptions.CustomException;

public class ArrayListStack implements Stack {
	private int top = -1;

	private List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		ArrayListStack stack = new ArrayListStack();
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		stack.display();
		stack.pop();
		stack.display();
		System.out.println(stack.peek());
		stack.display();
	}

	public void push(int val) {
		list.add(++top, val);
	}

	public int pop() {
		if (top == -1)
			throw new CustomException("Stack is empty");
		int res = list.get(top);
		list.remove(top--);
		return res;
	}

	public int peek() {
		if (top == -1)
			throw new CustomException("Stack is empty");
		return list.get(top);
	}

	public void display() {
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
