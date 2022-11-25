package wordtrackerapplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import managers.IOManager;
import managers.WordTreeManager;
import problemdomain.Word;
import utilities.*;

/**
 * The Class WordTrackerApplication.
 */
public class WordTrackerApplication {
	 

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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
				outputFileName = args[2].substring(2, args[2].length());
			}
			
			Scanner fileIn = iOManager.readFile(inputFileName);
			
			// If there is no file called respoitory.ser then if will create a new tree.
			// If there is a file it will add the new word search to the new tree.
			if(!iOManager.checkForTreeFile()) {
				wordBSTree = wordTreeManager.createNewTree(fileIn, inputFileName);
				iOManager.saveTree(wordBSTree);
			} else {
				wordBSTree = iOManager.getTree();
				wordTreeManager.addToTree(wordBSTree, fileIn, inputFileName);
				iOManager.saveTree(wordBSTree);
			}
			
			// Checks for the format and if there is an output file it will print the result to the
			// output file else print to screen.
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
		} catch (IOException e) {
			System.out.println("Error with Input or Output stream");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter the correct arguments. Refer to the readMe File for "
					+ "more intructions");
		} 
	}

}
