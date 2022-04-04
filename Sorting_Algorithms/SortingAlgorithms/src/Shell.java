
public class Shell extends SortForm{

	public static void sort(Comparable[] a) {
		//Sort array a[] into increasing order, similar to insertion sort
		int N = a.length;
		int h = 1;
		while (h < N/3) h = 3*h + 1;
		while (h >= 1) {
			//sorting array a[] by jumps of size h
			for  (int i = h; i < N; i++) {
				//Sort by placing element a[i] into it's correct place among a[i-h], a[i-2*h],...
				for (int j = i; j >= h && less(a[j],a[j-h]); j -= h) {
					exch(a,j,j-h);
				}
			}
			h = h/3;
		}
	}
}
