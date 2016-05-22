package ua.fantotsy;

public class Main {

	public static void main(String[] args) {
		Text text = new Text();
		text.setText("src/book.txt");
		TextChange.twelve(3, text, "src/out_book.txt");
		System.out.println("The file was successfully changed.");
	}
}