
public class SortForm {

	protected static boolean less(Comparable v, Comparable w) {
		//Returns true if the first argument is less than the second argument, otherwise false.
		return v.compareTo(w) < 0;//By convention, implementation of compareTo for a Comparable data type must return a signed number to to indicate ordering
	}
	
	protected static boolean lessEqual(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0 || v.compareTo(w) == 0);
	}
	protected static void exch(Comparable[] a, int i, int j) {//Exchange entries for 
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i],a[i-1])) return false;
		}
		return true;
	}
	
	protected static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (less(a[i],a[i-1])) return false;
		}
		return true;
	}

	protected static void show(Comparable[] a) {//Prints out array on one line for demonstration purposes. Use on Large Array's is less helpful
		for (Comparable i: a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	
}
