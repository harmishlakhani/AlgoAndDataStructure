package com.ds.linkedlist;

public class LinkedListUtility {

	public Node nthNodeFromLast(Node head, int n) {
		
		Node temp = head;
		Node nthTemp = head;
		
		if(head == null) {
			System.out.println("List is empty");
			return null;
		}
			
		int count = 1;
		while(temp.getNext() != null) {
			temp = temp.getNext();
			count++;
			
			if(count > n) {
				nthTemp = nthTemp.getNext();
			}
		}
		
		if(count < n) {
			System.out.println("Enter the n less than or equal to length of list");
			return null;
		}
		
		return nthTemp;
	}
	
	public boolean containsLoop(Node head) {
		
		Node slowPointer = head;
		Node fastPointer = head;
		
		if(head == null) {
			System.out.println("List is empty.");
			return false;
		}
		
		while(slowPointer != null && fastPointer != null) {
			
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
			
			if(fastPointer != null)
				fastPointer = fastPointer.getNext();	
			
			if(slowPointer == fastPointer && (slowPointer != null && fastPointer != null))
				return true;
		}
		return false;
	}
	
	public Node findStartNodeOfLoop(Node head) {
		
		Node slowPointer = head;
		Node fastPointer = head;
		
		if(head == null) {
			System.out.println("List is empty.");
			return null;
		}
		
		while(slowPointer != null && fastPointer != null) {
			
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
			
			if(fastPointer != null)
				fastPointer = fastPointer.getNext();	
			
			if(slowPointer == fastPointer && (slowPointer != null && fastPointer != null))
				break;
		}
		
		slowPointer = head;
		while(slowPointer != fastPointer) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
		}
		
