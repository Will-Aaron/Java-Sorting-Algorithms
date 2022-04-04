
public class Main {

	public static void main(String[] args) {
		
	
	StackLL<Integer> teststack = new StackLL<Integer>();
	
	
	teststack.push(3);
	teststack.push(4);
	teststack.push(5);
	System.out.println(teststack.size());
	for (Integer i : teststack) {
		System.out.println(i);
	}
	
	}
}
