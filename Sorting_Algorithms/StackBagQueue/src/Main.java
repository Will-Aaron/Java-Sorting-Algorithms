
public class Main {

	public static void main(String[] args) {
		System.out.println("Test");
		
		produce_queue();
	}
	public static void produce_stack() {
		
		int[] allowlist = new int[] {1, 2, 3};
		
		Stack<Integer> mystack;
		
		mystack = new Stack<Integer>();
		
		for(int allows : allowlist) {
			mystack.push(allows);
		}
		
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		
		for(int i : mystack) {
			System.out.println(i); // not using POP TODO
		}
		
	}
	public static void produce_bag() {
		int[] allowlist = new int[] {1,2,3};
		
		Bag<Integer> mybag;
		mybag = new Bag<Integer>();
		for (int allows : allowlist) {
			mybag.add(allows);	
		}
		
		for(int i: mybag) {
			System.out.println(i);
		}
	}
	public static void produce_queue() {
		int[] allowlist = new int[] {31,25,23,97};
		
		Queue<Integer> myqueue;
		myqueue = new Queue<Integer>();
		for (int allows : allowlist) {
			myqueue.enqueue(allows);	
		}
		
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.size());
		myqueue.enqueue(66);
		
		for(int i : myqueue) {
			System.out.println(i);
		}
	}
}
