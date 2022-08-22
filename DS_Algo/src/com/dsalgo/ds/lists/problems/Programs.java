package com.dsalgo.ds.lists.problems;

import com.dsalgo.ds.lists.SingleLinkedList;
import com.dsalgo.ds.lists.SingleLinkedList.Node;

public class Programs {

	public static void main(String[] args) {

		SingleLinkedList list1 = new SingleLinkedList();
		for (int i = 1; i <= 10; i++)
			list1.addLast(i);

		System.out.println(list1);

		Programs obj = new Programs();

		obj.printNthNodeFromLast(list1, 11);
		obj.printMidNode(list1);
		obj.countFrequency(list1, 5);
		list1.addFirst(5);
		obj.countFrequency(list1, 5);

	}

	public void printNthNodeFromLast(SingleLinkedList list, int n) {
		Node head = list.getHead();
		if (head == null)
			System.out.println("List is empty");

		int size = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.getNext();
			size++;
		}
		if (n > size) {
			System.out.println("invalid position");
			return;
		}
		temp = head;
		int pos = 1;
		while (pos < (size - n + 1)) {
			temp = temp.getNext();
			pos++;
		}
		System.out.println(temp.getData());
	}

	public void printMidNode(SingleLinkedList list) {
		Node head = list.getHead();
		if (head == null)
			System.out.println("List is empty");

		int size = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.getNext();
			size++;
		}
		temp = head;
		int pos = 1;
		int mid = size / 2;
		while (pos < mid) {
			temp = temp.getNext();
			pos++;
		}
		System.out.println(temp.getData());
	}

	public void countFrequency(SingleLinkedList list, int key) {
		int count = 0;
		Node temp = list.getHead();
		while (temp != null) {
			if (temp.getData() == key)
				count++;
			temp = temp.getNext();
		}
		System.out.println(key + " occurs " + count + " times in the list");
	}

	private void createLoop(SingleLinkedList list) {
		Node temp = list.getHead();
		if(temp==null)
			System.out.println("List is empty!!!");
		else if(temp.getNext()!=null) {
			int i = 1;
			Node loopNode = null;
			while (temp.getNext() != null) {
				i++;
				if (i == 3)
					loopNode = temp;
				temp = temp.getNext();
			}
			
		}
	}

	public void checkIfLoopExists(SingleLinkedList list) {

	}

}
