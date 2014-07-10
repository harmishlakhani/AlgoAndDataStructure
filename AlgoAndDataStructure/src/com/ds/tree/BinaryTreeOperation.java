package com.ds.tree;

public class BinaryTreeOperation<E> {

	BTNode<E> root;
	BTNode<Integer> rootForDelete;
	
	public void insertIntoBinaryTree(E data) {
		
		BTNode<E> node = new BTNode<E>();
		node.setData(data);
		
		if(root == null) {
			root =  node;
			return;
		}
		
		Queue<BTNode<E>> q = new Queue<BTNode<E>>();
		q.enqueue(root);
		
		while(!q.isEmpty()) {
			
			BTNode<E> temp = q.dequeue();
			
			if(null != temp.getLeft()) {
				q.enqueue(temp.getLeft());
			} else {
				temp.setLeft(node);
				break;
			}
			
			if(null != temp.getRight()) {
				q.enqueue(temp.getRight());
			} else {
				temp.setRight(node);
				break;
			}
		}
		
	}
	
	public void deleteFromBinaryTree(Integer data) {
		
		BinaryTreeUtility utility = new BinaryTreeUtility();
		BTNode<Integer> node = utility.find(rootForDelete, data);
		BTNode<Integer> deepestNode = utility.deepestNodeInBinaryTree(rootForDelete);
		
		int temp = node.getData();
		node.setData(deepestNode.getData());
		deepestNode.setData(temp);
		
		Queue<BTNode<Integer>> q = new Queue<BTNode<Integer>>();
		q.enqueue(rootForDelete);
		
		while(!q.isEmpty()) {
			
			BTNode<Integer> temp2 = q.dequeue();
			if(temp2.getLeft().getData() == data) {
				temp2.setLeft(null);
				break;
			}
			
			if(temp2.getRight().getData() == data) {
				temp2.setRight(null);
				break;
			}
			
			if(null != temp2.getLeft()) {
				q.enqueue(temp2.getLeft());
			}
			
			if(null != temp2.getRight()) {
				q.enqueue(temp2.getRight());
			}
		}
		
	}

	public void deleteBinaryTree(BTNode<E> root) {
		
		if(root == null) 
			return;
		
		deleteBinaryTree(root.getLeft());
		deleteBinaryTree(root.getRight());
		
		root.setLeft(null);
		root.setRight(null);

	}
	
