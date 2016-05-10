package ua.fantotsy;

public class Word implements Lexeme {
	String word;

	public Word(String word) {
		this.word = word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	@Override
	public String toString() {
		return word;
	}
}