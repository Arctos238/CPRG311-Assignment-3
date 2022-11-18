package utilities;

public class BSTreeNode<E> {
	private BSTreeNode<E> left;
	private BSTreeNode<E> right;
	private E element;
	
	public BSTreeNode(E element) {
		this.element = element;
		left = null;
		right = null;
	}
	
	public BSTreeNode<E> getLeft() {
		return left;
	}
	
	public BSTreeNode<E> getRight() {
		return right;
	}
	
	
	public E getElement() {
		return element;
	}

	public int findDepth() {
		return ((findDepth(left) > findDepth(right)) ? findDepth(left) : findDepth(right)) + 1;
	}
	
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}
	
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}

	public void setElement(E element) {
		this.element = element;
	}
	
	public boolean isLeaf() {
		return (left == null && right == null);
	}
	
	public boolean hasRight() {
		return right != null;
	}
	
	public boolean hasLeft() {
		return left != null;
	}
	
	/**
	 * Recursive Method to find the depth
	 * @param childNode
	 * @return
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
