package com.dsalgo.ds.lists;

import com.dsalgo.exceptions.CustomException;

public class DoublyLinkedList implements List {

	private Node head;

	private int size = -1;

	private class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	@Override
	public void addFirst(int val) {
		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++;
	}

	@Override
	public void addLast(int val) {
		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			node.prev = temp;
			temp.next = node;
			temp = node;
		}
		size++;
	}

	@Override
	public void deleteFirst() {
		if (head == null)
			throw new CustomException("List is Empty!!!");
		if (head.next == null)
			head = head.next;
		else {
			head = head.next;
			head.prev.next = null;
			head.prev = null;
		}
		size--;
	}

	@Override
	public void deleteLast() {
		if (head == null)
			throw new CustomException("List is Empty!!!");
		Node prev = null;
		Node temp = head;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		temp.prev = null;
		if (prev != null)
			prev.next = null;
		else
			head = prev;
		size--;
	}

	@Override
	public void delete(int val) {
		if (head == null)
			throw new CustomException("List is Empty!!!");
		if (head.data == val)
			deleteFirst();
		else {
			Node temp = head;
			while (temp.data != val)
				temp = temp.next;
			if (temp.data == val) {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				size--;
			}
		}
	}

	@Override
	public void deleteAt(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(index);
		else {
			if (index == 0)
				deleteFirst();
			else if (index == size)
				deleteLast();
			else {
				Node temp = head;
				while (index > 0) {
					temp = temp.next;
					index--;
				}
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
			}
			size--;
		}
	}

	@Override
	public int size() {
		return size + 1;
	}

	@Override
	public int indexOf(int val) {
		int index = 0;
		Node temp = head;
		while (temp != null) {
			if (temp.data == val)
				return index;
			temp = temp.next;
			index++;
		}
		return -1;
	}

	@Override
	public void insertAt(int val, int index) {
		if (index < -1)
			throw new IndexOutOfBoundsException(index);
		else {
			if (index == 0)
				addFirst(val);
			else if (index == size)
				addLast(val);
			else {
				Node node = new Node(val);
				Node temp = head;
				while (index > 0) {
					temp = temp.next;
					index--;
				}
				node.prev = temp.prev;
				node.next = temp;
				temp.prev.next = node;
				temp.prev = node;
				size++;
			}
		}
	}

	public static void main(String[] args) {
		List list = new DoublyLinkedList();

		list.addFirst(2);
		list.addFirst(2);
		list.addFirst(2);
		list.addFirst(2);
		list.addLast(5);
		System.out.println(list);
		list.deleteFirst();
		System.out.println(list.indexOf(7));
		list.deleteLast();
		System.out.println(list);
	}

	@Override
	public String toString() {
		String res = "";
		Node temp = head;
		while (temp != null) {
			res = res + temp.data + " ";
			temp = temp.next;
		}
		return res;
	}

}
