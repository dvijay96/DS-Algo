package com.dsalgo.ds.queue;

import com.dsalgo.exceptions.CustomException;

public class LinkedListQueue implements Queue {

	private Node head;
	private Node tail;

	class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return head == null && tail == null;
	}

	@Override
	public void add(int val) {
		Node node = new Node(val);
		if (tail == null)
			tail = head = node;
		else {
			tail.next = node;
			tail = node;
		}
	}

	@Override
	public int remove() {
		if (isEmpty())
			throw new CustomException("Queue is empty!!!");
		int res = head.val;
		if (head == tail) {
			tail = null;
		}
		head = head.next;
		return res;
	}

	@Override
	public int peek() {
		if (isEmpty())
			throw new CustomException("Queue is empty!!!");
		return head.val;
	}

	@Override
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue queue = new LinkedListQueue();

//		for (int i = 1; i <= 1000000; i++) {
//			queue.add(i);
//			queue.remove();
//		}
		queue.add(10);
		queue.remove();
		queue.add(12);
		queue.add(1);
		queue.display();
		queue.remove();
		queue.display();
	}

}
