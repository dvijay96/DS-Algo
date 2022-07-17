package com.dsalgo.algo.queue;

public interface Dequeue {

	/**
	 * inserts element at the front of the Dequeue
	 * 
	 * @param val
	 */
	public void insertFront(int val);

	/**
	 * inserts element at the rear of the Dequeue
	 * 
	 * @param val
	 */
	public void insertRear(int val);

	/**
	 * removes the front element and returns the same
	 * 
	 * @return the front element
	 */
	public int deleteFront();

	/**
	 * removes the rear element and returns the same
	 * 
	 * @return the rear element
	 */
	public int deleteRear();

	/**
	 * returns the 1st element from the front of the dequeue
	 * 
	 * @return
	 */
	public int peekFront();

	/**
	 * returns the 1st element from the rear of the dequeue
	 * 
	 * @return
	 */
	public int peekRear();

	/**
	 * @return true if Dequeue is empty otherwise false
	 */
	public boolean isEmpty();

	/**
	 * @return true if Dequeue is full otherwise false
	 */
	public boolean isFull();
}
