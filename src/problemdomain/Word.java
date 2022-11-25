package problemdomain;

import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Word.
 */
public class Word implements Serializable, Comparable<Word> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2121448368698301047L;


	/** The string word. */
	private String stringWord;
	
	/** The file name. */
	private String fileName;
	
	/** The line number. */
	private long lineNumber;
	
	/** The word count. */
	private long wordCount;

	/**
	 * Instantiates a new word.
	 *
	 * @param stringWord the string word
	 * @param fileName the file name
	 * @param lineNumber the line number
	 */
	public Word(String stringWord, String fileName, long lineNumber) {
		this.stringWord = stringWord;
		this.fileName = fileName;
		this.lineNumber = lineNumber;
		wordCount++;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the string word.
	 *
	 * @return the string word
	 */
	public String getStringWord() {
		return stringWord;
	}

	/**
	 * Sets the word.
	 *
	 * @param stringWord the new word
	 */
	public void setWord(String stringWord) {
		this.stringWord = stringWord;
	}

	/**
	 * Gets the line number.
	 *
	 * @return the line number
	 */
	public long getLineNumber() {
		return lineNumber;
	}

	/**
	 * Sets the line number.
	 *
	 * @param lineNumber the new line number
	 */
	public void setLineNumber(long lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * Gets the word count.
	 *
	 * @return the word count
	 */
	public long getWordCount() {
		return wordCount;
	}

	/**
	 * Sets the word count.
	 *
	 * @param wordCount the new word count
	 */
	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	/**
	 * Word count increase.
	 */
	public void wordCountIncrease() {
		wordCount++;
	}

	/**
	 * Compare to.
	 *
	 * @param toCompare the to compare
	 * @return -1, 0 or 1 if its less then, equal or greater then.
	 */
	@Override
	public int compareTo(Word toCompare) {
		return this.stringWord.compareTo(toCompare.getStringWord());
	}

}
