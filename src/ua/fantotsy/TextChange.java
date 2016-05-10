package ua.fantotsy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextChange {
	public void twelve(int length, String inputFile, String outputFile) {
		SentenceParser parser = new SentenceParser();
		try {
			parser.parse(new Scanner(new File(inputFile)));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open file to parse! " + e.getMessage());
		}

		List<Lexeme> temp;
		for (Sentence sentence : parser.getSentences()) {
			temp = new ArrayList<Lexeme>();
			for (Lexeme lexeme : sentence.getLexemes()) {
				if (!isConsonant(lexeme.toString().charAt(0)) || (lexeme.toString().length() != length)) {
					temp.add(lexeme);
				}
			}
			sentence.setLexemes(temp);
		}

		try (FileWriter writer = new FileWriter(outputFile, true)) {
			int amountOfSentences = parser.getSentences().size();
			for (int i = 0; i < amountOfSentences; i++) {
				writer.write(parser.getSentences().get(i).toString());
				if (i != (amountOfSentences - 1)) {
					writer.write(" ");
				}
			}
		} catch (IOException e) {
			System.out.println("Cannot write file after parsing! " + e.getMessage());
		}
	}

	private boolean isConsonant(char letter) {
		if (letter != 'a' && letter != 'A' && letter != 'e' && letter != 'E' && letter != 'i' && letter != 'I'
				&& letter != 'o' && letter != 'O' && letter != 'u' && letter != 'U') {
			return true;
		} else {
			return false;
		}
	}
}