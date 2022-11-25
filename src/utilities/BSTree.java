package utilities;

import java.util.NoSuchElementException;
import java.util.Stack;

import exceptions.TreeException;
import problemdomain.Word;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTree.
 *
 * @param <E> the element type
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5028340490565720457L;
	
	/** The root. */
	private BSTreeNode<E> root;
	
	/** The size. */
	private int size;

	/**
	 * Instantiates a new BS tree.
	 */
	public BSTree() {
		size = 0;
		root = null;
	}

	/**
	 * Instantiates a new BS tree.
	 *
	 * @param element the element
	 */
	public BSTree(E element) {
		add(element);
	}

	/**
	 * Instantiates a new BS tree.
	 *
	 * @param root the root
	 */
	public BSTree(BSTreeNode<E> root) {
		size = 1;
		this.root = root;
	}

	/**
	 * Gets the root.
	 *
	 * @return the root
	 * @throws TreeException the tree exception
	 */
	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		if (root == null) {
			throw new TreeException();
		}

		return this.root;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	@Override
	public int getHeight() {
		if (root == null) {
			return 0;
		}

		return root.findDepth();
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Clear.
	 */
	@Override
	public void clear() {
		this.root = null;
		this.size = 0;

	}

	/**
	 * Contains.
	 *
	 * @param toFind the to find
	 * @return true, if successful
	 * @throws TreeException the tree exception
	 */
	public boolean contains(E toFind) throws TreeException {
		if (size == 0) {
			throw new TreeException();
		}

		return contains(toFind, root);
	}

	/**
	 * Contains.
	 *
	 * @param toFind the to find
	 * @param currentNode the current node
	 * @return true, if successful
	 */
	private boolean contains(E toFind, BSTreeNode<E> currentNode) {
		if (currentNode == null) {
			return false;
		}

		int elementCompareValue = currentNode.getElement().compareTo(toFind);

		if (elementCompareValue == 0) {
			return true;
		}

		if (elementCompareValue < 0) {
			return contains(toFind, currentNode.getRight());
		} else {
			return contains(toFind, currentNode.getLeft());
		}

	}

	/**
	 * Search.
	 *
	 * @param toFind the to find
	 * @return the BS tree node
	 * @throws TreeException the tree exception
	 */
	public BSTreeNode<E> search(E toFind) throws TreeException {
		if (size == 0) {
			throw new TreeException();
		}

		return search(toFind, root);
	}

	/**
	 * Search.
	 *
	 * @param toFind the to find
	 * @param currentNode the current node
	 * @return the BS tree node
	 * @throws TreeException the tree exception
	 */
	private BSTreeNode<E> search(E toFind, BSTreeNode<E> currentNode) throws TreeException {
		if (currentNode == null) {
			return null;
		}

		int elementCompareValue = currentNode.getElement().compareTo(toFind);

		if (elementCompareValue == 0) {
			return currentNode;
		}

		if (elementCompareValue < 0) {
			return search(toFind, currentNode.getRight());
		} else {
			return search(toFind, currentNode.getLeft());
		}

	}

	/**
	 * Adds the.
	 *
	 * @param newEntry the new entry
	 * @return true, if successful
	 * @throws NullPointerException the null pointer exception
	 */
	public boolean add(E newEntry) throws NullPointerException {
		if (newEntry == null) {
			throw new NullPointerException();
		} else if (size > 0 && contains(newEntry, root)) {
			return false;
		}

		root = add(root, newEntry);
		size++;

		return true;
	}

	/**
	 * Adds the.
	 *
	 * @param current the current
	 * @param value the value
	 * @return the BS tree node
	 */
	private BSTreeNode<E> add(BSTreeNode<E> current, E value) {
		if (current == null) {
			return new BSTreeNode<E>(value);
		}

		if (value.compareTo(current.getElement()) < 0) {
			current.setLeft(add(current.getLeft(), value));
		} else if (value.compareTo(current.getElement()) > 0) {
			current.setRight(add(current.getRight(), value));
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	/**
	 * Inorder iterator.
	 *
	 * @return the iterator
	 */
	@Override
	public Iterator<E> inorderIterator() {
		return new InorderIterator(this.root);
	}

	/**
	 * Preorder iterator.
	 *
	 * @return the iterator
	 */
	@Override
	public Iterator<E> preorderIterator() {
		return new PreorderIterator(this.root);
	}

	/**
	 * Postorder iterator.
	 *
	 * @return the iterator
	 */
	@Override
	public Iterator<E> postorderIterator() {
		return new PostorderIterator(this.root);
	}

	/**
	 * The Class InorderIterator.
	 */
	private class InorderIterator implements Iterator<E> {
		
		/** The travel stack. */
		private Stack<BSTreeNode<E>> travelStack;

		/**
		 * Instantiates a new inorder iterator.
		 *
		 * @param root the root
		 */
		InorderIterator(BSTreeNode<E> root) {
			travelStack = new Stack<BSTreeNode<E>>();

			addToStack(root);
		}

		/**
		 * Adds the to stack.
		 *
		 * @param node the node
		 */
		private void addToStack(BSTreeNode<E> node) {
			if (node != null) {
				if (node.getRight() != null) {
					addToStack(node.getRight());
				}

				travelStack.add(node);

				if (node.getLeft() != null) {
					addToStack(node.getLeft());
				}
			}
		}

		/**
		 * Checks for next.
		 *
		 * @return true, if successful
		 */
		@Override
		public boolean hasNext() {
			return !travelStack.isEmpty();
		}

		/**
		 * Next.
		 *
		 * @return the e
		 * @throws NoSuchElementException the no such element exception
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return travelStack.pop().getElement();
		}

	}

	/**
	 * The Class PreorderIterator.
	 */
	private class PreorderIterator implements Iterator<E> {
		
		/** The travel stack. */
		private Stack<BSTreeNode<E>> travelStack;

		/**
		 * Instantiates a new preorder iterator.
		 *
		 * @param root the root
		 */
		PreorderIterator(BSTreeNode<E> root) {
			travelStack = new Stack<BSTreeNode<E>>();

			addToStack(root);
		}

		/**
		 * Adds the to stack.
		 *
		 * @param node the node
		 */
		private void addToStack(BSTreeNode<E> node) {
			if (node != null) {
				if (node.hasRight()) {
					addToStack(node.getRight());
				}

				if (node.hasLeft()) {
					addToStack(node.getLeft());
				}

				travelStack.add(node);

			}
		}

		/**
		 * Checks for next.
		 *
		 * @return true, if successful
		 */
		@Override
		public boolean hasNext() {
			return !travelStack.isEmpty();
		}

		/**
		 * Next.
		 *
		 * @return the e
		 * @throws NoSuchElementException the no such element exception
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return travelStack.pop().getElement();
		}

	}

	/**
	 * The Class PostorderIterator.
	 */
	private class PostorderIterator implements Iterator<E> {
		
		/** The travel stack. */
		private Stack<BSTreeNode<E>> travelStack;

		/**
		 * Instantiates a new postorder iterator.
		 *
		 * @param root the root
		 */
		PostorderIterator(BSTreeNode<E> root) {

			travelStack = new Stack<BSTreeNode<E>>();

			addToStack(root);
		}

		/**
		 * Adds the to stack.
		 *
		 * @param node the node
		 */
		private void addToStack(BSTreeNode<E> node) {
			if (node != null) {
				travelStack.add(node);

				if (node.getRight() != null) {
					addToStack(node.getRight());
				}

				if (node.getLeft() != null) {
					addToStack(node.getLeft());
				}
			}
		}

		/**
		 * Checks for next.
		 *
		 * @return true, if successful
		 */
		@Override
		public boolean hasNext() {
			return !travelStack.isEmpty();
		}

		/**
		 * Next.
		 *
		 * @return the e
		 * @throws NoSuchElementException the no such element exception
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return travelStack.pop().getElement();
		}
	}

}
