package ua.fantotsy;

public class PunctuationMark extends Symbol implements Lexeme {
	private boolean endOfSentence = false;
	private Symbol punctuationMark;

	public boolean isEndOfSentence() {
		return endOfSentence;
	}

	public Symbol getPunctuationMark() {
		return punctuationMark;
	}

	public PunctuationMark(char symbol) {
		super(symbol);
		if (isPunctuationMark(symbol) == true) {
			this.punctuationMark = new Symbol(symbol);
			if (symbol == '.' || symbol == '!' || symbol == '?') {
				endOfSentence = true;
			}
		} else {
			punctuationMark = null;
		}
	}

	private boolean isPunctuationMark(char symbol) {
		if ((symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z') || (symbol == '\'')) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(punctuationMark.getSymbol());
	}
}