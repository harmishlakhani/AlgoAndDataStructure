package com.ds.tree;

public class BTNode<E> {

	private E data;
	private BTNode<E> left;
	private BTNode<E> right;
	private boolean visited;
	
	
	public BTNode() {
		
	}
	
	public BTNode(E data, BTNode<E> left, BTNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}
	/**
	 * @return the left
	 */
	public BTNode<E> getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BTNode<E> left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BTNode<E> getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BTNode<E> right) {
		this.right = right;
	}

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
