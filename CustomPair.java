package dbscan;

public class CustomPair {
	
	int[] charList;
	int total;
	
	public CustomPair(int[] charlist, int value) {
		charList = charlist;
		total = value;
	}
	
	public int[] getCharList() {
		return charList;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void incrementTotal() {
		total++;
	}
	
}