	public static void main(String[] args) {

		BinaryTreeOperation<Integer> obj = new BinaryTreeOperation<Integer>();
		//BinaryTreeOperation<Integer> obj2 = new BinaryTreeOperation<Integer>();
		
		BinaryTreeTraversal<Integer> traversal = new BinaryTreeTraversal<Integer>();
		BinaryTreeUtility utility = new BinaryTreeUtility();
		
		/*for(int i = 1; i < 11; i++) {
			obj.insertIntoBinaryTree(i);
		}*/
		
		/*for(int i = 1; i < 11; i++) {
			obj2.insertIntoBinaryTree(i);
		}*/
		
		/*obj.root.getLeft().setLeft(new Node(4, null, null));
		obj.root.getLeft().setRight(new Node(5, null, null));
		
		obj.root.getLeft().getLeft().setLeft(new Node(4, null, null));
		obj.root.getLeft().getLeft().setRight(new Node(4, null, null));
		
		obj.root.getLeft().getRight().setRight(new Node(5, null, null));
		obj.root.getLeft().getRight().setLeft(new Node(5, null, null));*/
		/*obj.insertIntoBinaryTree(1);
		obj.insertIntoBinaryTree(-1);
		obj.insertIntoBinaryTree(56);
		obj.insertIntoBinaryTree(7);
		obj.insertIntoBinaryTree(7);*/
		
		//traversal.levelOrderTraversal(obj.root);
		//traversal.preorderRecursive(obj.root);
		//traversal.postorderRecursive(obj.root);
		//traversal.inorderRecursive(obj.root);
		//traversal.preorderNonRecursive(obj.root);
		//traversal.inorderNonRecursive(obj.root);
		//traversal.postorderNonRecursive(obj.root);
		//traversal.postorderNonRecursiveEasy(obj.root);
		//traversal.postorderNonRecursiveEasyUsingOneStack(obj.root);
		
		//System.out.println(utility.findMax(obj.root));
		//System.out.println(utility.findMaxIterative(obj.root));
		//System.out.println(utility.find(obj.root, 4).getData());
		//System.out.println(utility.findIterative(obj.root, 56));
		
		//System.out.println(utility.size(obj.root));
		//System.out.println(utility.sizeIterative(obj.root));
		
		//obj.deleteBinaryTree(obj.root);
		//traversal.levelOrderTraversal(obj.root);
		
		//traversal.reverseLevelOrderTraversal(obj.root);
		//System.out.println(utility.height(obj.root));
		//System.out.println(utility.heightIterative(obj.root));
		//System.out.println(utility.deepestNodeInBinaryTree(obj.root).getData());
		
		//obj.rootForDelete = obj.root;
		//obj.deleteFromBinaryTree(4);
		//traversal.levelOrderTraversal(obj.rootForDelete);
		
		//System.out.println(utility.findNoOfLeavesIterative(obj.root));
		//System.out.println(utility.findNoOfFullNodesIterative(obj.root));
		//System.out.println(utility.findNoOfHalfNodesIterative(obj.root));
		
		//System.out.println(utility.areStructurallyIdentical(obj.root, obj2.root));
		//System.out.println(utility.diameter(obj.root));
		//System.out.println(utility.findMaxSumLevel(obj.root));
		//utility.printRootToLeafPaths(obj.root, "");
		//System.out.println(utility.hasPathSum(obj.root,17));
		//System.out.println(utility.sum(obj.root));
		//traversal.inorderRecursive(obj.root);
		//traversal.inorderRecursive(utility.mirror(obj.root));
		//System.out.println(utility.areMirrors(obj.root, utility.mirror(obj2.root)));
		
		//Node<Integer> root = utility.constructBTreeFromInOrderAndPreOrder(new int[]{4,2,5,1,6,3}, new int[]{1,2,4,5,3,6}, 0, 5);
		//Node<Integer> root = utility.constructBTreeFromInOrderAndPreOrder(new int[]{4}, new int[]{4}, 0, 0);
		//traversal.inorderRecursive(root);
		//traversal.preorderRecursive(root);
		
		//Node<Integer> root = utility.constructBTreeFromInOrderAndPostOrder(new int[]{4,2,5,1,6,3}, new int[]{4,5,2,6,3,1}, 0, 5);
		//traversal.inorderRecursive(root);
		//traversal.postorderRecursive(root);
		//traversal.preorderRecursive(root);
		
		//utility.printAncestorsByDFS(obj.root, 9,"");
		//utility.printAncestorsRecursive(obj.root, 8);
		//System.out.println(utility.leastCommonAncestor(obj.root, 6,7).getData());
		//traversal.zigzagTraversal(obj.root);
		
		//traversal.inorderRecursive(utility.buildSpecialBTreeFromPreOrderRecursive(new int[]{0,0,1,1,0,1,1}, 0));
		//traversal.inorderRecursive(utility.buildSpecialBTreeFromPreOrderRecursive(new int[]{0,0,1,1}, 0));
		//traversal.morrisInorderTraversal(obj.root);
		//traversal.morrisPreorderTraversal(obj.root);
		
		obj.insertIntoBinaryTree(10);
		obj.insertIntoBinaryTree(5);
		obj.insertIntoBinaryTree(15);
		obj.insertIntoBinaryTree(1);
		obj.insertIntoBinaryTree(8);
		
		//System.out.println(utility.isBSTSimple(obj.root));
		//System.out.println(utility.isBST(obj.root));
		traversal.inorderRecursive(obj.root);
		System.out.println(utility.isBSTEfficient(obj.root));
	}
	
}