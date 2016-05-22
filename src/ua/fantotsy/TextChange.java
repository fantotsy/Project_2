package ua.fantotsy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextChange {
	public static void twelve(int length, Text text, String outputFile) {
		List<Lexeme> temp;
		for (Sentence sentence : text.getText()) {
			temp = new ArrayList<Lexeme>();
			for (Lexeme lexeme : sentence.getLexemes()) {
				if (!isConsonant(lexeme.toString().charAt(0)) || (lexeme.toString().length() != length)) {
					temp.add(lexeme);
				}
			}
			sentence.setLexemes(temp);
		}

		try (FileWriter writer = new FileWriter(outputFile, true)) {
			int amountOfSentences = text.getText().size();
			for (int i = 0; i < amountOfSentences; i++) {
				writer.write(text.getText().get(i).toString());
				if (i != (amountOfSentences - 1)) {
					writer.write(" ");
				}
			}
		} catch (IOException e) {
			System.out.println("Cannot write file after parsing! " + e.getMessage());
		}
	}

	private static boolean isConsonant(char letter) {
		if (letter != 'a' && letter != 'A' && letter != 'e' && letter != 'E' && letter != 'i' && letter != 'I'
				&& letter != 'o' && letter != 'O' && letter != 'u' && letter != 'U') {
			return true;
		} else {
			return false;
		}
	}
}