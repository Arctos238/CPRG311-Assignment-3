package utilities;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTreeNode.
 *
 * @param <E> the element type
 */
public class BSTreeNode<E> implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1887578978786360364L;
	
	/** The left. */
	private BSTreeNode<E> left;
	
	/** The right. */
	private BSTreeNode<E> right;
	
	/** The element. */
	private E element;
	
	/**
	 * Instantiates a new BS tree node.
	 *
	 * @param element the element
	 */
	public BSTreeNode(E element) {
		this.element = element;
		left = null;
		right = null;
	}
	
	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public BSTreeNode<E> getLeft() {
		return left;
	}
	
	/**
	 * Gets the right.
	 *
	 * @return the right
	 */
	public BSTreeNode<E> getRight() {
		return right;
	}
	
	
	/**
	 * Gets the element.
	 *
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Find depth.
	 *
	 * @return the int
	 */
	public int findDepth() {
		return ((findDepth(left) > findDepth(right)) ? findDepth(left) : findDepth(right)) + 1;
	}
	
	/**
	 * Sets the left.
	 *
	 * @param left the new left
	 */
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}
	
	/**
	 * Sets the right.
	 *
	 * @param right the new right
	 */
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}

	/**
	 * Sets the element.
	 *
	 * @param element the new element
	 */
	public void setElement(E element) {
		this.element = element;
	}
	
	/**
	 * Checks if is leaf.
	 *
	 * @return true, if is leaf
	 */
	public boolean isLeaf() {
		return (left == null && right == null);
	}
	
	/**
	 * Checks for right.
	 *
	 * @return true, if successful
	 */
	public boolean hasRight() {
		return right != null;
	}
	
	/**
	 * Checks for left.
	 *
	 * @return true, if successful
	 */
	public boolean hasLeft() {
		return left != null;
	}
	
	/**
	 * Recursive Method to find the depth.
	 *
	 * @param childNode the child node
	 * @return the int
	 */
	private int findDepth(BSTreeNode<E> childNode) {
		if(childNode == null) {
			return 0;
		} 
		
		int rightDepth = 0;
		int leftDepth = 0;
		
		if (childNode.getLeft() != null) {
			leftDepth = findDepth(childNode.getLeft());
		}
		
		if (childNode.getRight() != null) {
			rightDepth = findDepth(childNode.getRight());
		}

		return ((leftDepth > rightDepth) ? leftDepth : rightDepth) + 1;
		
	}
}
