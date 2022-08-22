package com.dsalgo.ds.lists.problems;

import java.util.Stack;

public class ListReversal {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void display(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static Node reverse(Node head) {
		Node prev = null;
		Node next;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	private static Node reverseUsingStack(Node head) {
		Stack<Node> stack = new Stack<>();
		Node prev = null;
		while (head != null) {
			stack.push(head);
			prev = head;
			head = head.next;
			prev.next = null;
		}
		head = stack.pop();
		Node temp = head;
		while (!stack.isEmpty()) {
			temp.next = stack.pop();
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		display(head);
		head = reverse(head);
		display(head);

		head = reverseUsingStack(head);
		display(head);
		int size = 0;
		System.out.println(length(head, size));
	}

	public static int length(Node head, int size) {
		if (head != null) {
			size += length(head.next, size);
		}
		return size;
	}

}
