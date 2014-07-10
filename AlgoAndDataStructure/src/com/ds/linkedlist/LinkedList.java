package com.ds.linkedlist;

public class LinkedList<E extends Comparable<E>> {

	private Node<E> head;

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public int length() {
		int length = 0;
		Node temp = head;
		while(temp != null) {
			temp = temp.getNext();
			length++;
		}
		return length;
	}
	
	public Node getLast() {
		Node temp = head;
		if(temp == null) {
			System.out.println("List is empty");
			return null;
		}
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	public void print() {
		Node temp = head;
		if(temp == null) {
			System.out.println("List is empty");
			return;
		}
		while(temp != null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
		System.out.print("null");
	}
	
	public void insertAtBegin(E e) {
		
		Node<E> node = new Node<E>();
		node.setData(e);
		node.setNext(head);
		head = node;
	}
	
	public void insertAtEnd(E e) {
		
		Node<E> node = new Node<E>();
		node.setData(e);
		
		Node<E> temp = head;
		
		if(temp == null) {
			head = node;
			return;
		}
		
		while(temp != null) {
			temp = temp.getNext();
		}
		temp.setNext(node);
		
	}
	
	public void insertAtPosition(E e, int position) {
		
		Node<E> node = new Node<E>();
		node.setData(e);
		
		Node<E> temp = head;
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
			head = node;
		} else {
			int count = 1;
			while(temp != null && count < position - 1 ) {
				temp = temp.getNext();
				count++;
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
	}
	
	public void insertInSortedOrder(E e) {
		
		Node<E> node = new Node<E>();
		node.setData(e);
		
		Node<E> temp = head;
		if(temp == null) {
			head = node;
			return;
		}
		Node temp2 = null;
		while(temp != null && (temp.getData().compareTo(node.getData()) < 0)) {
			temp2 = temp;
			temp = temp.getNext();
		}
		node.setNext(temp);
		if(temp2 == null)
			head = node;
		else
			temp2.setNext(node);
	}
	
	public void deleteAtPosition(int position) {
		
		Node<E> temp = head;
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
		} else {
			int count = 1;
			while(temp != null && count < position - 1 ) {
				temp = temp.getNext();
				count++;
			}
			Node temp2 = temp.getNext();
			temp.setNext(temp2.getNext());
			temp2 = null;
		}
		
	}
	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertInSortedOrder(10);
		list.insertInSortedOrder(50);
		list.insertInSortedOrder(30);
		list.insertInSortedOrder(0);
		list.insertInSortedOrder(-1);
		list.print();
	}

}
