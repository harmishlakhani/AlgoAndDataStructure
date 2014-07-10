package com.ds.tree;

import com.ds.linkedlist.DLLNode;
import com.ds.linkedlist.Node;
import com.ds.linkedlist.LinkedListUtility;

public class BinarySearchTreeUtility {

	public BSTNode<Integer> find(BSTNode<Integer> root, Integer data) {
		
		if(root == null)
			return null;
		
		while(root != null) {
			if(data < root.getData()) {
				root = root.getLeft();
			} else if(data > root.getData()) {
				root = root.getRight();
			} else if(data == root.getData()) {
				return root;
			}
		}
		
		return null;
	}
	
	public BSTNode<Integer> findRecursive(BSTNode<Integer> root, Integer data) {
		
		if(root == null)
			return null;
		
		if(data < root.getData()) {
			return findRecursive(root.getLeft(), data);
		} else if(data > root.getData()) {
			return findRecursive(root.getRight(), data);
		} 

		return root;
	}
	
	public BSTNode<Integer> findMinRecursive(BSTNode<Integer> root) {
		
		if(root == null)
			return null;
		
		if(root.getLeft() != null) 
			return findMinRecursive(root.getLeft());
		
		return root;
	}
	
	public BSTNode<Integer> findMin(BSTNode<Integer> root) {
		
		if(root == null)
			return null;
		
		while(root.getLeft() != null) 
			root = root.getLeft();
		
		return root;
	}

	public BSTNode<Integer> findMaxRecursive(BSTNode<Integer> root) {
		
		if(root == null)
			return null;
		
		if(root.getRight() != null) 
			return findMaxRecursive(root.getRight());
		
		return root;
	}
	
	public BSTNode<Integer> findMax(BSTNode<Integer> root) {
		
		if(root == null)
			return null;
		
		while(root.getRight() != null) 
			root = root.getRight();
		
		return root;
	}

	public BSTNode<Integer> lca(BSTNode<Integer> root, int a, int b) {
		
		if(root == null)
			return null;
		
		if((a <= root.getData() && root.getData() <= b) || (b <= root.getData() && root.getData() <= a) )
			return root;
		else if(a < root.getData() && b < root.getData())
			return lca(root.getLeft(), a, b);
		else if(a > root.getData() && b > root.getData())
			return lca(root.getRight(), a, b);
		
		return null;
	}
	
	public DLLNode<Integer> convertBSTToDLL(BSTNode<Integer> root) {
		
		DLLNode<Integer> head = convertBSTToDLLUtil(root);
		
		while(head.getPrev() != null) {
			head = head.getPrev();
		}
		
		return head;
	}
	
	//It will return root node as a node of DLL so we need to go to first element for head.
	DLLNode<Integer> prev = null;
	public DLLNode<Integer> convertBSTToDLLUtil(BSTNode<Integer> root) {
		
		if(root == null)
			return null;
		
		convertBSTToDLLUtil(root.getLeft());
		
		DLLNode<Integer> temp = new DLLNode<Integer>();
		temp.setData(root.getData());
		
		temp.setPrev(prev);
		if(prev != null) prev.setNext(temp);
		prev = temp;
		
		convertBSTToDLLUtil(root.getRight());
		
		return temp;
	}
	
	//It will return root node as a node of DLL so we need to go to first element for head.
	//This is in-place implementation which change left/right to prev/next
	public BSTNode<Integer> convertBSTToDLLUtilInPlace(BSTNode<Integer> root) {
		
		if(root == null)
			return null;
		
		if(root.getLeft() != null) {
			BSTNode<Integer> left = convertBSTToDLLUtilInPlace(root.getLeft());
			
			for(;left.getRight() != null; left = left.getRight());
			left.setRight(root);
			root.setLeft(left);
		}
		
		if(root.getRight() != null) {
			BSTNode<Integer> right = convertBSTToDLLUtilInPlace(root.getRight());
			
			for(;right.getLeft() != null; right = right.getLeft());
			right.setLeft(root);
			root.setRight(right);
		}
		return root;
	}

	public BSTNode<Integer> convertSortedDLLTOBST(DLLNode<Integer> head) {
		
		DLLNode<Integer> middle = null, p = null, q = null;
		
		if(head == null)
			return null;
		
		BSTNode<Integer> node= new BSTNode<Integer>();
		
		middle = new LinkedListUtility().findMiddleDLL(head);
		node.setData(middle.getData());
		
		if(head.getNext() == null)
			return node;
		
		q = middle.getNext();
		p = middle.getPrev();
		if(q != null) q.setPrev(null);
		if(p != null) p.setNext(null);
		
		middle.setNext(null);
		middle.setPrev(null);
		
		node.setLeft(convertSortedDLLTOBST(head));
		node.setRight(convertSortedDLLTOBST(q));
		
		return node;
	}
	
