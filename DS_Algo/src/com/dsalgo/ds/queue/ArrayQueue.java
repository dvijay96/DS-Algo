package com.dsalgo.algo.queue;

import com.dsalgo.exceptions.CustomException;

public class ArrayQueue implements Queue {

	private int rear = -1;

	private int size = 10;
	private int[] arr = new int[size];

	public ArrayQueue() {
		super();
	}

	public ArrayQueue(int size) {
		super();
		arr = new int[size];
		this.size = size;
	}

	@Override
	public void add(int val) {
		if (rear >= arr.length - 1)
			throw new CustomException("Stack is full");
		arr[++rear] = val;
	}

	@Override
	public int remove() {
		if (rear == -1)
			throw new CustomException("Stack is empty");
		int front = arr[0];
		for (int i = 0; i < rear; i++) {
			arr[i] = arr[i + 1];
		}
		rear--;
		return front;
	}

	@Override
	public int peek() {
		if (rear == -1)
			throw new CustomException("Stack is empty");
		return arr[0];
	}

	@Override
	public void display() {
		int front = 0;
		while (front <= rear) {
			System.out.print(arr[front++] + " ");
		}
		System.out.println();
	}

	@Override
	public boolean isEmpty() {
		return rear == -1;
	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();

		for (int i = 1; i <= 10; i++)
			queue.add(i);
		queue.display();
		queue.remove();
		queue.display();
		queue.add(12);
		queue.display();
		System.out.println(queue.peek());
	}

}
