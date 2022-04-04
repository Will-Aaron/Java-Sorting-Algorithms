import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		if (N == a.length){
			resize(2*a.length);
		}
		a[N++] = item;
	}
	

	public Item dequeue() {
		Item item = a[0];
		for (int i = 1; i < N; i++) {
			a[i-1] = a[i];
		}
		a[--N] = null;
		if (N > 0 && N == a.length / 4) {
			resize(a.length/2);
		}
		return item;
	}
	
	public void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {
		private int i = 0;
		
		@Override
		public boolean hasNext() {
			return i < N;
		}

		@Override
		public Item next() {
			return a[i++];
		}
		
	}

}
