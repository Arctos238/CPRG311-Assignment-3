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
			IOManager iOManager = new IOManager();
			WordTreeManager wordTreeManager = new WordTreeManager();
			BSTree<Word> wordBSTree = null;
			String inputFileName = args[0];
			char outputFormat = args[1].toLowerCase().charAt(args[1].length() - 1);
			
			// Third argument is in place put into outputFileName variable
			if(args.length == 3) {
				outputFileName = args[2];
			}
			
			Scanner fileIn = iOManager.readFile(inputFileName);
			
			if(!iOManager.checkForTreeFile()) {
				wordBSTree = wordTreeManager.createNewTree(fileIn, inputFileName);
				iOManager.saveTree(wordBSTree);
			} else {
				wordBSTree = iOManager.getTree();
				wordTreeManager.addToTree(wordBSTree, fileIn, inputFileName);
				iOManager.saveTree(wordBSTree);
			}
			
			switch (outputFormat) {
			case 'f':
				if (outputFileName != null) {
					iOManager.printWordWithFileName(wordBSTree, outputFileName);
				} else {
					wordTreeManager.printWordWithFileName(wordBSTree);
				}
				break;
			case 'l':
				if (outputFileName != null) {
					iOManager.printWordWithLines(wordBSTree, outputFileName);
				} else {
					wordTreeManager.printWordWithLines(wordBSTree);
				}
				break;
			case 'o':
				if(outputFileName != null) {
					iOManager.printWordWithFrequency(wordBSTree, outputFileName);
				} else {
					wordTreeManager.printWordWithFrequency(wordBSTree);
				}
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
