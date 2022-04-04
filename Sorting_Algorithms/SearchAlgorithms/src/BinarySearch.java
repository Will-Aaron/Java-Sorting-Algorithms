
public class BinarySearch {

	public static int steps = 0;
	public static int rank(Integer key, Integer[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			steps++;
			int mid = lo + (hi - lo)/2;
			if (key < a[mid]) hi = mid-1;
			else if (key > a[mid]) lo = mid+1;
			else return mid;
		}
		return -1; //By convention, if the search doesn't find the entry, it returns -1
	}
	
	public static int rankRecursive(Integer key, Integer[] a, int lo, int hi) {
		steps++;
		if(lo <= hi) {
			int mid = lo + (hi-lo)/2;
			if ( key < a[mid]) return rankRecursive(key,a,lo,mid-1);
			else if (key > a[mid]) return rankRecursive(key,a,mid+1,hi);
			else return mid;
		}
		return -1;
	}
}
