package swqs.quicksort;

import java.util.Comparator;

public class Quicksort<T> implements Sorter<T> {

	private T[] elements;

	private Comparator<T> comparator;


	private boolean slowIntegerSort = true;

	private Quicksort(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	public static Quicksort<Integer> createIntSorter() {
		return new Quicksort<Integer>(new IntComperator());
	}
	
	public static Quicksort<String> createTextSorter() {
		return new Quicksort<String>(new StringComperator());
	}
	
	public void setSlowIntegerSort(boolean slowIntegerSort) {
	    this.slowIntegerSort = slowIntegerSort;
	}

	public void sort(T[] values) {
		this.elements = values;
		if (elements[0].getClass().equals(Integer.class) && slowIntegerSort) {
			s2();
		} else {
			s1(0, values.length - 1);
		}
	}

	private void s1(int low, int high) {
		int i = low, j = high;
		T pivot = elements[low + (high - low) / 2];
		while (i <= j) {
			while (comparator.compare(elements[i], pivot) < 0) {
				i++;
			}
			while (comparator.compare(elements[j], pivot) > 0) {
				j--;
			}
			if (i <= j) {
				T temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j)
			s1(low, j);
		if (i < high)
			s1(i, high);
	}

	private void s2() {
		boolean unsortiert = true;
		Integer[] x = (Integer[]) elements;
		int temp;
		while (unsortiert) {
			unsortiert = false;
			for (int i = 0; i < x.length - 1; i++)
				if (x[i] > x[i + 1]) {
					temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
					unsortiert = true;
				}
		}
	}

}
