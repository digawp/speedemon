package dbscan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;

/**
 * 
 * @author Diga W
 * 
 */
public class SpeedDemon {

	/**
	 * A pair of Integer[] to store the array of 128 integers representing an
	 * ascii value each and an int representing its current count (number of
	 * times a permutation of that characters appear in the database)
	 * 
	 * @author Diga W
	 * 
	 */
	class CustomPair {

		// the array of integer of size 128, each slot representing an ascii
		// character, with value representing the number of times it appears in
		// the line
		Integer[] charList;

		// the count for the number of times a permutation of the string
		// represented by the array of integer above appears in the database
		int total;

		/**
		 * Constructor
		 * 
		 * @param charlist
		 * @param value
		 */
		public CustomPair(Integer[] charlist, int value) {
			charList = charlist;
			total = value;
		}

		/**
		 * Returns the array of Integer
		 * 
		 * @return
		 */
		public Integer[] getCharList() {
			return charList;
		}

		/**
		 * Returns the current count so far
		 * 
		 * @return
		 */
		public int getTotal() {
			return total;
		}

		/**
		 * Increments the current count
		 */
		public void incrementTotal() {
			total++;
		}

	}

	// A buffered reader for reading the input file
	BufferedReader reader;

	// A hashmap to store the 'hashcode' and the custom pair class above
	HashMap<Integer, CustomPair> hashMap = new HashMap<Integer, CustomPair>();

	/**
	 * Constructor for SpeedDemon
	 * 
	 * @param path
	 * @throws IOException
	 */
	public SpeedDemon(String path) throws IOException {
		reader = new BufferedReader(new FileReader(path));
	}

	/**
	 * Main function of SpeedDemon
	 * 
	 * @return The number of pairs
	 * @throws IOException
	 */
	public int run() throws IOException {

		// The variable to be returned later as the answer
		int answer = 0;

		// Reading the file
		while (reader.ready()) {
			String line = reader.readLine();

			// Calculates a 'hashcode' for the particular line (see the method
			// definition for more info)
			int noobHash = asciiCalc(line);

			// Generate an array of integer to represent the string
			// Each ascii character has a slot, thus the size of array 128 (the
			// fact that 10 and 13 being always 0 is ignored for simplicity)
			Integer[] chars = new Integer[128];

			// Converts the string into the array of integer
			for (int i = 0; i < line.length(); i++) {
				int k = line.charAt(i);
				if (chars[k - 1] == null) {
					chars[k - 1] = 1;
				} else {
					chars[k - 1]++;
				}

			}

			while (hashMap.get(noobHash) != null) {
				if (Arrays.deepEquals(hashMap.get(noobHash).getCharList(),
						chars)) {
					answer += hashMap.get(noobHash).getTotal();
					hashMap.get(noobHash).incrementTotal();
					break;
				}
				noobHash++;
			}
			if (hashMap.get(noobHash) == null) {
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
