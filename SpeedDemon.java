package dbscan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SpeedDemon {

	BufferedReader reader;
	HashMap<Integer, CustomPair> hashMap = new HashMap<Integer, CustomPair>();
	TreeSet<Integer> treeSet = new TreeSet<Integer>();
	
	public SpeedDemon(String path) throws IOException {
		reader = new BufferedReader(new FileReader(path));
	}
	public int run() throws IOException {
		while (reader.ready()) {
			String line = reader.readLine();
			int noobHash = asciiCalc(line);
			ArrayList<Character> chars = new ArrayList<Character>(line.length());
			for (int i = 0; i < line.length(); i++) {
				chars.add(line.charAt(i));
			}
			Collections.sort(chars);
			
			if (treeSet.add(noobHash)) { // returns true if it is not in the tree
				hashMap.put(noobHash, new CustomPair(chars, 1));
			} else {
				
				int newVal = hashMap.get(noobHash).getTail().;
				hashMap.put(noobHash, new newVal);
			}
			
		}
		reader.close();
		int ans = 0;
		for (Integer integer : treeSet) {
			int val = hashMap.get(integer);
			ans += countPair(val);
		}
		return ans;
	}
	
	static int countPair(int n) {
		if (n % 2 == 0) {
			return n/2 * (n-1);
		} else {
			return (n/2) * n;
		}
	}
	
	static int asciiCalc(String s) {
		int len = s.length();
		int val = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) % 2 == 0) {
				val += s.charAt(i) * 1003;
			} else {
				val += s.charAt(i) * 803;
			}
			
		}
		return val;
	}
	
}
