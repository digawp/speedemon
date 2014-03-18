package dbscan;

public class MergeSort {

	static <T extends Comparable<T>> void mergeSort(T[] A, int lo, int hi) {
		if (hi-lo > 0) {
			int q = lo + (hi-lo)/2;

			mergeSort(A, lo, q);
			mergeSort(A, q+1, hi);

			merge(A, lo, q+1, hi+1);
		}
	}

	static <T extends Comparable<T>>void merge(T[] a, int l, int r, int max) {
		// int totElem = max - l;
		// int[] a = new int[totElem];
		T[] copy = a.clone();
		int i = l;
		int li = l;
		int ri = r;
		while (i < max) {
			if ((li < r) && (ri < max)) {
				if (copy[li].compareTo(copy[ri]) < 0) {
					a[i] = copy[li];
					i++;
					li++;
				} else {
					a[i] = copy[ri];
					i++;
					ri++;
				}
			} else {
				if (li >= r) {
					while (ri < max) {
						a[i] = copy[ri];
						i++;
						ri++;
					}
				}
				if (ri >= max) {
					while (li < r) {
						a[i] = copy[li];
						li++;
						i++;
					}
				}
			}
		}
		// return a;

	}
	
	public static void main(String[] args) {
		Integer[] test = new Integer[]{1, 15, 3, 4, 0, 9, 20, 2, 7, 4};
		mergeSort(test, 0, test.length-1);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}

}
