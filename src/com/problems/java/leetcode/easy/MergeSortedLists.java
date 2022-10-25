package com.problems.java.leetcode.easy;

/**
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists in a one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list. <br/>
 * Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
 *
 */
public class MergeSortedLists {

	ListNode head;

	public static void main(String[] args) {

		MergeSortedLists l1 = new MergeSortedLists();
		MergeSortedLists l2 = new MergeSortedLists();

//		for (int i = 0; i <= 5; i++) {
//			l1.addListNode(i);
//		}

		for (int i = 0; i <= 7; i++) {
			l2.addListNode(i);
		}

		printList(l1.head);
		printList(l2.head);

		ListNode list = l1.mergeTwoLists(l1.head, l2.head);

		printList(list);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode temp = new ListNode(0);
		ListNode curr = temp;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if (l1 != null) {
			curr.next = l1;
			l1 = l1.next;
		}
		if (l2 != null) {
			curr.next = l2;
			l2 = l2.next;
		}
		return temp.next;
	}

	public ListNode mergeTwoListsApproach2(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l1 : l2;
		}
		ListNode head = l1, curr = head, prev = curr;

		if (l1.val > l2.val) {
			head = l2;
			curr = head;
			prev = curr;
		}
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr = l1;
				l1 = l1.next;
			} else {
				curr = l2;
				l2 = l2.next;
			}
			prev.next = curr;
			prev = curr;
			curr = curr.next;
		}
		if (l1 != null) {
			prev.next = l1;
		} else {
			prev.next = l2;
		}
		return head;
	}

	public void addListNode(int val) {
		ListNode node = new ListNode(val);
		if (head == null) {
			head = node;
			return;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	private static void printList(ListNode node) {
		ListNode temp = node;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
