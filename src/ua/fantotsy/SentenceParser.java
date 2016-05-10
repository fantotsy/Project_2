package ua.fantotsy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SentenceParser {
	private List<Sentence> sentences;
	
	public List<Sentence> getSentences(){
		return sentences;
	}
	
	public SentenceParser(){
		sentences = new ArrayList<Sentence>();
	}
	
	public void parse(Scanner scanner){
		Sentence temp = null;
		
		while(scanner.hasNext()){
			temp = new Sentence();
			temp.read(scanner);
			sentences.add(temp);
		}
	}
}