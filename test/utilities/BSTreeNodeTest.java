/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTreeNodeTest.
 *
 * @author Arcto
 */
class BSTreeNodeTest {
	
	/** The node. */
	private BSTreeNode<String> node;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		node = new BSTreeNode<String>("A");
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		node = null;
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#BSTreeNode(java.lang.Object)}.
	 */
	@Test
	void testBSTreeNode() {
		node = new BSTreeNode<String>("A");
		assertTrue(node != null);
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#getLeft()}.
	 */
	@Test
	void testGetLeft() {
		String expectedValueOne = "Abc";
		BSTreeNode<String> expectedValueTwo = new BSTreeNode<String>(expectedValueOne);
		
		assertTrue(node.getLeft() == null);
		
		node.setLeft(expectedValueTwo);
		assertEquals(expectedValueTwo, node.getLeft());
		assertEquals(expectedValueOne, node.getLeft().getElement());
		
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#getRight()}.
	 */
	@Test
	void testGetRight() {
		String expectedValueOne = "Abc";
		BSTreeNode<String> expectedValueTwo = new BSTreeNode<String>(expectedValueOne);
		
		assertTrue(node.getRight() == null);
		
		node.setRight(expectedValueTwo);
		assertEquals(expectedValueTwo, node.getRight());
		assertEquals(expectedValueOne, node.getRight().getElement());
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#getElement()}.
	 */
	@Test
	void testGetElement() {
		String expectedValue = "A";
		
		assertEquals(expectedValue, node.getElement());
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#getDepth()}.
	 */
	@Test
	void testGetDepth() {
		int expectedValueOne = 5;
		int expectedValueTwo = 0;
		assertEquals(node.findDepth(), expectedValueTwo);
		
		BSTreeNode<String> nodeToAddOne = new BSTreeNode<String>("A");
		BSTreeNode<String> nodeToAddTwo = new BSTreeNode<String>("A");
		BSTreeNode<String> nodeToAddThree = new BSTreeNode<String>("A");
		BSTreeNode<String> nodeToAddFour = new BSTreeNode<String>("A");
		BSTreeNode<String> nodeToAddFive = new BSTreeNode<String>("A");
		node.setLeft(nodeToAddOne);
		node.getLeft().setLeft(nodeToAddTwo);
		node.getLeft().getLeft().setLeft(nodeToAddThree);
		node.getLeft().getLeft().getLeft().setLeft(nodeToAddFour);
		node.getLeft().getLeft().getLeft().getLeft().setLeft(nodeToAddFive);
		
		assertEquals(node.findDepth(), expectedValueOne);
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#setLeft(utilities.BSTreeNode)}.
	 */
	@Test
	void testSetLeft() {
		BSTreeNode<String> expectedValue = new BSTreeNode<String>("A");
		
		assertEquals(node.getLeft(), null);
		
		node.setLeft(expectedValue);
		
		assertEquals(node.getLeft(), expectedValue);
		
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#setRight(utilities.BSTreeNode)}.
	 */
	@Test
	void testSetRight() {
		BSTreeNode<String> expectedValue = new BSTreeNode<String>("A");
		
		assertEquals(node.getRight(), null);
		
		node.setRight(expectedValue);
		
		assertEquals(node.getRight(), expectedValue);
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#setElement(java.lang.Object)}.
	 */
	@Test
	void testSetElement() {
		String expectedValue = "Abc";
		
		node.setElement(expectedValue);
		
		assertEquals(node.getElement(), expectedValue);
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#isLeaf()}.
	 */
	@Test
	void testIsLeaf() {
		assertTrue(node.isLeaf());
		
		node.setLeft(new BSTreeNode<String>("Abc"));
		
		assertFalse(node.isLeaf());
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#hasRight()}.
	 */
	@Test
	void testHasRight() {
		assertFalse(node.hasRight());
		
		node.setRight(new BSTreeNode<String>("Abc"));
		assertTrue(node.hasRight());
	}

	/**
	 * Test method for {@link utilities.BSTreeNode#hasLeft()}.
	 */
	@Test
	void testHasLeft() {
		assertFalse(node.hasLeft());
		
		node.setLeft(new BSTreeNode<String>("Abc"));
		assertTrue(node.hasLeft());
	}
}
