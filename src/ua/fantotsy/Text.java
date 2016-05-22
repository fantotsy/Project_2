package ua.fantotsy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text {
	private List<Sentence> text;

	public Text() {
		text = new ArrayList<Sentence>();
	}

	public List<Sentence> getText() {
		return text;
	}

	public void setText(String filePath) {
		Sentence temp = null;

		try {
			Scanner scanner = new Scanner(new File(filePath));

			while (scanner.hasNext()) {
				temp = new Sentence();
				temp.read(scanner);
				text.add(temp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file \"" + filePath + "\" is not found! " + e.getMessage());
		}
	}
}
