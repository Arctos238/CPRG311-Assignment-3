/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.TreeException;

/**
 * @author Arcto
 *
 */
class BSTreeTest {
	BSTree<String> tree;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		tree = new BSTree<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test method for {@link utilities.BSTree#BSTree()}.
	 */
	@Test
	void testBSTree() {
		String expectedValue = "A";
		BSTree<String> tree = new BSTree<String>("A");
		
		try {
			assertEquals(tree.getRoot().getElement(), expectedValue);
		} catch (TreeException e) {
			fail("Didn't get created successfully");
		}
		
		
	}

	/**
	 * Test method for {@link utilities.BSTree#BSTree()}.
	 */
	@Test
	void testBSTreeException() {
		BSTree<String> tree = new BSTree<String>();

		try {
			tree.getRoot();
			fail("TreeException did not throw");
		} catch (TreeException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#BSTree(java.lang.Comparable)}.
	 */
	@Test
	void testBSTreeE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#getRoot()}.
	 */
	@Test
	void testGetRoot() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#getHeight()}.
	 */
	@Test
	void testGetHeight() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#size()}.
	 */
	@Test
	void testSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#clear()}.
	 */
	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#contains(java.lang.Comparable)}.
	 */
	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#search(java.lang.Comparable)}.
	 */
	@Test
	void testSearchE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link utilities.BSTree#search(java.lang.Comparable, utilities.BSTreeNode)}.
	 */
	@Test
	void testSearchEBSTreeNodeOfE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 */
	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	void testInorderIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	void testPreorderIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	void testPostorderIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		fail("Not yet implemented");
	}

}
