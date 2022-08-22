package com.dsalgo.ds.lists.problems;

public class SwapNodes {

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

	public static Node add(Node head, int val) {

		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		return head;
	}

	public static void main(String[] args) {

		Node head = null;

		for (int i = 1; i <= 7; i++)
			head = add(head, i);

		display(head);

		head = swap(head, 2, 3);

		display(head);

	}

	private static Node swap(Node head, int x, int y) {

		if (x == y)
			return head;
		Node cx, cy, px, py, prev;
		cx = cy = px = py = prev = null;
		Node curr = head;

		while (curr != null) {
			if (px == null && curr.data == x) {
				px = prev;
				cx = curr;
			}
			if (py == null && curr.data == y) {
				py = prev;
				cy = curr;
			}
			prev = curr;
			curr = curr.next;
		}

		if (cx == null || cy == null) {
			System.out.println("Swap not possible!!!");
			return head;
		}
		if (px != null)
			px.next = cy;
		else
			head = cy;
		if (py != null)
			py.next = cx;
		else
			head = cx;

		curr = cx.next;
		cx.next = cy.next;
		cy.next = curr;

		return head;
	}

}
