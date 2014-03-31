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
public class WidyapranaPS5 {

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
	public WidyapranaPS5(String path) throws IOException {
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

				// converts char to int
				int k = line.charAt(i);

				// Because of the usage of wrapper class Integer instead of int,
				// the default value is null instead of 0
				if (chars[k - 1] == null) {
					// If char with ascii value k is found the first time,
					// change the value of the respective slot in the array to 1
					// k-1 instead of kth slot is used because of the max index
					// being 127 instead of 128 in an array of size 128
					chars[k - 1] = 1;
				} else {
					// if a char with ascii value k is found again, just
					// increment the initial value
					chars[k - 1]++;
				}

			}

			// Checks if the 'hashcode' is already in the hashmap
			while (hashMap.get(noobHash) != null) {

				// if the array of int in the hashmap with noobhash hashcode is
				// the same as the array of int being checked, increment the
				// count on that element
				if (Arrays.deepEquals(hashMap.get(noobHash).getCharList(),
						chars)) {
					answer += hashMap.get(noobHash).getTotal();
					hashMap.get(noobHash).incrementTotal();
					break;
				}

				// Linear probing is used
				noobHash++;

			}

			// this branch is reached if either the hashcode is not in the
			// hashmap yet, or the hashcode is in the hashmap but actually of
			// different value (collision), so a new key is added to the hashmap
			// via linear probing method
			if (hashMap.get(noobHash) == null) {
				hashMap.put(noobHash, new CustomPair(chars, 1));
			}

		}
		reader.close();

		return answer;
	}

	/**
	 * Calculates the 'hashcode' of a string provided as the argument. The
	 * hashcode is calculated by multiplying the ascii value of the character by
	 * 1003 if it is even, or by 803 if it is odd (just some prime magic
	 * numbers, no specific reason of using these numbers whatsoever)
	 * 
	 * @param s
	 * @return
	 */
	static int asciiCalc(String s) {

		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) % 2 == 0) {
				// if ascii value is even, mutiply by 1003
				val += s.charAt(i) * 1003;
			} else {
				// if ascii value is odd, multiply by 803
				val += s.charAt(i) * 803;
			}

		}
		return val;
	}

	
	public static void main(String[] args) throws IOException {

		for (int i = 0; i < args.length; i++) {
			WidyapranaPS5 demon = new WidyapranaPS5(args[i]);
			int ans = demon.run();
			System.out.println("Number of pairs: " + ans);
		}

	}
	

}
