package ua.fantotsy;

public class Main {

	public static void main(String[] args) {
		TextChange changer = new TextChange();
		changer.twelve(3, "src/book.txt", "src/out_book.txt");
		System.out.println("The file was successfully changed.");
	}
}