package com.dsalgo.ds.lists.problems;

import java.util.LinkedHashMap;

public class LoopDetectionAndCount {

	/* Link list node */
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static Node newNode(int key) {
		Node temp = new Node(key);

		return temp;
	}

	public static void main(String[] args) {

		Node head = newNode(1);
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);

		/* Create a loop for testing */
		head.next.next.next.next = head.next;

		detectAndCountLoop(head);
	}

	/**
	 * To check if the list contains loop or not If loop exists , notify and prints
	 * the length of the loop
	 * 
	 * @param head - Node head
	 */
	public static void detectAndCountLoop(Node head) {
		/*
		 * HashMap to store hash codes of previously visited nodes as key and their
		 * respective positions in the list as value
		 */
		LinkedHashMap<Node, Integer> map = new LinkedHashMap<>();

		int pos = 0;
		boolean loopExists = false;
		while (head != null) {

			// if encounters a previously visited node
			// gets the position of the node and breaks the loop
			// with loopExists flag as true
			if (map.containsKey(head)) {
				loopExists = true;
				pos = map.get(head);
				break;
			}
			map.put(head, ++pos);
			head = head.next;
		}

		if (loopExists) {
			System.out.println("Loop exists");
			System.out.println("Length of loop = " + (map.size() - pos + 1));
		} else {
			System.out.println("Loop doesn't exists");
		}
	}
}
