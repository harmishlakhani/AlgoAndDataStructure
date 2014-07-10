package com.ds.tree;

public class BSTNode<E> {

	private E data;
	private BSTNode<E> left;
	private BSTNode<E> right;
	private boolean visited;
	
	public BSTNode() {
	}
	
	public BSTNode(E data, BSTNode<E> left, BSTNode<E> right) {
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
	public BSTNode<E> getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BSTNode<E> getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BSTNode<E> right) {
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
