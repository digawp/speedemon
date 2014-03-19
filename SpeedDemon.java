package dbscan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SpeedDemon {

	BufferedReader reader;
	HashMap<Integer, CustomPair> hashMap = new HashMap<Integer, CustomPair>();
	
	public SpeedDemon(String path) throws IOException {
		reader = new BufferedReader(new FileReader(path));
	}
	public int run() throws IOException {
		
		int answer = 0;
		
		while (reader.ready()) {
			String line = reader.readLine();
			
			int noobHash = asciiCalc(line);
			
			Integer[] chars = new Integer[128];
			
			for (int i = 0; i < line.length(); i++) {
				int k = line.charAt(i);
				if (chars[k-1] == null) {
					chars[k-1] = 1;
				} else {
					chars[k - 1]++;
				}
				
			}
			
			if (hashMap.containsKey(noobHash)) {
				if (Arrays.deepEquals(hashMap.get(noobHash).getCharList(), chars)) {
					answer += hashMap.get(noobHash).getTotal();
					hashMap.get(noobHash).incrementTotal();
				} else {
					while (hashMap.get(noobHash) != null) {
						if (Arrays.deepEquals(hashMap.get(noobHash).getCharList(), chars)) {
							answer += hashMap.get(noobHash).getTotal();
							hashMap.get(noobHash).incrementTotal();
							break;
						}
						noobHash++;
					}
					if (hashMap.get(noobHash) == null) {
						hashMap.put(noobHash, new CustomPair(chars,1));
					}
				}
				
				
			} else {
				hashMap.put(noobHash, new CustomPair(chars, 1));
			}
			
		}
		reader.close();
		
		return answer;
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
