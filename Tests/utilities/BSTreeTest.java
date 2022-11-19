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
 * @author J.Pointer
 *
 */
class BSTreeTest {
	BSTree<Integer> tree;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		tree = new BSTree<Integer>();
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
		int expectedValue = 10;
		tree = new BSTree<Integer>(expectedValue);

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
		BSTree<Integer> tree = new BSTree<Integer>();

		try {
			tree.getRoot();
			fail("TreeException did not throw");
		} catch (TreeException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#getRoot()}.
	 */
	@Test
	void testGetRoot() {
		BSTree<Integer> tree = new BSTree<Integer>();

		try {
			tree.getRoot();
			fail("TreeException did not throw");
		} catch (TreeException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#getRoot()}.
	 */
	@Test
	void testGetRootTreeException() {
		int expectedValue = 10;
		BSTree<Integer> tree = new BSTree<Integer>(expectedValue);

		try {
			assertEquals(tree.getRoot().getElement(), expectedValue);
		} catch (TreeException e) {
			fail("Didn't get created successfully");
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#getHeight()}.
	 */
	@Test
	void testGetHeight() {
		int expectedValue = 4;

		tree.add(8);
		tree.add(3);
		tree.add(10);
		tree.add(1);
		tree.add(6);
		tree.add(14);
		tree.add(4);
		tree.add(7);
		tree.add(13);

		assertEquals(tree.getHeight(), expectedValue);
	}

	/**
	 * Test method for {@link utilities.BSTree#size()}.
	 */
	@Test
	void testSize() {
		int expectedValue = 4;

		tree.add(8);
		tree.add(3);
		tree.add(10);
		tree.add(1);

		assertNotEquals(tree.size(), 100);
		assertEquals(tree.size(), expectedValue);
	}

	/**
	 * Test method for {@link utilities.BSTree#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(tree.isEmpty());
	}

	/**
	 * Test method for {@link utilities.BSTree#isEmpty()}.
	 */
	@Test
	void testIsNotEmpty() {
		tree.add(8);
		tree.add(3);
		tree.add(10);
		tree.add(1);

		assertFalse(tree.isEmpty());
	}

	/**
	 * Test method for {@link utilities.BSTree#clear()}.
	 */
	@Test
	void testClear() {
		int expectedValue = 0;

		assertTrue(tree.isEmpty());

		tree.add(8);
		tree.add(3);
		tree.add(10);
		tree.add(1);

		assertFalse(tree.isEmpty());

		tree.clear();

		assertEquals(tree.size(), expectedValue);
		assertTrue(tree.isEmpty());
		assertEquals(tree.getHeight(), 0);
	}

	/**
	 * Test method for {@link utilities.BSTree#contains(java.lang.Comparable)}.
	 */
	@Test
	void testContains() {
		int expectedValueOne = 8;
		int expectedValueTwo = 25;
		int notExpected = 654;

		tree.add(expectedValueOne);
		tree.add(3);
		tree.add(10);
		tree.add(expectedValueTwo);

		try {
			assertTrue(tree.contains(expectedValueOne));
			assertTrue(tree.contains(expectedValueTwo));
			assertFalse(tree.contains(notExpected));
		} catch (TreeException e) {
			fail("Exception raised when tree wasn't empty");
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#contains(java.lang.Comparable)}.
	 */
	@Test
	void testContainsTreeException() {
		try {
			tree.contains(52);
			fail("Tree Exception didn't throw");
		} catch (TreeException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#search(java.lang.Comparable)}.
	 */
	@Test
	void testSearchE() {
		int expectedValueOne = 8;
		int expectedValueTwo = 25;

		tree.add(expectedValueOne);
		tree.add(3);
		tree.add(10);
		tree.add(expectedValueTwo);

		try {
			assertEquals(tree.search(expectedValueOne).getElement(), expectedValueOne);
			assertEquals(tree.search(expectedValueTwo).getElement(), expectedValueTwo);
			assertEquals(tree.search(65), null);
		} catch (TreeException e) {
			fail("Exception raised when tree wasn't empty");
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#contains(java.lang.Comparable)}.
	 */
	@Test
	void testSearchETreeException() {
		try {
			tree.search(52);
			fail("Tree Exception didn't throw");
		} catch (TreeException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 */
	@Test
	void testAdd() {
		int expectedValueOne = 3;

		tree.add(expectedValueOne);
		tree.add(10);

		try {
			assertEquals(tree.getRoot().getElement(), expectedValueOne);
		} catch (TreeException e) {
			fail("TreeException thrown");
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 */
	@Test
	void testAddNullPointerException() {
		try {
			tree.add(null);
			fail("NullPointerException should throw");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	void testInorderIterator() {
		int[] nums = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		for (int i : nums) {
			tree.add(i);
		}
		
		int[] correctOutput = {1, 3, 4, 6, 7, 8, 10, 13, 14};
		
		Iterator<Integer> it = tree.inorderIterator();

		for(int i : correctOutput) {
			int x = it.next();
			if(i != x) {
				System.out.println(x);
				fail("Not correct order");
			}
		}
		
		assertTrue(true);
	}

	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	void testPreorderIterator() {
		int[] nums = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		for (int i : nums) {
			tree.add(i);
		}
		
		int[] correctOutput = {8, 3, 1, 6, 4, 7, 10, 14, 13};
		
		Iterator<Integer> it = tree.preorderIterator();

		for(int i : correctOutput) {
			if(i != it.next()) {
				fail("Not correct order");
			}
		}
		
		assertTrue(true);
	}

	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	void testPostorderIterator() {
		int[] nums = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

		for (int i : nums) {
			tree.add(i);
		}
		
		int[] correctOutput = {1, 4, 7, 6, 3, 13, 14, 10, 8};
		
		Iterator<Integer> it = tree.postorderIterator();

		for(int i : correctOutput) {
			if(i != it.next()) {
				fail("Not correct order");
			}
		}
		
		assertTrue(true);
	}

}
