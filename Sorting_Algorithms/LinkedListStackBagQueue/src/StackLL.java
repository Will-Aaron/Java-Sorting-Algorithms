import java.util.Iterator;

public class StackLL<Item> implements Iterable<Item>{

	private Node top; //Top of stack, most recently defined Node
	private int N; // Number of Items in Stack
	
	
	private class Node{
		//Nested class defining the node object, which we will use to contain not only our Items, but also reference to the next ordered Item.
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return top == null;}//Could also test for N == 0
	public int size() {return N;}
	
	public void push(Item item) {
		//Add's items to the stack
		Node oldTop = top; //We must interchange the top of the stack with a new top, and push down the old top.
		top = new Node();
		top.item = item;
		top.next = oldTop;
		N++;
	}
	
	public Item pop() {
		//Returns top item in the stack and removes it from the stack
		Item item = top.item;
		top = top.next;
		N--;
		return item;
		
	}
	public Iterator<Item> iterator() {
		//private class detailing how to iterate
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		
		private Node current = top;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
}
