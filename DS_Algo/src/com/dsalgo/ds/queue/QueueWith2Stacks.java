package com.dsalgo.ds.queue;

import com.dsalgo.ds.stacks.ArrayStack;
import com.dsalgo.exceptions.CustomException;

public class QueueWith2Stacks implements Queue {

	private ArrayStack stack1 = new ArrayStack();
	private ArrayStack stack2 = new ArrayStack();

	public static void main(String[] args) {
		QueueWith2Stacks queue = new QueueWith2Stacks();
		for (int i = 1; i <= 5; i++)
			queue.add(i);
		queue.display();
		queue.remove();
		queue.display();
		queue.add(6);
		queue.display();
	}

	@Override
	public void add(int val) {
		while (!stack1.isEmpty())
			stack2.push(stack1.pop());
		stack1.push(val);
		while (!stack2.isEmpty())
			stack1.push(stack2.pop());
	}

	@Override
	public int remove() {
		if (isEmpty())
			throw new CustomException("Queue is empty!!!");
		return stack1.pop();
	}

	@Override
	public int peek() {
		if (isEmpty())
			throw new CustomException("Queue is empty!!!");
		return stack1.peek();
	}

	@Override
	public void display() {
		stack1.display();
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

}
