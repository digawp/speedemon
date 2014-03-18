package dbscan;

public class CustomPair {
	
	Integer[] charList;
	int total;
	
	public CustomPair(Integer[] charlist, int value) {
		charList = charlist;
		total = value;
	}
	
	public Integer[] getCharList() {
		return charList;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void incrementTotal() {
		total++;
	}
	
}
