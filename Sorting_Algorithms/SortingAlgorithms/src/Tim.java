
public class Tim extends SortForm{
	//Combination of Merge Sort and Insertion Sort
	private static Comparable[] aux;// extra array for mergers
	
	private static final int MAX_RUN = 64; 
	
	public static void sort(Comparable[] a) {
		//Runs MergeSort until partitions are small enough to be effectively run with Insertion Sort
		aux = new Comparable[a.length];
		int run = getRun(a.length);
		sort(a,aux,run,0,a.length-1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int run, int lo, int hi) {
		
		if(hi <= lo + run) {//In recursive call, once int lo and int hi become a close enough partition, sorts by insertion then returns
			sortIN(a,lo,hi);
			return;
		}
		
		int mid = lo + (hi-lo)/2;
		sort(a,aux,run,lo,mid); //Sorts left half of array
		sort(a,aux,run,mid+1,hi);//Sorts right half of array
		merge(a,aux,lo,mid,hi); //With sorted sub-arrays, now merges results
	}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		
		assert isSorted(a,lo,mid);
		assert isSorted(a,mid+1,hi);
		
		if (less(a[mid],a[mid+1])) return;// Check for if two sub-arrays are already sorted w.r.t each other, i.e. can just append left and right
		
		int i = lo; int j = mid+1;//Increments along two sub-arrays and takes least element, sorting along the way
		
		for(int k = lo; k <= hi; k++) {//Copy array to auxiliary array
			aux[k] = a[k];
		}
		
		for(int m = lo; m <= hi; m++) {
			if (i > mid) 					a[m] = aux[j++];//If all left hand entries of array are used up, then take from right
			else if (j > hi)				a[m] = aux[i++];//If all right hand entries of array are used up, then take from left
			else if (less(aux[j],aux[i])) 	a[m] = aux[j++];
			else 							a[m] = aux[i++];
		}
		assert isSorted(a,lo,hi);
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
	
	public static int getRun(int n) {//Calculates the size of the run before merge sort switches to insertion sort.
		assert n >= 0;
	       
        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MAX_RUN)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n+r;
	}
}
