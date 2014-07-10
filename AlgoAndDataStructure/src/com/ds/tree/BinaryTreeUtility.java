package com.ds.tree;

public class BinaryTreeUtility {

	//used to construct binary tree from inorder and preorder traversal 
	static int preIndex = 0;
	
	//used to construct binary tree from inorder and postorder traversal 
	static int postIndex = 5;
	
	public int findMax(BTNode<Integer> root) {
		
		if(root == null)
			return Integer.MIN_VALUE;
		
		int leftMax = findMax(root.getLeft());
		int rightMax = findMax(root.getRight());
		
		return Math.max(root.getData(), Math.max(rightMax, leftMax));
	}
	
	public int findMin(BTNode<Integer> root) {
		
		if(root == null)
			return Integer.MAX_VALUE;
		
		int leftMin = findMin(root.getLeft());
		int rightMin = findMin(root.getRight());
		
		return Math.min(root.getData(), Math.min(rightMin, leftMin));
	}
	
	public int findMaxIterative(BTNode<Integer> root) {
		
		int max = Integer.MIN_VALUE;
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.findMaxIterative:= root is null");
			return max;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			
			BTNode<Integer> temp = q.dequeue();
			
			if(temp.getData() > max) {
				max = temp.getData();
			}
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
			} 
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
			} 
		}
		
		return max;
	}

	public BTNode<Integer> find(BTNode<Integer> root, int x) {
		
		if(root == null) {
			return null;
		}
		
		if(root.getData() == x) {
			return root;
		}
		
		BTNode<Integer> left = find(root.getLeft(), x); 
		boolean flag = false;
		if(left != null && left.getData() == x)
			flag = true;
		
		return flag ? left : find(root.getRight(), x);
	}

	public boolean findIterative(BTNode<Integer> root, int x) {
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.findIterative:= root is null");
			return false;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			
			BTNode<Integer> temp = q.dequeue();
			
			if(temp.getData() == x) {
				return true;
			}
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
			} 
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
			} 
		}
		
		return false;
	}

	public int size(BTNode<Integer> root) {
		
		if(root == null)
			return 0;
		
		return size(root.getLeft()) + 1 + size(root.getRight());
		
	}
	
	public int sizeIterative(BTNode<Integer> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.sizeIterative:= root is null");
			return 0;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		int count = 0;
		
		while(!q.isEmpty()) {
			
			BTNode<Integer> temp = q.dequeue();
			count++;
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
			} 
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
			} 
		}
		
		return count;
		
	}
	
	public int height(BTNode<Integer> root) {
		
		if(root.getLeft() == null && root.getRight() == null)
			return 0;
		
		int left = root.getLeft() != null ? height(root.getLeft()) : 0;
		int right = root.getRight() != null ? height(root.getRight()) : 0;
		
		return Math.max(left, right) + 1;
		
	}
	
	public int heightIterative(BTNode<Integer> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.heightIterative:= root is null");
			return 0;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		q.enqueue(null);
		int count = -1;
		
		while(!q.isEmpty()) {
			
			BTNode<Integer> temp = q.dequeue();
			
			if(temp == null) {
				count++;
				if(!q.isEmpty())
					q.enqueue(null);
			} else {
			
				if(null != temp.getLeft()) {
					q.enqueue(temp.getLeft());
				} 
				
				if(null != temp.getRight()) {
					q.enqueue(temp.getRight());
				}
			}
		}
		
		return count;
	}
 		
	public BTNode<Integer> deepestNodeInBinaryTree(BTNode<Integer> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.deepestNodeInBinaryTree:= root is null");
			return null;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		BTNode<Integer> temp = null;
		
		while(!q.isEmpty()) {
			
			temp = q.dequeue();
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
			} 
				
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
			}
			
		}
		
		return temp;
	}
	
	public int findNoOfLeavesIterative(BTNode<Integer> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.findNoOfLeavesIterative:= root is null");
			return 0;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		int count = 0;
		boolean left = false;
		boolean right = false;
		
		while(!q.isEmpty()) {
			
			left = false;
			right = false;
					
			BTNode<Integer> temp = q.dequeue();
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
				left = true;
			} 
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
				right = true;
			}
			
			if(!left && !right) {
				count++;
			} 
		}
		
		return count;
	}

	public int findNoOfFullNodesIterative(BTNode<Integer> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.findNoOfFullNodesIterative:= root is null");
			return 0;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		int count = 0;
		boolean left = false;
		boolean right = false;
		
		while(!q.isEmpty()) {
			
			left = false;
			right = false;
					
			BTNode<Integer> temp = q.dequeue();
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
				left = true;
			} 
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
				right = true;
			}
			
			if(left && right) {
				count++;
			} 
		}
		
		return count;
	}

	public int findNoOfHalfNodesIterative(BTNode<Integer> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.findNoOfHalfNodesIterative:= root is null");
			return 0;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		int count = 0;
		boolean left = false;
		boolean right = false;
		
		while(!q.isEmpty()) {
			
			left = false;
			right = false;
					
			BTNode<Integer> temp = q.dequeue();
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
				left = true;
			} 
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
				right = true;
			}
			
			if(left ^ right) {
				count++;
			} 
		}
		
		return count;
	}
	
	public boolean areStructurallyIdentical(BTNode<Integer> root1, BTNode<Integer> root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if(root1 == null || root2 == null) {
			return false;
		}
		
		return (root1.getData() == root2.getData() && 
		   areStructurallyIdentical(root1.getLeft(), root2.getLeft()) &&
		   areStructurallyIdentical(root1.getRight(), root2.getRight()) );
	}
	
	public int diameter(BTNode<Integer> root) {
		
		if(root.getLeft() == null && root.getRight() == null)
			return 0;
		
		int leftHeight = root.getLeft() != null ? height(root.getLeft()) : 0;
		int rightHeight = root.getRight() != null ? height(root.getRight()) : 0;
		
		int leftDiameter = root.getLeft() != null ? diameter(root.getLeft()) : 0;
		int rightDiameter = root.getRight() != null ? diameter(root.getRight()) : 0;
		
		return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight + rightHeight + 3);
		
	}
	
	public int findMaxSumLevel(BTNode<Integer> root) {
		
		if(root == null) {
			System.out.println("BinaryTreeUtility.findMaxSumLevel:= root is null");
			return 0;
		}
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(root);
		q.enqueue(null);
		int maxSum = Integer.MIN_VALUE;
		int maxLevel = 0;
		int level = 0;
		int sum = 0;
		
		while(!q.isEmpty()) {
			
			BTNode<Integer> temp = q.dequeue();
			if(temp == null) {
				
				if(!q.isEmpty()) {
					q.enqueue(null);
				}
				level++;
				if(maxSum < sum) {
					maxSum = sum;
					maxLevel = level;
				}
				sum = 0;
			} else {
			
				sum += temp.getData(); 
				if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
				} 
			
				if(null != temp.getRight()) {
					q.enqueue(temp.getRight());
				}
			}
		}
		
		return maxLevel;
	}

	public void printRootToLeafPaths(BTNode<Integer> root, String path) {
		
		if(root.getLeft() == null && root.getRight() == null) {
			System.out.println(path + " -> " + root.getData());
			return;
		}
		
		String temp = path + " -> " + root.getData();
		
		printRootToLeafPaths(root.getLeft(), temp);
		printRootToLeafPaths(root.getRight(), temp);
	}
	
	public boolean hasPathSum(BTNode<Integer> root, int sum) {
		
		if(root == null) {
			return (sum == 0);
		}
		int temp = sum - root.getData();
		boolean flag = hasPathSum(root.getLeft(), temp);
		return flag ? true : hasPathSum(root.getRight(), temp);
	}
	
	public int sum(BTNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		return (root.getData() + sum(root.getLeft()) + sum(root.getRight()));
	}
	
	public BTNode<Integer> mirror(BTNode<Integer> root) {
		
		if(root == null) {
			return null;
		}
		
		mirror(root.getLeft());
		mirror(root.getRight());
		
		BTNode<Integer> temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		
		return root;
	}
	
	public boolean areMirrors(BTNode<Integer> root1, BTNode<Integer> root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if(root1 == null || root2 == null) {
			return false;
		}
		
		return (root1.getData() == root2.getData() && 
				areMirrors(root1.getLeft(), root2.getRight()) && 
				areMirrors(root1.getRight(), root2.getLeft()));
	}
	
	public BTNode<Integer> constructBTreeFromInOrderAndPreOrder(int[] in, int[] pre, int start, int end) {
		
		if(start > end)
			return null;
		
		BTNode<Integer> node = new BTNode<Integer>();
		
		int inIndex = search(in, start, end, pre[preIndex]);
		node.setData(pre[preIndex++]);
		
		if(start == end)
			return node;
		
		node.setLeft(constructBTreeFromInOrderAndPreOrder(in, pre, start, inIndex - 1));
		node.setRight(constructBTreeFromInOrderAndPreOrder(in, pre, inIndex + 1, end));
		
		return node;
	}
	
	public BTNode<Integer> constructBTreeFromInOrderAndPostOrder(int[] in, int[] post, int start, int end) {
		
		if(start > end)
			return null;
		
		BTNode<Integer> node = new BTNode<Integer>();
		
		int inIndex = search(in, start, end, post[postIndex]);
		node.setData(post[postIndex--]);
		
		if(start == end)
			return node;
		
		node.setRight(constructBTreeFromInOrderAndPostOrder(in, post, inIndex + 1, end));
		node.setLeft(constructBTreeFromInOrderAndPostOrder(in, post, start, inIndex - 1));
		
		return node;
	}

	private int search(int[] array, int start, int end, int key) {
		
		for(int i = start; i <= end; i++) {
			if(array[i] == key)
				return i;
		}
		
		return -1;
	}
	
	public void printAncestorsByDFS(BTNode<Integer> root, int key, String ancestors) {
		
		if(root == null)
			return;
		
		if(root.getData() == key) {
			System.out.println(ancestors + key);
			return;
		}
		
		String str = ancestors + root.getData();
		printAncestorsByDFS(root.getLeft(), key, str);
		printAncestorsByDFS(root.getRight(), key, str);
		
	}
	
	public boolean printAncestorsRecursive(BTNode<Integer> root, int key) {
		
		if(root == null)
			return false;
		
		if(root.getLeft().getData() == key || root.getRight().getData() == key
		   || printAncestorsRecursive(root.getLeft(), key) || printAncestorsRecursive(root.getRight(), key) ) {
			System.out.println(root.getData());
			return true;
		}
		
		return false;
		
	}
	
	public BTNode<Integer> leastCommonAncestor(BTNode<Integer> root, int key1, int key2) {
		
		if(root == null)
			return null;
		
		if(root.getData() == key1 || root.getData() == key2) {
			return root;
		}
		
		BTNode<Integer> leftLCA = leastCommonAncestor(root.getLeft(), key1, key2);
		BTNode<Integer> rightLCA = leastCommonAncestor(root.getRight(), key1, key2);
		
		if(leftLCA != null && rightLCA != null)
			return root;
		
		return leftLCA != null ? leftLCA : rightLCA;  
		
	}
	
	//from careercup
	public BTNode<Integer> buildSpecialBTreeFromPreOrder(int[] array) {
		
		if(array == null)
			return null;
		
		Stack<BTNode<Integer>> stack = new Stack<BTNode<Integer>>();
		
		for(int i = array.length - 1 ; i >= 0; i--) {
			
			BTNode<Integer> node = new BTNode<Integer>();
			node.setData(array[i]);
			
			if(array[i] == 1) {
				stack.push(node);
			} else {
				node.setLeft(stack.pop());
				node.setRight(stack.pop());
				stack.push(node);
			}
		}
		
		return stack.pop();
	}
	
	public BTNode<Integer> buildSpecialBTreeFromPreOrderRecursive(int[] array, int i) {
		
		if(array == null)
			return null;
		
		BTNode<Integer> node = new BTNode<Integer>();
		node.setData(array[i]);
		
		if(array[i] == 1)
			return node;
		
		i = i + 1;
		node.setLeft(buildSpecialBTreeFromPreOrderRecursive(array, i));
		
		i = i + 1;
		node.setRight(buildSpecialBTreeFromPreOrderRecursive(array, i));
		
		return node;
	}
	
	//Doesn't check the other node in tree, that's return incorrect value.
	//only compare with one level above the current level.
	public boolean isBSTSimple(BTNode<Integer> root) {
		
		if(root == null)
			return true;
		
		if(root.getLeft() != null && root.getLeft().getData() > root.getData()) {
			return false;
		}
		
		if(root.getRight() != null && root.getRight().getData() < root.getData()) {
			return false;
		}
		
		if( isBSTSimple(root.getLeft()) && isBSTSimple(root.getRight()) )
			return true;
		else 
			return false;
	}
	
	//using max and min in left and right subtree
	//so we scan all the levels of tree.
	public boolean isBST(BTNode<Integer> root) {
		
		if(root == null)
			return true;
		
		if(root.getLeft() != null && findMax(root.getLeft()) > root.getData()) {
			return false;
		}
		
		if(root.getRight() != null && findMin(root.getRight()) < root.getData()) {
			return false;
		}
		
		if( isBST(root.getLeft()) && isBST(root.getRight()) )
			return true;
		else 
			return false;
	}
	
	//Using inorder traversal
	//check the previous node and if it is greater than current then return false
	
	int prev = Integer.MIN_VALUE;
	
	public boolean isBSTEfficient(BTNode<Integer> root) {
		
		if(root == null)
			return true;
		
		if(!isBSTEfficient(root.getLeft()))
			return false;
		
		if(prev > root.getData())
			return false;
		
		prev = root.getData();
		
		return isBSTEfficient(root.getRight());
	}
}