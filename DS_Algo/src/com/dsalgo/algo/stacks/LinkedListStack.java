package com.dsalgo.algo.stacks;

import java.util.EmptyStackException;

import com.dsalgo.exceptions.CustomException;

public class LinkedListStack implements Stack {

	Node head;

	public class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListStack stack = new LinkedListStack();
		for (int i = 1; i <= 10; i++)
			stack.push(i);

		stack.display();
		stack.pop();
		stack.display();
		System.out.println(stack.peek());
		stack.display();
	}

	/**
	 * adds the element at the top of the stack
	 * 
	 * @param val
	 */
	public void push(int val) {
		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			Node temp = head;
			head = node;
			node.next = temp;
		}
	}

	/**
	 * @return removes the top element from the stack and returns it.
	 * @throws EmptyStackException when stack empty
	 */
	public int pop() {
		if (head == null)
			throw new CustomException("Stack is empty");
		Node temp = head;
		head = temp.next;
		return temp.val;
	}

	/**
	 * @return the top element from the stack without removing it from the stack
	 * @throws EmptyStackException when stack empty
	 */
	public int peek() {
		if (head == null)
			throw new CustomException("Stack is empty");
		return head.val;
	}

	/**
	 * prints the stack
	 */
	@Override
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}
}
