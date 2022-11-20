package utilities;

import java.util.NoSuchElementException;
import java.util.Stack;

import exceptions.TreeException;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5028340490565720457L;
	private BSTreeNode<E> root;
	private int size;

	public BSTree() {
		size = 0;
		root = null;
	}

	public BSTree(E element) {
		add(element);
	}

	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		if (root == null) {
			throw new TreeException();
		}

		return this.root;
	}

	@Override
	public int getHeight() {
		if (root == null) {
			return 0;
		}

		return root.findDepth();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void clear() {
		this.root = null; 
		this.size = 0;

	}

	public boolean contains(E toFind) throws TreeException {
		if (size == 0) {
			throw new TreeException();
		}

		return contains(toFind, root);
	}

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

	public BSTreeNode<E> search(E toFind) throws TreeException {
		if (size == 0) {
			throw new TreeException();
		}

		return search(toFind, root);
	}

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

	@Override
	public Iterator<E> inorderIterator() {
		return new InorderIterator(this.root);
	}

	@Override
	public Iterator<E> preorderIterator() {
		return new PreorderIterator(this.root);
	}

	@Override
	public Iterator<E> postorderIterator() {
		return new PostorderIterator(this.root);
	}

	private class InorderIterator implements Iterator<E> {
		private Stack<BSTreeNode<E>> travelStack;

		InorderIterator(BSTreeNode<E> root) {
			travelStack = new Stack<BSTreeNode<E>>();

			addToStack(root);
		}

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

		@Override
		public boolean hasNext() {
			return !travelStack.isEmpty();
		}

		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return travelStack.pop().getElement();
		}

	}

	private class PreorderIterator implements Iterator<E> {
		private Stack<BSTreeNode<E>> travelStack;

		PreorderIterator(BSTreeNode<E> root) {
			travelStack = new Stack<BSTreeNode<E>>();

			addToStack(root);
		}

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

		@Override
		public boolean hasNext() {
			return !travelStack.isEmpty();
		}

		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return travelStack.pop().getElement();
		}

	}

	private class PostorderIterator implements Iterator<E> {
		private Stack<BSTreeNode<E>> travelStack;

		PostorderIterator(BSTreeNode<E> root) {

			travelStack = new Stack<BSTreeNode<E>>();

			addToStack(root);
		}

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

		@Override
		public boolean hasNext() {
			return !travelStack.isEmpty();
		}

		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return travelStack.pop().getElement();
		}
	}

	public static void main(String[] args) {
		BSTree<Integer> tree = new BSTree<Integer>();

		tree.add(8);
		tree.add(3);
		tree.add(10);
		tree.add(1);
		tree.add(6);
		tree.add(14);
		tree.add(4);
		tree.add(7);
		tree.add(13);

		Iterator<Integer> it = tree.postorderIterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
