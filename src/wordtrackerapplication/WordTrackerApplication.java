package wordtrackerapplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import managers.IOManager;
import managers.WordTreeManager;
import problemdomain.Word;
import utilities.*;

public class WordTrackerApplication {
	public static void main(String[] args) {		
		try {
			String outputFileName = null;
			IOManager ioManager = new IOManager();
			WordTreeManager wordTreeManager = new WordTreeManager();
			BSTree<Word> wordBSTree = null;
			String inputFileName = args[0];
			char outputFormat = args[1].toLowerCase().charAt(args[1].length() - 1);
			
			// Third argument is in place put into outputFileName variable
			if(args.length == 3) {
				outputFileName = args[2];
			}
			
			Scanner fileIn = ioManager.readFile(inputFileName);
			
			if(!ioManager.checkForTreeFile()) {
				wordBSTree = wordTreeManager.createNewTree(fileIn, inputFileName);
				ioManager.saveTree(wordBSTree);
			} else {
				wordBSTree = ioManager.getTree();
			}
			
			Iterator<Word> it = wordBSTree.preorderIterator(); 
			
			while(it.hasNext()) {
				Word word = it.next();
				System.out.println("Word: " + word.getStringWord() + ". First Seen at line number " + word.getLineNumber() + 
						". Word Count: " + word.getWordCount() + ". First seen at file Location: " + word.getFileName() + ".");
			}
			
			switch(outputFormat)  {
				case 'f':
					// TODO
					break;
				case 'l':
					// TODO
					break;
				case 'o':
					// TODO
					break;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("The text file was not found at that location");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error with Input or Output stream");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter the correct arguments. Refer to the readMe File for "
					+ "more intructions");
		}
	}

}
