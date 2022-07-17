package com.dsalgo.ds.queue;

import com.dsalgo.exceptions.CustomException;

public class CircularArrayDeque implements Dequeue {

	private int front = -1;
	private int rear = -1;

	private int[] arr = new int[10];
	private int size = arr.length;

	/**
	 * creates a circular dequeue of size 10
	 */
	public CircularArrayDeque() {
		super();
	}

	/**
	 * creates a circular dequeue of given size
	 */
	public CircularArrayDeque(int size) {
		super();
		arr = new int[size];
		this.size = size;
	}

	public static void main(String[] args) {
		Dequeue queue = new CircularArrayDeque();

		for (int i = 1; i <= 5; i++) {
			queue.insertFront(i);
			queue.insertRear(i);
		}

		System.out.println(queue);
		queue.deleteFront();
		System.out.println(queue);
		queue.insertRear(10);
		System.out.println(queue);
		queue.deleteRear();
		System.out.println(queue);
		System.out.println(queue.peekFront());
		System.out.println(queue.peekRear());

	}

	@Override
	public void insertFront(int val) {
		if (isFull())
			throw new CustomException("Queue is full!!");
		if (isEmpty())
			front = rear = 0;
		else if (front == 0)
			front = size - 1;
		else
			front--;
		arr[front] = val;
	}

	@Override
	public void insertRear(int val) {
		if (isFull())
			throw new CustomException("Queue is full!!");
		if (isEmpty())
			front = rear = 0;
		else
			rear = (rear + 1) % size;
		arr[rear] = val;
	}

	@Override
	public int deleteFront() {
		if (isEmpty())
			throw new CustomException("Queue is empty!!");
		else {
			int res = arr[front];
			if (front == rear)
				front = rear = -1;
			else
				front = (front + 1) % size;
			return res;
		}
	}

	@Override
	public int deleteRear() {
		if (isEmpty())
			throw new CustomException("Queue is empty!!");
		else {
			int res = arr[rear];
			if (front == rear)
				front = rear = -1;
			else if (rear == 0)
				rear = size - 1;
			else
				rear--;
			return res;
		}
	}

	@Override
	public int peekFront() {
		if (isEmpty())
			throw new CustomException("Queue is empty!!");
		return arr[front];
	}

	@Override
	public int peekRear() {
		if (isEmpty())
			throw new CustomException("Queue is empty!!");
		return arr[rear];
	}

	@Override
	public boolean isEmpty() {
		return front == -1;
	}

	@Override
	public boolean isFull() {
		return (front == 0 && rear == size - 1) || front == rear + 1;
	}

	private String display() {
		if (isEmpty())
			return "";
		String res = "";
		int i = front;
		while (i != rear) {
			res = res + arr[i] + " ";
			i = (i + 1) % size;
		}
		res = res + arr[rear];
		return res;
	}

	@Override
	public String toString() {
		return display();
	}

}
