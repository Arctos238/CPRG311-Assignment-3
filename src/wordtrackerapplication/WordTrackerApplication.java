package wordtrackerapplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import manager.IOManager;
import manager.WordTreeManager;
import problemdomain.Word;
import utilities.*;

public class WordTrackerApplication {
	private static String DEFAULT_FILE_LOCATION = "res/textfile.txt";
	
	public static void main(String[] args) {
		try {
			IOManager ioManager = new IOManager();
			WordTreeManager wordTreeManager = new WordTreeManager();
			BSTree<Word> wordBSTree = null;
			
			Scanner fileIn = ioManager.readFile(DEFAULT_FILE_LOCATION);
			
			if(!ioManager.checkForTreeFile()) {
				wordBSTree = wordTreeManager.createNewTree(fileIn);
				ioManager.saveTree(wordBSTree);
			} else {
				wordBSTree = ioManager.getTree();
				
				Iterator<Word> it = wordBSTree.inorderIterator(); 
				
				while(it.hasNext()) {
					Word word = it.next();
					System.out.println("Word: " + word.getStringWord() + " First Seen at line number " + word.getLineNumber() + " Word Count: " + word.getWordCount());
				}
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("The text file was not found at that location");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error with Input or Output stream");
			e.printStackTrace();
		}
	}

}
