package com.dsalgo.ds.stacks;

import java.util.EmptyStackException;

import com.dsalgo.exceptions.CustomException;

public class ArrayStack implements Stack {

	private int top = -1;
	private int size = 10;
	private int[] arr = new int[size];

	/**
	 * Creates a Array stack of size n
	 * 
	 * @param size
	 */
	public ArrayStack(int size) {
		super();
		arr = new int[size];
		this.size = size;
	}

	/**
	 * Creates a array stack of default size 10
	 */
	public ArrayStack() {
		super();
	}

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack();
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		stack.display();
		stack.pop();
		stack.display();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.display();
		stack.push(10);
		stack.display();
	}

	/**
	 * adds the element at the top of the stack
	 * 
	 * @param val
	 * @throws StackOverflowError when stack is full
	 */
	public void push(int val) {
		if (top == arr.length)
			throw new CustomException("Stack is full");
		arr[++top] = val;
	}

	/**
	 * @return removes the top element from the stack and returns it.
	 * @throws EmptyStackException when stack empty
	 */
	public int pop() {
		if (top < 0)
			throw new CustomException("Stack is empty");
		return arr[top--];
	}

	/**
	 * @return the top element from the stack without removing it from the stack
	 * @throws EmptyStackException when stack empty
	 */
	public int peek() {
		if (top < 0)
			throw new CustomException("Stack is empty");
		return arr[top];
	}

	/**
	 * prints the stack
	 */
	@Override
	public void display() {
		int i = top;
		if (top == arr.length)
			i = top - 1;
		for (; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}
}
