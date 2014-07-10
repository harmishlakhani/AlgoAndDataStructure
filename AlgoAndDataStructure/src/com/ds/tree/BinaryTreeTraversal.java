package com.ds.tree;

public class BinaryTreeTraversal<E> {
	
	public void levelOrderTraversal(BTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.levelOrderTraversal:= root is null");
			return;
		}
		
		Queue<BTNode<E>> q = new Queue<BTNode<E>>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			
			BTNode<E> temp = q.dequeue();
			System.out.println(temp.getData());
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
			} 
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
			} 
		}
		
	}
	
	public void reverseLevelOrderTraversal(BTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.reverseLevelOrderTraversal:= root is null");
			return;
		}
		
		Queue<BTNode<E>> q = new Queue<BTNode<E>>();
		Stack<E> stack = new Stack<E>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			
			BTNode<E> node = q.dequeue();
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
	
	public void preorderRecursive(BTNode<E> root) { 
		if(root == null) {
			return;
		}
		System.out.println(root.getData());
		preorderRecursive(root.getLeft());
		preorderRecursive(root.getRight());
	}
	
	public void postorderRecursive(BTNode<E> root) { 
		if(root == null) {
			return;
		}
		postorderRecursive(root.getLeft());
		postorderRecursive(root.getRight());
		System.out.println(root.getData());
	} 
	
	public void inorderRecursive(BTNode<E> root) { 
		if(root == null) {
			return;
		}
		inorderRecursive(root.getLeft());
		System.out.println(root.getData());
		inorderRecursive(root.getRight());
	} 
	
	//From Karumunchi
	public void preorderNonRecursive(BTNode<E> root) {
	
		if(root == null) {
			System.out.println("BinaryTreeTraversal.preorderNonRecursive:= root is null");
			return;
		}
		
		Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
		
		while(true) {
		
			while(root != null) {
				System.out.println(root.getData());
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}

			BTNode<E> temp = stack.pop();
			root = temp.getRight();
				
		}
	}
		
	//From Geek for geek
	public void preorderNonRecursiveEasy(BTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.preorderNonRecursiveEasy:= root is null");
			return;
		}
		
		Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
		stack.push(root);
		
		while(!stack.isEmpty()) {

			BTNode<E> temp = stack.pop();
			System.out.println(temp.getData());
			if(null != temp.getRight())
				stack.push(temp.getRight());
			if(null != temp.getLeft())
				stack.push(temp.getLeft());
		}
	}
	
	public void inorderNonRecursive(BTNode<E> root) {
			
			if(root == null) {
				System.out.println("BinaryTreeTraversal.inorderNonRecursive:= root is null");
				return;
			}
			
			Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
			
			while(true) {
			
				while(root != null) {
					stack.push(root);
					root = root.getLeft();
				}
				
				if(stack.isEmpty()) {
					break;
				}

				BTNode<E> temp = stack.pop();
				System.out.println(temp.getData());
				root = temp.getRight();
					
			}
	}
	
	//From Geek for geek using 2 stacks
	//1. get reverse postorder using iterative
	//2. print it in reverse order to get postorder
	public void postorderNonRecursiveEasy(BTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.inorderNonRecursive:= root is null");
			return;
		}
		
		Stack<BTNode<E>> stackRevPostOrder = new Stack<BTNode<E>>();
		Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
		
		stackRevPostOrder.push(root);
		
		while(!stackRevPostOrder.isEmpty()) {

			BTNode<E> temp = stackRevPostOrder.pop();
			stack.push(temp);
			if(null != temp.getLeft())
				stackRevPostOrder.push(temp.getLeft());
			if(null != temp.getRight())
				stackRevPostOrder.push(temp.getRight());
			
		}
		
		while(!stack.isEmpty()) {
			BTNode<E> temp = stack.pop();
			System.out.println(temp.getData());
		}
	}
	
	//From Karumunchi
	public void postorderNonRecursive(BTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.inorderNonRecursive:= root is null");
			return;
		}
		
		Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
		
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
	public void postorderNonRecursiveEasyUsingOneStack(BTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.inorderNonRecursive:= root is null");
			return;
		}
		
		Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
		
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


	public void zigzagTraversal(BTNode<E> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeTraversal.zigzagTraversal:= root is null");
			return;
		}
		
		Stack<BTNode<E>> tempStack = new Stack<BTNode<E>>();
		Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
		Stack<BTNode<E>> tempVar = null;
		boolean leftToRight = true;
		
		stack.push(root);
		
		while(!stack.isEmpty()) {

			BTNode<E> temp = stack.pop();
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
	public void morrisInorderTraversal(BTNode<E> root) {
		
		BTNode<E> current = root, pre = null;
		
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
	public void morrisPreorderTraversal(BTNode<E> root) {
			
		BTNode<E> current = root, pre = null;
		
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
		
	public static void main(String[] args) {
		BinaryTreeTraversal list = new BinaryTreeTraversal();
	}
	
}