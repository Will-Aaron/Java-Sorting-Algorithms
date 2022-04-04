
public class Insertion extends SortForm {

	public static void sort(Comparable[] a) {
		//Sorts array a into increasing order
		int N = a.length;
		for (int i = 1; i <  N; i++) {
			//Sorting by placing element a[i] into it's correct place among a[0,...,i-1]
			for ( int j = i; j > 0 && less(a[j],a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
}
