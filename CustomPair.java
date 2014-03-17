package dbscan;

import java.util.ArrayList;

public class CustomPair {
	
	ArrayList<Character> charList;
	int total;
	
	public CustomPair(ArrayList<Character> charlist, int value) {
		charList = charlist;
		total = value;
	}
	
	public ArrayList<Character> getCharList() {
		return charList;
	}
	
	public int getTotal() {
		return total;
	}
	
}
