package restchef.sortalgorithms;

public class ArrayBubbleSort<T extends Comparable<T>> {

	public void order(T[] unsorted) {
    	
        for(int size = unsorted.length,indexSize = unsorted.length-1; size > 1 ; size-- , indexSize--) {
            for(int index = 0; index < indexSize; index ++) {
                if((unsorted[index]).compareTo(unsorted[index+1]) > 0) {
                    T tmp = unsorted[index];
                    unsorted[index] = unsorted[index + 1];
                    unsorted[index + 1] = tmp;
                }                
            }
        }
    }   
	
}