		return slowPointer;
	}
	
    public int findLoopLength(Node head) {
		
		Node slowPointer = head;
		Node fastPointer = head;
		
		if(head == null) {
			System.out.println("List is empty.");
			return 0;
		}
		
		while(slowPointer != null && fastPointer != null) {
			
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
			
			if(fastPointer != null)
				fastPointer = fastPointer.getNext();	
			
			if(slowPointer == fastPointer && (slowPointer != null && fastPointer != null))
				break;
		}
		
		int count = 1;
		slowPointer = fastPointer.getNext();
		while(slowPointer != fastPointer) {
			slowPointer = slowPointer.getNext();
			count++;
		}
		
		return count;
	}

	public Node reverseList(Node head) {
		
		Node temp = head;
		Node newHead = null;
		Node temp2 = null;
		
		if(head == null) {
			System.out.println("List is empty.");
			return null;
		}
		
		while(temp != null) {
			temp2 = newHead;
			newHead = temp;
			temp = temp.getNext();
			newHead.setNext(temp2);
		}
		
		//head = newHead;
		return newHead;
	}
	
	public Node firstIntersectingNode(LinkedList list1, LinkedList list2) {
		
		if(list1.getHead() == null || list2.getHead() == null) {
			System.out.println("List is empty.");
			return null;
		}
		
		int length1 = list1.length();
		int length2 = list2.length();
		int diff = 0;
		
		Node temp1, temp2;
		temp1 = list1.getHead();
		temp2 = list2.getHead();
		
		if(length1 > length2) {
			diff = length1 - length2;
			while(diff > 0) {
				temp1 = temp1.getNext();
				diff--;
			}
		} else {
			diff = length2 - length1;
			while(diff > 0) {
				temp2 = temp2.getNext();
				diff--;
			}
		}
		
		while(temp1 != null && temp2 != null) {
			if(temp1 == temp2)
				return temp1;
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}
		return null;
	}
	
	public Node findMiddle(LinkedList list) {
		
		if(list.getHead() == null) {
			System.out.println("List is empty.");
			return null;
		}
		
		int length = list.length();
		int nodeNo = length / 2;
		Node temp = list.getHead();
		
		if(length % 2 != 0)
			nodeNo++;
		
		while(nodeNo != 1) {
			temp = temp.getNext();
			nodeNo--;
		}
		return temp;
	}
	
	public DLLNode findMiddleDLL(DLLNode<Integer> head) {
		
		if(head == null) {
			System.out.println("List is empty.");
			return null;
		}
		
		DLLNode temp = head;
		int length = 0;
		
		while(head.getNext() != null) {
			head = head.getNext();
			length++;
		}
		
		int nodeNo = length / 2;
		
		if(length % 2 != 0)
			nodeNo++;
		
		while(nodeNo != 0) {
			temp = temp.getNext();
			nodeNo--;
		}
		return temp;
	}
	
	public Node findMiddleInOneScan(LinkedList list) {
		
		Node head = list.getHead();
		Node pointer1, pointer2;
		pointer1 = pointer2 = head; 
		
		if(head == null) {
			System.out.println("List is empty.");
			return null;
		}
		
		int i = 0;
		while(pointer1.getNext() != null) {
			
			if(i == 0) {
				pointer1 = pointer1.getNext();
				i = 1;
			} else if(i == 1) {
				pointer1 = pointer1.getNext();
				pointer2 = pointer2.getNext();
				i = 0;
			}
		}
		return pointer2;
	}
	
	public Node findMiddleInOneScanWithOnePointerOnly(LinkedList list) {
		
		Node head = list.getHead();
		Node mid = head;
		
		if(head == null) {
			System.out.println("List is empty.");
			return null;
		}
		
		int counter = 0;
		while(head.getNext() != null) {
			
			//check if counter is odd or not by ANDing with 1
			//we can use reminder operator(%) as well
			if((counter & 1) == 1) {
				mid = mid.getNext();
			}
			counter++;
			head = head.getNext();
		}
		return mid;
	}

	public void printInReverse(Node head) {
		if(head == null)
			return;
		printInReverse(head.getNext());
		System.out.print(head.getData() + "-> ");
	}
	
	public LinkedList mergeLists(LinkedList<Integer> a, LinkedList<Integer> b) {
		
		Node<Integer> headA = a.getHead();
		Node<Integer> headB = b.getHead();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		while(headA != null && headB != null) {
			
			if(headA.getData() <= headB.getData()) {
				result.insertAtEnd(headA.getData());
				headA = headA.getNext();
			} else {
				result.insertAtEnd(headB.getData());
				headB = headB.getNext();	
			}
			
		}
		
		if(headA == null) {
			while(headB != null) {
				result.insertAtEnd(headB.getData());
				headB = headB.getNext();
			}
		}
		
		if(headB == null) {
			while(headA != null) {
				result.insertAtEnd(headA.getData());
				headA = headA.getNext();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {

		/*CircularLinkedList<Integer> cList = new CircularLinkedList<Integer>();
		cList.insertAtPosition(10, 1);
		cList.insertAtPosition(20, 2);
		cList.insertAtPosition(30, 3);
		cList.insertAtPosition(40, 4);
		cList.insertAtPosition(50, 5);
		cList.insertAtPosition(60, 6);*/
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtPosition(100, 1);
		list.insertAtPosition(200, 2);
		list.insertAtPosition(300, 3);
		list.insertAtPosition(400, 4);
		list.insertAtPosition(500, 5);
		list.insertAtPosition(600, 6);
		list.insertAtPosition(700, 7);
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.insertAtPosition(2, 1);
		list1.insertAtPosition(4, 2);
		list1.insertAtPosition(6, 3);
		//list1.getLast().setNext(list.getHead());
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.insertAtPosition(1, 1);
		list2.insertAtPosition(3, 2);
		//list2.getLast().setNext(list.getHead());
		//list.getLast().setNext(cList.getHead());
		LinkedListUtility util = new LinkedListUtility();
		/*Node node = util.nthNodeFromLast(list.getHead(), 1);
		
		if(node != null) 
		System.out.println(" --> " + node.getData());*/
		
		/*if(util.containsLoop(list.getHead())) {
			System.out.println("Start Node is  " + util.findStartNodeOfLoop(list.getHead()).getData());	
		}*/
		
		/*if(util.containsLoop(list.getHead())) {
			System.out.println("Loop length is  " + util.findLoopLength(list.getHead()));	
		}*/
		
		/*Node head = util.reverseList(list.getHead());
		list.setHead(head);
		list.print();*/
		
		/*Node node = util.firstIntersectingNode(list1, list2);
		if(node != null)
		System.out.println(" Intersection -> " + node.getData());*/
		
		/*Node node = util.findMiddleInOneScan(list);
		if(node != null)
		System.out.println("Node is " + node.getData());*/
		
		/*util.printInReverse(list.getHead());*/
		
		/*LinkedList list3 = util.mergeLists(list1, list2);
		if(list3 != null)
			list3.print();*/
		
		Node node = util.findMiddleInOneScanWithOnePointerOnly(list);
		System.out.println("Middle element is :" + node.getData());
	}

}
