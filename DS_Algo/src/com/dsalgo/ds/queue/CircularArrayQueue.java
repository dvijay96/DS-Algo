package com.dsalgo.algo.queue;

import com.dsalgo.exceptions.CustomException;

public class CircularArrayQueue implements Queue {

	private int front = -1;
	private int rear = -1;

	private int size = 10;
	private int[] arr = new int[size];

	public CircularArrayQueue() {
		super();
	}

	public CircularArrayQueue(int size) {
		super();
		arr = new int[size];
		this.size = size;
	}

	public boolean isEmpty() {
		return rear == -1 && front == -1;
	}

	public boolean isFull() {
		return (rear + 1) % size == front;
	}

	@Override
	public void add(int val) {
		if (isFull())
			throw new CustomException("Queue is full");
		else {
			if (front == -1) {
				front = 0;
			}
			rear = (rear + 1) % size;
			arr[rear] = val;
		}
	}

	@Override
	public int remove() {
		if (isEmpty())
			throw new CustomException("Queue is empty");
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
	public int peek() {
		if (isEmpty())
			throw new CustomException("Queue is empty");
		else {
			return arr[front];
		}
	}

	@Override
	public void display() {
		int i = front;
		for (; i != rear; i = (i + 1) % size) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(arr[i]);
		System.out.println();
	}

	public static void main(String[] args) {

		CircularArrayQueue queue = new CircularArrayQueue();

		for (int i = 1; i <= 10; i++)
			queue.add(i);
		queue.display();
		queue.remove();
		queue.display();
		queue.add(10);
		System.out.println(queue.peek());
		System.out.println(queue.front);
		System.out.println(queue.rear);
	}

}
