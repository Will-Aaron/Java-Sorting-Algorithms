
public class LinearSearch{

	public static int steps = 0;
	
	public static <T> int rank(Comparable key, Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			steps++;
			if (a[i].compareTo(key)==0) {
				return i;
			}
		}
		return -1;//By convention, returns -1 if the key is not found
	}

	
}
