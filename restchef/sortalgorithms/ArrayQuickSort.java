package restchef.sortalgorithms;

public class ArrayQuickSort<T extends Comparable<T>> {

	public void sort(T[] pArray) {
		sort(pArray, 0, pArray.length - 1);
	}

	public void sort(T[] pArray, int pMin, int pMax) {

		if (pMin < pMax) {
			int min = pMin, max = pMax;
			T pivot = pArray[(min + max) / 2];

			do {
				while (pArray[min].compareTo(pivot) < 0)
					min++;
				while (pivot.compareTo(pArray[max]) < 0)
					max--;

				if (min <= max) {
					T tmp = pArray[min];
					pArray[min] = pArray[max];
					pArray[max] = tmp;
					min++;
					max--;
				}

			} while (min <= max);

			sort(pArray, pMin, max);
			sort(pArray, min, pMax);
		}
	}
	
}