package problemdomain;

import java.io.*;

public class Word implements Serializable, Comparable<Word> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2993467836878164143L;
	/**
	 * 
	 */

	private String word;
	private long lineNumber;
	private long wordCount;
	
	public Word(String word, long lineNumber) {
		this.word = word;
		this.lineNumber = lineNumber;
		wordCount++;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public long getWordCount() {
		return wordCount;
	}


	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	public void wordCountIncrease() {
		wordCount++;
	}
	
	
	@Override
	public int compareTo(Word toCompare) {
		return this.word.compareTo(toCompare.getWord());
	}
	
}
