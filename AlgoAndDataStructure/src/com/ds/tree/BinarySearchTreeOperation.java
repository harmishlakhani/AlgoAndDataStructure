package com.ds.tree;

import com.ds.linkedlist.DLLNode;
import com.ds.linkedlist.LinkedListUtility;

public class BinarySearchTreeOperation {

	BSTNode<Integer> root;

	public void insertIntoBinarySearchTree(Integer data) {
		
		BSTNode<Integer> node = new BSTNode<Integer>();
		BSTNode<Integer> temp = null;
		BSTNode<Integer> temp2 = null;
		node.setData(data);
		
		if(root == null) {
			root = node;
			return;
		}
		
		temp = root;
		while(temp != null) {
			
			temp2 = temp;
			
			if(data < temp.getData()) {
				temp = temp.getLeft();
			} else if(data > temp.getData()) {
				temp = temp.getRight();
			} else {
				return;
			}
			
		}
		
		if(temp2.getData() > data)
			temp2.setLeft(node);
		else
			temp2.setRight(node);
		
	}
	
	public BSTNode<Integer> insertIntoBinarySearchTreeRecursive(BSTNode<Integer> root, Integer data) {
		
		if(root == null) {
			root = new BSTNode<Integer>();
			root.setData(data);
		}
		
		if(data < root.getData()) {
			root.setLeft(insertIntoBinarySearchTreeRecursive(root.getLeft(), data));
		} else if(data > root.getData()) {
			root.setRight(insertIntoBinarySearchTreeRecursive(root.getRight(), data));
		}

		return root;
			
	}
	
	public BSTNode<Integer> deleteFromBinarySearchTree(BSTNode<Integer> root, Integer data) {
		
		if(root == null) {
			System.out.println("Not Found for delete");
		} else if(data < root.getData()) {
			root.setLeft(deleteFromBinarySearchTree(root.getLeft(), data));
		} else if(data > root.getData()) {
			root.setRight(deleteFromBinarySearchTree(root.getRight(), data));
		} else {
			
			if(root.getLeft() != null && root.getRight() != null) {
				BSTNode<Integer> temp = new BinarySearchTreeUtility().findMax(root.getLeft());
				root.setData(temp.getData());
				root.setLeft(deleteFromBinarySearchTree(root.getLeft(), root.getData()));
			} else {
				if(root.getLeft() == null)
					return root.getRight();
				else if(root.getRight() == null)
					return root.getLeft();
				else
					return null;
			}
		}
		
		return root;
	}
	
	public static void main(String[] args) {

		BinarySearchTreeOperation obj = new BinarySearchTreeOperation();
		
		BinarySearchTreeTraversal<Integer> traversal = new BinarySearchTreeTraversal<Integer>();
		BinarySearchTreeUtility utility = new BinarySearchTreeUtility();
		
		/*obj.insertIntoBinarySearchTree(10);
		obj.insertIntoBinarySearchTree(15);
		obj.insertIntoBinarySearchTree(5);
		obj.insertIntoBinarySearchTree(6);
		obj.insertIntoBinarySearchTree(20);*/
		
		obj.root = obj.insertIntoBinarySearchTreeRecursive(obj.root, 10);
		obj.root = obj.insertIntoBinarySearchTreeRecursive(obj.root, 15);
		obj.root = obj.insertIntoBinarySearchTreeRecursive(obj.root, 12);
		obj.root = obj.insertIntoBinarySearchTreeRecursive(obj.root, 20);
		obj.root = obj.insertIntoBinarySearchTreeRecursive(obj.root, 5);
		obj.root = obj.insertIntoBinarySearchTreeRecursive(obj.root, 6);
		obj.root = obj.insertIntoBinarySearchTreeRecursive(obj.root, 1);
		
		//traversal.inorderRecursive(obj.root);
		//System.out.println(utility.find(obj.root, 200) != null ? utility.find(obj.root, 200).getData() : "Not Found");
		//System.out.println(utility.findRecursive(obj.root, 20).getData());
		
		//System.out.println(utility.findMin(obj.root).getData());
		//System.out.println(utility.findMinRecursive(obj.root).getData());
		//System.out.println(utility.findMax(obj.root).getData());
		//System.out.println(utility.findMaxRecursive(obj.root).getData());
		
		//obj.root = obj.deleteFromBinarySearchTree(obj.root, 10);
		//obj.root = obj.deleteFromBinarySearchTree(obj.root, 20);
		//traversal.inorderRecursive(obj.root);
		
		//System.out.println(utility.lca(obj.root, 5, 1).getData());
		
		/*DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.insertAtPosition(10, 1);
		list.insertAtPosition(20, 2);
		list.insertAtPosition(30, 3);
		list.insertAtPosition(40, 4);
		list.insertAtPosition(50, 5);
		list.insertAtPosition(60, 6);
		list.insertAtPosition(70, 7);
		list.print();*/
		
		//LinkedListUtility utility1 = new LinkedListUtility();
		//System.out.println(utility1.findMiddleDLL(list.getHead()).getData());
		
		//BSTNode<Integer> node = utility.convertSortedDLLTOBST(list.getHead());
		//traversal.inorderRecursive(node);
		//traversal.levelOrderTraversal(node);
		//traversal.preorderRecursive(node);
		
		//BSTNode<Integer> node = utility.convertSortedArrayTOBST(new int[]{1,2,3,4,5,6,7}, 0, 6);
		//traversal.inorderRecursive(node);
		//traversal.levelOrderTraversal(node);
		//traversal.preorderRecursive(node);
		
		/*LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtPosition(10, 1);
		list.insertAtPosition(20, 2);
		list.insertAtPosition(30, 3);
		list.insertAtPosition(40, 4);
		list.insertAtPosition(50, 5);
		list.insertAtPosition(60, 6);
		list.insertAtPosition(70, 7);
		list.print();
		
		utility.head = list.getHead();
		BSTNode<Integer> node = utility.convertLinkedListTOBST(0, list.length() - 1);*/
		//traversal.inorderRecursive(node);
		//traversal.levelOrderTraversal(node);
		//traversal.preorderRecursive(node);
		
		//System.out.println(utility.kthSmallestElement(obj.root, 6).getData());
		//System.out.println(utility.floor(obj.root, 1).getData());
		//System.out.println(utility.ceil(obj.root, 0).getData());
		//System.out.println(utility.floorEfficient(obj.root, 16).getData());
		//System.out.println(utility.ceilEfficient(obj.root, 16).getData());
		//utility.rangePrinter(obj.root, 0, 100);
		//utility.rangePrinterUsingLevelOrder(obj.root, 0, 100);
		
		/*DLLNode<Integer> head = utility.convertBSTToDLL(obj.root);
		
		while(head != null) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}*/
		
		BSTNode<Integer> head = utility.convertBSTToDLLUtilInPlace(obj.root);
		
		while(head.getLeft() != null) {
			head = head.getLeft();
		}
		
		while(head != null) {
			System.out.print(head.getData() + " ");
			head = head.getRight();
		}
		
		//traversal.verticalTraversal(obj.root);
	}
	
}