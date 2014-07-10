package com.ds.tree;

import java.util.ArrayList;

public class BinarySearchTreeTraversal<E> {
	
	public void levelOrderTraversal(BSTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.levelOrderTraversal:= root is null");
			return;
		}
		
		Queue<BSTNode<E>> q = new Queue<BSTNode<E>>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			
			BSTNode<E> temp = q.dequeue();
			System.out.println(temp.getData());
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
			} 
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
			} 
		}
		
	}
	
	public void reverseLevelOrderTraversal(BSTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.reverseLevelOrderTraversal:= root is null");
			return;
		}
		
		Queue<BSTNode<E>> q = new Queue<BSTNode<E>>();
		Stack<E> stack = new Stack<E>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			
			BSTNode<E> node = q.dequeue();
			stack.push(node.getData());
			
			if(node.getRight() != null)
				q.enqueue(node.getRight());
			
			if(node.getLeft() != null)
				q.enqueue(node.getLeft());
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public void preorderRecursive(BSTNode<E> root) { 
		if(root == null) {
			return;
		}
		System.out.println(root.getData());
		preorderRecursive(root.getLeft());
		preorderRecursive(root.getRight());
	}
	
	public void postorderRecursive(BSTNode<E> root) { 
		if(root == null) {
			return;
		}
		postorderRecursive(root.getLeft());
		postorderRecursive(root.getRight());
		System.out.println(root.getData());
	} 
	
	public void inorderRecursive(BSTNode<E> root) { 
		if(root == null) {
			return;
		}
		inorderRecursive(root.getLeft());
		System.out.println(root.getData());
		inorderRecursive(root.getRight());
	} 
	
	//From Karumunchi
	public void preorderNonRecursive(BSTNode<E> root) {
	
		if(root == null) {
			System.out.println("BinaryTreeTraversal.preorderNonRecursive:= root is null");
			return;
		}
		
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		
		while(true) {
		
			while(root != null) {
				System.out.println(root.getData());
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}

			BSTNode<E> temp = stack.pop();
			root = temp.getRight();
				
		}
	}
		
	//From Geek for geek
	public void preorderNonRecursiveEasy(BSTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.preorderNonRecursiveEasy:= root is null");
			return;
		}
		
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		stack.push(root);
		
		while(!stack.isEmpty()) {

			BSTNode<E> temp = stack.pop();
			System.out.println(temp.getData());
			if(null != temp.getRight())
				stack.push(temp.getRight());
			if(null != temp.getLeft())
				stack.push(temp.getLeft());
		}
	}
	
	public void inorderNonRecursive(BSTNode<E> root) {
			
			if(root == null) {
				System.out.println("BinaryTreeTraversal.inorderNonRecursive:= root is null");
				return;
			}
			
			Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
			
			while(true) {
			
				while(root != null) {
					stack.push(root);
					root = root.getLeft();
				}
				
				if(stack.isEmpty()) {
					break;
				}

				BSTNode<E> temp = stack.pop();
				System.out.println(temp.getData());
				root = temp.getRight();
					
			}
	}
	
	//From Geek for geek using 2 stacks
	//1. get reverse postorder using iterative
	//2. print it in reverse order to get postorder
	public void postorderNonRecursiveEasy(BSTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.inorderNonRecursive:= root is null");
			return;
		}
		
		Stack<BSTNode<E>> stackRevPostOrder = new Stack<BSTNode<E>>();
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		
		stackRevPostOrder.push(root);
		
		while(!stackRevPostOrder.isEmpty()) {

			BSTNode<E> temp = stackRevPostOrder.pop();
			stack.push(temp);
			if(null != temp.getLeft())
				stackRevPostOrder.push(temp.getLeft());
			if(null != temp.getRight())
				stackRevPostOrder.push(temp.getRight());
			
		}
		
		while(!stack.isEmpty()) {
			BSTNode<E> temp = stack.pop();
			System.out.println(temp.getData());
		}
	}
	
	//From Karumunchi
	public void postorderNonRecursive(BSTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.inorderNonRecursive:= root is null");
			return;
		}
		
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		
		while(true) {
		
			if(root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			else {
			
				if(stack.isEmpty()) {
					break;
				}
				else {
				
					if(stack.peek().getRight() == null) {
						root = stack.pop();
						System.out.println(root.getData());
						if(root == stack.peek().getRight()) {
							System.out.println(stack.peek().getData());
							stack.pop();
						}
					}
					if(!stack.isEmpty())
						root = stack.peek().getRight();
					else root = null;
				}
			}
		}
	}	

	//From geek for geek
	public void postorderNonRecursiveEasyUsingOneStack(BSTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.inorderNonRecursive:= root is null");
			return;
		}
		
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		
		while(true) {
			
			while(root != null) {
				if(null != root.getRight())
					stack.push(root.getRight());
				stack.push(root);
				root = root.getLeft();
			}
			
			root = stack.pop();
			
			if(null != root.getRight() && !stack.isEmpty() && root.getRight() == stack.peek()) {
				stack.pop();
				stack.push(root);
				root = root.getRight();
			} else {
				System.out.println(root.getData());
				root = null;
			}
			
			if(stack.isEmpty())
				break;
		}
	}	


	public void zigzagTraversal(BSTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.zigzagTraversal:= root is null");
			return;
		}
		
		Stack<BSTNode<E>> tempStack = new Stack<BSTNode<E>>();
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		Stack<BSTNode<E>> tempVar = null;
		boolean leftToRight = true;
		
		stack.push(root);
		
		while(!stack.isEmpty()) {

			BSTNode<E> temp = stack.pop();
			System.out.println(temp.getData());
			
			if(leftToRight) {
				if(temp.getLeft() != null)
					tempStack.push(temp.getLeft());
				if(temp.getRight() != null)
					tempStack.push(temp.getRight());
			} else {
				if(temp.getRight() != null)
					tempStack.push(temp.getRight());
				if(temp.getLeft() != null)
					tempStack.push(temp.getLeft());
			}
				
			if(stack.isEmpty()) {
				tempVar = stack;
				stack = tempStack;
				tempStack = tempVar;
				leftToRight = !leftToRight;
			}
		}
		
	}
	
	//from geeks for geeks
	public void morrisInorderTraversal(BSTNode<E> root) {
		
		BSTNode<E> current = root, pre = null;
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.morrisInorderTraversal:= root is null");
			return;
		}
		
		while(current != null) {
			
			if(current.getLeft() == null ||  current.isVisited()) {
				System.out.println(current.getData());
				current = current.getRight();
			} else {
				
				pre = current.getLeft();
				//pre.setVisited(true);
				
				while(pre.getRight() != null) {
					pre = pre.getRight();
					//pre.setVisited(true);
				}
				
				if(pre.getRight() == null) {
					pre.setRight(current);
					current.setVisited(true);
					current = current.getLeft();
				} else {
					pre.setRight(null);
					System.out.println(current.getData());
					current = current.getRight();
				}
			}
		}
	}
	
	//from geeks for geeks
	public void morrisPreorderTraversal(BSTNode<E> root) {
			
		BSTNode<E> current = root, pre = null;
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.morrisPreorderTraversal:= root is null");
			return;
		}
		
		while(current != null) {
			
			if(current.getLeft() == null || current.isVisited()) {
				if(!current.isVisited())
					System.out.println(current.getData());
				current = current.getRight();
			} else {
				
				pre = current.getLeft();
				
				while(pre.getRight() != null) {
					pre = pre.getRight();
				}
				
				if(pre.getRight() == null) {
					pre.setRight(current);
					System.out.println(current.getData());
					current.setVisited(true);
					current = current.getLeft();
				}
			}
		}
	}
		
	public void verticalTraversal(BSTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.verticalTraversal:= root is null");
			return;
		}
		
		BSTNode<E> current = root;
		int left = 0, right = 0;
		
		while(current.getLeft() != null) {
			current = current.getLeft();
			left++;
		}
		
		current = root;
		while(current.getRight() != null) {
			current = current.getRight();
			right++;
		}
		
		int size = left + right + 1;
		ArrayList<Integer>[] array = (ArrayList<Integer>[]) new ArrayList[size];
		
		for(int i = 0; i < size; i++)
			array[i] = new ArrayList<Integer>();
		
		verticalTraversalUtil(root, array, left);
		
		for(int i = 0; i < size; i++) {
			ArrayList<Integer> list = array[i];
			
			for(int a : list)
				System.out.print(a + " ");
			
			System.out.println();
		}
	}
	
	private void verticalTraversalUtil(BSTNode<E> root, Object[] array, int count) {
		
		if(root == null)
			return;
		
		verticalTraversalUtil(root.getLeft(), array, count - 1);
		
		((ArrayList<Integer>) array[count]).add((Integer) root.getData());
		
		verticalTraversalUtil(root.getRight(), array, count + 1);
	}
	
	public static void main(String[] args) {
		BinarySearchTreeTraversal list = new BinarySearchTreeTraversal();
	}
	
}