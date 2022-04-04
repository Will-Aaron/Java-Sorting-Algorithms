import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Quick extends SortForm{

	public static void sort(Comparable[] a) {
		shuffle(a); // Randomly shuffles array entries to use probabilistic properties of improving runtime.
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;//Ends recursive call if end points of our partitioning 
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo; int j = hi+1;// scan indices for left and right partitions
		Comparable v = a[lo]; //partitioning pivot
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
		exch(a,lo,j);
		return j;
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
}
