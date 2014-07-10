package com.ds.linkedlist;

public class DoublyLinkedList<E> {

	private DLLNode<E> head;

	public DLLNode<E> getHead() {
		return head;
	}

	public void setHead(DLLNode<E> head) {
		this.head = head;
	}

	public int length() {
		int length = 0;
		DLLNode temp = head;
		while(temp != null) {
			temp = temp.getNext();
			length++;
		}
		return length;
	}
	
	public void print() {
		DLLNode temp = head;
		if(temp == null) {
			System.out.println("List is empty");
			return;
		}
		while(temp != null) {
			System.out.print(temp.getData() + " <-> ");
			temp = temp.getNext();
		}
		System.out.print("null");
	}
		
	public void insertAtPosition(E e, int position) {
		
		DLLNode<E> node = new DLLNode<E>();
		node.setData(e);
		
		DLLNode<E> temp = head;
		if(temp == null) {
			head = node;
			return;
		}
		
		int length = length();
		if(position > length + 1 || position < 1) {
			System.out.println("Please enter valid position between ( 1, " + (length + 1) + " )");
			return;
		}
		
		if(position == 1) {
			node.setNext(head);
			head.setPrev(node);
			head = node;
		} else {
			int count = 1;
			while(temp != null && count < position - 1 ) {
				temp = temp.getNext();
				count++;
			}
			node.setNext(temp.getNext());
			node.setPrev(temp);
			if(temp.getNext() != null)
				temp.getNext().setPrev(node);
			temp.setNext(node);
		}
	}
	
	public void deleteAtPosition(int position) {
		
		DLLNode<E> temp = head;
		if(temp == null) {
			System.out.println("List is empty.");
			return;
		}
		
		int length = length();
		if(position > length || position < 1) {
			System.out.println("Please enter valid position between ( 1, " + (length + 1) + " )");
			return;
		}
		
		if(position == 1) {
			head = temp.getNext();
			head.setPrev(null);
			temp = null;
		} else {
			int count = 1;
			while(temp != null && count < position - 1 ) {
				temp = temp.getNext();
				count++;
			}
			DLLNode temp2 = temp.getNext();
			temp.setNext(temp2.getNext());
			if(temp2.getNext() != null)
				temp2.getNext().setPrev(temp);
			temp2 = null;
		}
		
	}
	public static void main(String[] args) {

		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.insertAtPosition(10, 0);
		list.insertAtPosition(20, 1);
		list.insertAtPosition(30, 3);
		list.insertAtPosition(40, 3);
		list.print();
		
		list.deleteAtPosition(8);
		list.print();
	}

}
