package utilities;

import java.util.NoSuchElementException;

import exceptions.TreeException;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
	private BSTreeNode<E> root;
	private int size;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3390135895504184631L;

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

	public BSTreeNode<E> search(E toFind, BSTreeNode<E> currentNode) throws TreeException {
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
		return new InorderIterator();
	}

	@Override
	public Iterator<E> preorderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<E> postorderIterator() {
		return new PostorderIterator();
	}

	private class InorderIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {

			return false;
		}

		@Override
		public E next() throws NoSuchElementException {

			return null;
		}
		// TODO InorderIterator

	}

	private class PreorderIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {

			return false;
		}

		@Override
		public E next() throws NoSuchElementException {

			return null;
		}

	}

	private class PostorderIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {

			return false;
		}

		@Override
		public E next() throws NoSuchElementException {

			return null;
		}
	}

	public static void main(String[] args) {
	
	}
}
