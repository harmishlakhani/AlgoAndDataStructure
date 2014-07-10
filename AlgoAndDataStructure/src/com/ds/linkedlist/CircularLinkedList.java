package com.ds.linkedlist;

public class CircularLinkedList<E> {

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
			if(temp == head)
				break;
		}
		return length;
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
			if(temp == head)
				break;
		}
		System.out.print("[HEAD] " + temp.getData());
	}
	
	public void insertAtBegin(E e) {
		
		Node<E> node = new Node<E>();
		node.setData(e);
		node.setNext(node);
		
		Node<E> temp = head;
		if(temp == null) {
			head = node;
			return;
		}
		
		node.setNext(head);
		while(temp != null && temp.getNext() != head) {
			temp = temp.getNext();
		}
		temp.setNext(node);
		head = node;
	}
	
	public void insertAtEnd(E e) {
		
		Node<E> node = new Node<E>();
		node.setData(e);
		node.setNext(node);
		
		Node<E> temp = head;
		
		if(temp == null) {
			head = node;
			return;
		}
		
		while(temp != null && temp.getNext() != head) {
			temp = temp.getNext();
		}
		temp.setNext(node);
		node.setNext(head);
	}
	
	public void insertAtPosition(E e, int position) {
		
		Node<E> node = new Node<E>();
		node.setData(e);
		node.setNext(node);
		
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
			while(temp != null && temp.getNext() != head) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			head = node;
			
		} else if(position == length + 1) {
			
			while(temp != null && temp.getNext() != head) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setNext(head);
			
		} 
		else {
			int count = 1;
			while(temp != null && count < position - 1 ) {
				temp = temp.getNext();
				count++;
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
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
			
			while(temp != null && temp.getNext() != head) {
				temp = temp.getNext();
			}
			temp.setNext(head.getNext());
			head = temp.getNext();
			
		} else if(position == length) {
			
			Node temp2 = temp;
			while(temp != null && temp.getNext() != head) {
				temp2 = temp;
				temp = temp.getNext();
			}
			temp2.setNext(head);
			temp = null;
		} 
		else {
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

		CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
		list.insertAtPosition(10, 1);
		list.insertAtPosition(20, 2);
		list.insertAtPosition(30, 3);
		list.insertAtPosition(40, 4);
		list.insertAtPosition(50, 5);
		list.insertAtPosition(60, 6);
		
		list.deleteAtPosition(4);
		list.print();
	}

}
