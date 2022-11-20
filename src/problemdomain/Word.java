package problemdomain;

import java.io.*;

public class Word implements Serializable, Comparable<Word> {

	private static final long serialVersionUID = -2121448368698301047L;


	private String stringWord;
	private String fileName;
	private long lineNumber;
	private long wordCount;

	public Word(String stringWord, String fileName, long lineNumber) {
		this.stringWord = stringWord;
		this.fileName = fileName;
		this.lineNumber = lineNumber;
		wordCount++;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStringWord() {
		return stringWord;
	}

	public void setWord(String stringWord) {
		this.stringWord = stringWord;
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
		return this.stringWord.compareTo(toCompare.getStringWord());
	}

}
