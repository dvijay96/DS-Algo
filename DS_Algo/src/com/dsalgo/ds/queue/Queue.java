package com.dsalgo.ds.queue;

public interface Queue {

	/**
	 * enqueue - Adds the element at the rear i.e end of the queue
	 * 
	 * @param val
	 */
	public void add(int val);

	/**
	 * dequeue - Removes the first element from the queue if exists and returns it
	 * 
	 * @return
	 */
	public int remove();

	/**
	 * 
	 * @return the front element of this queue without removing it
	 */
	public int peek();

	/**
	 * prints the queue
	 */
	public void display();

	/**
	 * returns true if queue is empty
	 * 
	 * @return
	 */
	public boolean isEmpty();
}
