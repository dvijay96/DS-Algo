package com.dsalgo.ds.lists;

import java.util.LinkedHashMap;

import com.dsalgo.exceptions.CustomException;

/**
 * Implementation of Single LinkedList in java
 * 
 * @author dvijay
 *
 */
public class SingleLinkedList implements List {

	/**
	 * head of the linked list
	 */
	private Node head;

	/**
	 * 
	 * Node of the LinkedList
	 */
	public class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

		public int getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

	}

	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		for (int i = 1; i <= 5; i++)
			list1.addLast(i);

		System.out.println(list1);

		list1.createLoop(3);
		list1.detectAndCountLoop();

	}

	/**
	 * adds the element at the front of the list
	 * 
	 * @param val
	 */
	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	/**
	 * adds the element at the last of the list
	 * 
	 * @param val
	 */
	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	/**
	 * gets the list as string
	 */
	private String getList() {
		Node temp = head;
		String list = "";
		while (temp != null) {
			if (temp == head)
				list = list + "[" + temp.data + ",";
			else if (temp.next == null)
				list = list + temp.data + "]";
			else
				list = list + temp.data + ",";
			temp = temp.next;
		}
		return list;
	}

	/**
	 * deletes first element from the list
	 */
	public void deleteFirst() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
	}

	/**
	 * deletes the last element from the list
	 */
	public void deleteLast() {
		Node temp = head;
		Node prev = null;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
	}

	/**
	 * deletes the first occurrence of the given element from the list
	 * 
	 * @param val
	 */
	public void delete(int val) {
		if (head == null)
			throw new CustomException("List is empty!!!");
		Node temp = head;
		Node prev = head;
		if (temp.data == val) {
			head = temp.next;
			temp.next = null;
			return;
		}
		while (temp != null) {
			if (temp.data == val) {
				prev.next = temp.next;
				temp.next = null;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
	}

	/**
	 * deletes the element at the given index from the list
	 * 
	 * @param index
	 */
	public void deleteAt(int index) {
		Node temp = head;
		Node prev = head;
		if (index < 0 || index > size() - 1)
			throw new IndexOutOfBoundsException(index);
		while (index > 0) {
			prev = temp;
			temp = temp.next;
			index--;
		}

		if (temp == head) {
			head = temp.next;
			temp.next = null;
		} else {
			prev.next = temp.next;
			temp.next = null;
		}
	}

	/**
	 * 
	 * @return size of the list
	 */
	public int size() {
		Node temp = head;
		int size = 0;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}

	/**
	 * 
	 * @param val to be searched in the list
	 * @return index of the val from the list
	 */
	public int indexOf(int val) {
		Node temp = head;
		for (int i = 0; temp != null; i++) {
			if (temp.data == val)
				return i;
			temp = temp.next;
		}
		return -1;
	}

	public void insertAt(int val, int index) {
		if (index > size() || index < 0)
			throw new IndexOutOfBoundsException(index);
		else if (index == 0)
			addFirst(val);
		else if (index == size())
			addLast(val);
		else {
			Node node = new Node(val);
			Node temp = head;
			Node prev = head;
			while (index > 0) {
				prev = temp;
				temp = temp.next;
				index--;
			}
			node.next = temp;
			prev.next = node;
		}

	}

	public Node getHead() {
		return head;
	}

	/**
	 * Gives the string representation of the node list for the provided head node.
	 * 
	 * @param node
	 * @return String representation of node list
	 */
	public static String printNodeList(Node node) {
		String s = "";
		Node temp = node;
		while (temp != null) {
			s = s + temp.data + " ";
			temp = temp.next;
		}
		return s;
	}

	@Override
	public String toString() {
		return getList();
	}

	private void createLoop(int atPos) {
		atPos = atPos % size();
		if (head == null)
			System.out.println("List is empty!!!");
		Node temp = head;

		if (temp.next != null) {
			int i = -1;
			Node loopNode = null;
			while (temp.getNext() != null) {
				i++;
				if (i == atPos)
					loopNode = temp;
				temp = temp.next;
			}
			temp.next = loopNode;
		}
	}

	public void detectAndCountLoop() {
		LinkedHashMap<Node, Integer> map = new LinkedHashMap<>();

		int pos = 0;
		boolean loopExists = false;
		Node temp = head;
		while (temp != null) {
			if (map.containsKey(temp)) {
				loopExists = true;
				pos = map.get(temp);
				break;
			}
			map.put(temp, ++pos);
			temp = temp.next;
		}

		if (loopExists) {
			System.out.println("Loop exists");
			System.out.println("Length of loop = " + (map.size() - pos + 1));
		}
	}
}
