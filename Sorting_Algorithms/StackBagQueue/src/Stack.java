import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1]; // our stack items
	private int N = 0; //number of items
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {//adds an item to the stack
		if ( N == a.length)
			//If the size of the stack fills up our array "a" then we must create
			//more space with a resizing function
			resize( 2 *a.length);
		
		a[N++] = item;
	}

	public Item pop() {//remove item from top of stack
		Item item = a[--N]; //decreased N, then returned
		a[N] = null; // avoid loitering ( see text)
		if(N > 0 && N == a.length / 4) {//Helps determine when the array used in the stack is taking up too much space in memory
			resize(a.length/2);
		}
		return item;
	}
	//Resizing array is computationally expensive, want to call as little as possible
	private void resize(int max) {//Move stack to a new array of size max
		Item[] temp = (Item[]) new Object[max];
		
		for(int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	//this methods determines how we will iterate over the items in our stack
	public Iterator<Item> iterator() {
		//private class detailing how to iterate
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;
		@Override
		public boolean hasNext() {
			return i > 0;
		}
		@Override
		public Item next() {
			return a[--i];
		}
	}
	

}
