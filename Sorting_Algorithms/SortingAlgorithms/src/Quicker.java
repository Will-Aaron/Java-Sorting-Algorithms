import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Quicker extends SortForm{
	//Incorporates certain algorithmic improvements of basic Quicksort such as switching to insertion sort and 
	
	private static final int CUTOFF = 3;//Cutoff for Insertion Sort, chosen rather arbitrarily.

	public static void sort(Comparable[] a) {
		//shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo + CUTOFF) {
			sortIN(a,lo,hi);
			return;//Ends recursive call if end points of our partitioning 
		}
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo; int j = hi+1;// scan indices for left and right partitions
		int medIndex = findMedian(a,lo,hi); //partitioning pivot index
		Comparable v = a[medIndex];
		while (true) {
			while (less(a[++i],v)) {//While loop to find entry left of pivot which is larger
				if (i==hi) break;//Break if all entries are smaller
			}
			while (less(v,a[--j])) {//While loop to find entry right of pivot which is smaller
				if (j==lo) break;
			}
			if (i >= j) break;
			exch(a,i,j);
		}
		exch(a,medIndex,j);
		System.out.println("lo: " + lo + " hi: " + hi + " med: " + v);
		show(a);
		return j;
	}
	
	private static void sortIN(Comparable[] a, int lo, int hi) {//Sub Insertion Sort
		//Sorts array a into increasing order
		for (int i = lo + 1; i <=  hi; i++) {
			//Sorting by placing element a[i] into it's correct place among a[0,...,i-1]
			for ( int j = i; j > lo && less(a[j],a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
		assert isSorted(a,lo,hi);
	}
	
	private static void shuffle(Comparable[] a) {
		Random rand = ThreadLocalRandom.current();//create current thread's ThreadLocalRandom
		//Iterate from end to beginning of the array, exchanging entries with randomly chosen entries from earlier in the array
		for (int i = a.length-1; i>0; i--) {
			int indexSwap = rand.nextInt(i+1);//performing nextInt(i+1) to allow option for entry to swap with itself, meaning no change
			if (indexSwap != i) {//Will only exchange if they are different, otherwise unnecessary
				exch(a,i,indexSwap);
			}
		}
		
	}
	
	public static int findMedian(Comparable[] a, int lo, int hi) {//Find median by performing three exchanges which correct the ordering of lo,mid,hi and then chose the middle element
		int mid = lo + (hi-lo)/2;
		if (less(a[mid],a[lo])) {
			exch(a,lo,mid);
		}
		if (less(a[hi],a[lo])) {
			exch(a,lo,hi);
		}
		if (less(a[hi],a[mid])) {
			exch(a,hi,mid);
		}
		return mid;
	}
}
