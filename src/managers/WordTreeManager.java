package managers;

import java.io.File;
import java.util.Scanner;

import exceptions.TreeException;
import problemdomain.Word;
import utilities.BSTree;
import utilities.BSTreeNode;

public class WordTreeManager {
	public BSTree<Word> createNewTree(Scanner fileIn, String fileName) {
		BSTree<Word> wordBSTree = new BSTree<Word>();
		
		fileName = new File(fileName).getName();
		
		int lineNumber = 1;
		while (fileIn.hasNextLine()) {
			String[] wordsOnLine = fileIn.nextLine().split(" ");

			for (int i = 0; i < wordsOnLine.length; i++) {
				String stringWord = wordsOnLine[i].replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
				
				if(stringWord.length() > 0) {
					Word word = new Word(stringWord, fileName, lineNumber);

					if (wordBSTree.size() != 0) {
						try {
							BSTreeNode<Word> wordNode = null;
							wordNode = wordBSTree.search(word);

							if (wordNode != null) {
								wordNode.getElement().wordCountIncrease();
							} else {

								wordBSTree.add(word);
							}
						} catch (TreeException e) {
							System.out.println("Tree is empty when it shound't be");
							e.printStackTrace();
						}

					} else {
						wordBSTree.add(word);
					}
				}
				
			}

			lineNumber++;
		}
		
		return wordBSTree;
	}
}