	public BSTNode<Integer> convertSortedArrayTOBST(int[] array, int start, int end) {
		
		if(start > end)
			return null;
		
		BSTNode<Integer> node= new BSTNode<Integer>();
		
		int middle = start + ((end - start)/2);
		node.setData(array[middle]);
		
		node.setLeft(convertSortedArrayTOBST(array, start, middle - 1));
		node.setRight(convertSortedArrayTOBST(array, middle + 1, end));
		
		return node;
	}
	
	//use bottom-up approach in O(n) time
	//scan the list only once
	Node<Integer> head = null;
	public BSTNode<Integer> convertLinkedListTOBST(int start, int end) {
		
		if(start > end)
			return null;
		
		int middle = start + ((end - start)/2);
		BSTNode<Integer> leftChild = convertLinkedListTOBST(start, middle - 1);
		
		BSTNode<Integer> parent = new BSTNode<Integer>();
		
		parent.setData(head.getData());
		parent.setLeft(leftChild);
		head = head.getNext();
		
		parent.setRight(convertLinkedListTOBST(middle + 1, end));
		
		return parent;
	}
	
	int count = 0;
	public BSTNode<Integer> kthSmallestElement(BSTNode<Integer> root, int k) {
		
		if(root == null)
			return null;
		
		BSTNode<Integer> left = kthSmallestElement(root.getLeft(), k);
		if(left != null) return left;
		
		count++;
		if(k == count)
			return root;
		
		return kthSmallestElement(root.getRight(), k);
	}

	//O(n)
	BSTNode<Integer> prevFloor;
	public BSTNode<Integer> floor(BSTNode<Integer> root, int key) {
		
		if(root == null)
			return null;
		
		BSTNode<Integer> left = floor(root.getLeft(), key);
		if(left != null) return left;
		
		if(key == root.getData())
			return root;
		
		if(key < root.getData())
			return prevFloor;
		
		prevFloor = root;
		return floor(root.getRight(), key);
	}

	//O(n)
	BSTNode<Integer> prevCeil;
	public BSTNode<Integer> ceil(BSTNode<Integer> root, int key) {
	
		if(root == null)
			return null;
		
		BSTNode<Integer> left = ceil(root.getRight(), key);
		if(left != null) return left;
		
		if(key == root.getData())
			return root;
		
		if(key > root.getData())
			return prevCeil;
		
		prevCeil = root;
		return ceil(root.getLeft(), key);
	}
	
	//O(logn)
	public BSTNode<Integer> floorEfficient(BSTNode<Integer> root, int key) {
		
		if(root == null)
			return null;
		
		if(key == root.getData())
			return root;
		
		if(key < root.getData())
			return floorEfficient(root.getLeft(), key);
		
		if(key > root.getData()) {
			BSTNode<Integer> temp = floorEfficient(root.getRight(), key);
			if(temp == null) return root;
			else return temp;
		}
		
		return null;
	}

	//O(logn)
	public BSTNode<Integer> ceilEfficient(BSTNode<Integer> root, int key) {
	
		if(root == null)
			return null;
		
		if(key == root.getData())
			return root;
		
		if(key > root.getData())
			return ceilEfficient(root.getRight(), key);
		
		if(key < root.getData()) {
			BSTNode<Integer> temp = ceilEfficient(root.getLeft(), key);
			if(temp == null) return root;
			else return temp;
		}
		
		return null;
	}
	
	public void rangePrinter(BSTNode<Integer> root, int a, int b) {
		
		if(root == null)
			return;
		
		if(a <= root.getData())
			rangePrinter(root.getLeft(), a, b);
		
		if( a <= root.getData() && root.getData() <= b)
			System.out.print(root.getData() + " ");
		
		if(b >= root.getData())
			rangePrinter(root.getRight(), a, b);
	}
	
	public void rangePrinterUsingLevelOrder(BSTNode<Integer> root, int a, int b) {
		
		if(root == null) {
			return;
		}
		
		Queue<BSTNode<Integer>> q = new Queue<BSTNode<Integer>>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			
			BSTNode<Integer> temp = q.dequeue();
			
			if(a <= temp.getData() && temp.getData() <= b)
				System.out.print(temp.getData() + " ");
			
			if(null != temp.getLeft() && temp.getLeft().getData() >= a) {
				q.enqueue(temp.getLeft());
			} 
			
			if(null != temp.getRight() && temp.getRight().getData() <= b) {
				q.enqueue(temp.getRight());
			} 
		}
	}
}