package ua.fantotsy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Sentence {
	private List<Lexeme> lexemes;

	public List<Lexeme> getLexemes() {
		return lexemes;
	}
	
	public void setLexemes(List<Lexeme> lexemes){
		this.lexemes = lexemes;
	}

	public Sentence() {
		lexemes = new ArrayList<Lexeme>();
	}

	public void addLexeme(Lexeme lexeme) {
		lexemes.add(lexeme);
	}

	public void read(Scanner scanner) {
		String temp = null;
		int wordLength = 0;
		boolean endOfSentence = false;
		Stack<PunctuationMark> punctuationMarks = new Stack<PunctuationMark>();

		do {
			if (scanner.hasNext()) {
				temp = scanner.next();

				wordLength = temp.length();

				punctuationMarks.push(new PunctuationMark(temp.charAt(wordLength - 1)));
				if (punctuationMarks.peek().getPunctuationMark() == null) {
					punctuationMarks.pop();
					addLexeme(new Word(temp));
				} else {
					wordLength--;
					if (punctuationMarks.peek().isEndOfSentence()) {
						endOfSentence = true;
					}
					for (int i = wordLength - 1; i >= 0; --i) {
						punctuationMarks.push(new PunctuationMark(temp.charAt(i)));
						if (punctuationMarks.peek().getPunctuationMark() == null) {
							punctuationMarks.pop();
							break;
						} else {
							wordLength--;
						}
					}
					if (wordLength > 0) {
						addLexeme(new Word(temp.substring(0, wordLength)));
					}
					while (!punctuationMarks.empty()) {
						addLexeme(punctuationMarks.pop());
					}
				}
			} else {
				endOfSentence = true;
			}
		} while (!endOfSentence);
	}

	@Override
	public String toString() {
		String result = new String();
		for (int i = 0; i < lexemes.size(); i++) {
			result += lexemes.get(i).toString();
			if ((i != (lexemes.size() - 1)) && !(lexemes.get(i + 1) instanceof PunctuationMark)) {
				result += " ";
			}
		}
		return result;
	}
}