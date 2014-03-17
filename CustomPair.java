package dbscan;

public class CustomPair {
	
	Character[] charList;
	int total;
	
	public CustomPair(Character[] charlist, int value) {
		charList = charlist;
		total = value;
	}
	
	public Character[] getCharList() {
		return charList;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void incrementTotal() {
		total++;
	}
	
}
