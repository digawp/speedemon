package dbscan;

public class Pair<K, V> {
	
	K first;
	V second;
	
	public Pair(K key, V value) {
		first = key;
		second = value;
	}
	
	public K getHead() {
		return first;
	}
	
	public V getTail() {
		return second;
	}
	
}
