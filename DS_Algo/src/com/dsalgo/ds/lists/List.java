package com.dsalgo.ds.lists;

public interface List {

	public void addFirst(int val);

	public void addLast(int val);

	public void deleteFirst();

	public void deleteLast();

	public void delete(int val);

	public void deleteAt(int index);

	public int size();

	public int indexOf(int val);

	public void insertAt(int val, int index);

}
