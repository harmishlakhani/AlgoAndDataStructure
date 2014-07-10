package com.ds.linkedlist;

public class DLLNode<E> {

	private E data;
	private DLLNode<E> next;
	private DLLNode<E> prev;
	
	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public DLLNode<E> getNext() {
		return next;
	}
	
	public void setNext(DLLNode<E> next) {
		this.next = next;
	}

	public DLLNode<E> getPrev() {
		return prev;
	}

	public void setPrev(DLLNode<E> prev) {
		this.prev = prev;
	}	
}
