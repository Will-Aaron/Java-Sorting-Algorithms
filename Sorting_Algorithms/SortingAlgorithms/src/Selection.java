
public class Selection extends SortForm{

	public static void sort(Comparable[] a) {
	//Sorts array a into increasing order
		int N = a.length;
		for (int i = 0; i < N; i++) {
			//Exchanges entries of a[i] with the minimum of a[i+1,...,N]
			int min = i;
			for (int j = i+1; j < N; j++) {
				if (less(a[j],a[min])) min = j;
			}
			exch(a,i,min);
		}
	}
	
	public static void sortR(Comparable[] a) {
		//Sorts array a into decreasing order
			int N = a.length;
			for (int i = 0; i < N; i++) {
				//Exchanges entries of a[i] with the maximum of a[i+1,...,N]
				int max = i;
				for (int j = i+1; j < N; j++) {
					if (less(a[max],a[j])) max = j;
				}
				exch(a,i,max);
			}
		}
	
	
}
