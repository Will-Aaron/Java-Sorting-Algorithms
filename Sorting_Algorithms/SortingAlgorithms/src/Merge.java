
public class Merge extends SortForm {
	
	private static Comparable[] aux;// extra array for mergers
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a,aux,0,a.length-1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return; //in recursive call, if increments past singelton arrays, returns back
		int mid = lo + (hi-lo)/2;
		sort(a,aux,lo,mid); //Sorts left half of array
		sort(a,aux,mid+1,hi);//Sorts right half of array
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

}
