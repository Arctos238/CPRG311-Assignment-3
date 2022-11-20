package managers;

import java.io.*;
import java.util.*;

import utilities.*;
import utilities.Iterator;
import problemdomain.*;

public class IOManager {
	private final String TREE_FILE_LOCATION = "res/respoitory.ser";

	/**
	 * This method will return a scanner for a file entered by the user. When the
	 * method is called it will be passed a String with the file location
	 * 
	 * @param fileLocation will be given when the method is called and a File will
	 *                     be created by this String. If the String is a invalid
	 *                     location it will throw a FileNotFoundExcpetion back to
	 *                     the previous call.
	 * @return Scanner object that contains the file.
	 * @throws FileNotFoundException if it can not located a file with the String
	 *                               passed through.
	 */
	public Scanner readFile(String fileLocation) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileLocation));

		return scanner;
	}

	/**
	 * This method will check to see if a binary file named respoitory.ser
	 * 
	 * @return true if a tree file exists and false if tree files doesn't exist
	 */
	public boolean checkForTreeFile() {
		File file = new File(TREE_FILE_LOCATION);
		String path = file.getName();
		System.out.println(path);
		return file.exists();
	}

	/**
	 * This method will save the binary search tree to a binary file named
	 * repository.ser;
	 * 
	 * @param BSTree<String> tree to save to a repository
	 * @throws IOException
	 */
	public void saveTree(BSTree<Word> tree) throws IOException {
		Iterator<Word> preOrderIt = tree.preorderIterator();
		Iterator<Word> inOrderIt = tree.inorderIterator();
		FileOutputStream fileOut = new FileOutputStream(TREE_FILE_LOCATION);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

		// Write the preOrder to the binary file.
		while (preOrderIt.hasNext()) {
			objectOut.writeObject(preOrderIt.next());
		}
		;

		// Insert New Line to create a gap between the orders
		objectOut.write('\n');

		// Write the inOrder to the binary file.
		while (inOrderIt.hasNext()) {
			objectOut.writeObject(inOrderIt.next());
		}

		objectOut.close();
	}

	/**
	 * This method will generate a tree file from the repository.ser binary file
	 * 
	 * @return BSTree<String> that contains the tree file.
	 * @throws IOException
	 */
	public BSTree<Word> getTree() {
		FileInputStream fileIn;
		ObjectInputStream objectIn;
		
		try {
			fileIn = new FileInputStream(TREE_FILE_LOCATION);
			objectIn = new ObjectInputStream(fileIn);
			
			ArrayList<Word> preOrderArrayList = preOrderGenerator(objectIn);

			ArrayList<Word> inOrderArrayList = inOrderGenerator(objectIn);

			BSTreeNode<Word> root = rebuildTree(preOrderArrayList, inOrderArrayList, 0, inOrderArrayList.size() - 1);
			
			BSTree<Word> wordTree = new BSTree<Word>(root);
			
			return wordTree;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BSTreeNode<Word> rebuildTree(ArrayList<Word> preOrderArrayList, ArrayList<Word> inOrderArrayList, int inOrderPos, int inEnd) {
		// TODO Auto-generated method stub
		
		return null;
	}

	/**
	 * 
	 * @param objectIn
	 * @return
	 */
	private ArrayList<Word> inOrderGenerator(ObjectInputStream objectIn) {
		ArrayList<Word> preOrderArrayList = new ArrayList<>();
		
		try {
			objectIn.readChar();
			while (true) {
				Word word = (Word) objectIn.readObject();
				preOrderArrayList.add(word);
			}
		} catch (EOFException e) {
			System.out.println("The tree file has been read, please wait for tree to be generated.");
		} catch (ClassNotFoundException e) {
			System.out.println("inOrderGenerator found a ClassNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("inOrderGenerator found a IOException");
			e.printStackTrace();
		} finally {
			try {
				objectIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return preOrderArrayList;
	}
	
	/**
	 * Generates the preOrder tree list.
	 * @param objectIn
	 * @return ArrayList<Word> containing the preOrderGenerator list;
	 */
	private ArrayList<Word> preOrderGenerator(ObjectInputStream objectIn) {
		boolean newLineNotFound = true;
		ArrayList<Word> preOrderArrayList = new ArrayList<>();

		while (newLineNotFound) {
			// Read the preOrder to the binary file.
			try {
				Word word = (Word) objectIn.readObject();
				preOrderArrayList.add(word);
			} catch (ClassNotFoundException | IOException e) {
				newLineNotFound = false;
			}
		}

		return preOrderArrayList;
	}
	
	
}