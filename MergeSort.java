package dbscan;

import java.util.Arrays;

public class MergeSort {

	static <T extends Comparable<T>> void mergeSort(T[] A) {
		if (A.length > 1) {
			int q = A.length / 2;

			T[] leftArray = Arrays.copyOfRange(A, 0, q);
			T[] rightArray = Arrays.copyOfRange(A, q, A.length);

			mergeSort(leftArray);
			mergeSort(rightArray);

			merge(A, leftArray, rightArray);
		}
	}

	static <T extends Comparable<T>>void merge(T[] a, T[] l, T[] r) {
		int totElem = l.length + r.length;
		// int[] a = new int[totElem];
		int i, li, ri;
		i = li = ri = 0;
		while (i < totElem) {
			if ((li < l.length) && (ri < r.length)) {
				if (l[li].compareTo(r[ri]) < 0) {
					a[i] = l[li];
					i++;
					li++;
				} else {
					a[i] = r[ri];
					i++;
					ri++;
				}
			} else {
				if (li >= l.length) {
					while (ri < r.length) {
						a[i] = r[ri];
						i++;
						ri++;
					}
				}
				if (ri >= r.length) {
					while (li < l.length) {
						a[i] = l[li];
						li++;
						i++;
					}
				}
			}
		}
		// return a;

	}

}
