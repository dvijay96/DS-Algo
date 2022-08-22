package com.dsalgo.ds.stacks;

import com.dsalgo.ds.queue.ArrayQueue;
import com.dsalgo.ds.queue.Queue;

public class StackWith2Queues {

	public static void main(String[] args) {

		int[] arr = { 4, 6, 8, 1 };

		Queue q1 = new ArrayQueue(arr.length);
		Queue q2 = new ArrayQueue(arr.length);

		for (int i : arr) {

// one by one pop q1 and push into q2
			while (!q1.isEmpty())
				q2.add(q1.remove());

// push the new element in q1
			q1.add(i);

// again one by one pop q2 and push back into q1
			while (!q2.isEmpty())
				q1.add(q2.remove());
		}

		System.out.println(q1); // Q1 is in stack order
	}

}
