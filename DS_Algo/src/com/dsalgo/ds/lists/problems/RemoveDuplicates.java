package com.dsalgo.ds.lists.problems;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

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

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(1);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next = new Node(3);

		display(head);
		head = removeDuplicates(head);
		display(head);

	}

	/**
	 * remove duplicates from sorted list and returns the head
	 * 
	 * @param head
	 * @return
	 */
	public static Node removeDuplicates(Node head) {
		if (head == null)
			return head;
		Node prev = head;
		Node curr = head;

		while (curr != null) {
			if (curr.data != prev.data) {
				prev.next = curr;
				prev = curr;
			}
			curr = curr.next;
		}

		if (prev != curr)
			prev.next = null;
		return head;
	}

	/**
	 * for sorted list
	 * 
	 * @param head
	 * @return
	 */
	public static Node removeDuplicates2(Node head) {
		Node current = head;
		while (current != null && current.next != null) {
			if (current.next.data == current.data)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return head;
	}

	/**
	 * removes duplicates from a unsorted list
	 * 
	 * @param head
	 */
	public static void removeDuplicatesNonSorted(Node head) {
		Set<Integer> set = new HashSet<>();
		Node cur = head;
		Node prev = null;
		while (cur != null) {
			// If set doesn't contain the element , make next of prev
			// point to the next of curr
			if (set.contains(cur.data)) {
				prev.next = cur.next;
			} else {
				set.add(cur.data);
				prev = cur;
			}
			cur = cur.next;
		}
	}
}
