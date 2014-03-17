package dbscan;

public class MergeSort {

	public static <T extends Comparable<T>> void run(T[] array, int lo, int hi) {
		if (hi - lo <= 1) {
			return;
		}
		run(array, lo, (hi-lo)/2);
		run(array, lo + (hi-lo/2) + 1, hi);
		merge(array, lo, lo + (hi-lo/2));
	}
	
	private static <T extends Comparable<T>> void merge(T[] array, int first, int second) {
		T[] copy = array.clone();
		int arrPointer = first;
		while (first < second && second < array.length && arrPointer < array.length) {
			if (copy[first].compareTo(copy[second]) > 0) {
				array[arrPointer] = copy[second];
				second++;
			} else {
				array[arrPointer] = copy[first];
				first++;
			}
			arrPointer++;
		}
	}
	
}
