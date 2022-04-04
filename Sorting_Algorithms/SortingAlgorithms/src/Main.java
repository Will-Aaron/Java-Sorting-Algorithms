import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		//Integer[] intList = {4,7,7,2,8,46,9};
		//String[] stringList = {"ab","ef","gh","cd"};
		//Merge.sort(intList);
		//Merge.show(intList);
		//Merge.sort(stringList);
		//Merge.show(stringList);
		
		// Note: you can use this with the following:
		//int[] allowlist = IntStream.generate(() -> 
		//new Random().nextInt(100)).limit(30).toArray();
				
		// KEY: convert int[] to Integer[]
		//Integer[] list = Arrays.stream( allowlist ).boxed().toArray( Integer[]::new );
		
		//Quicker.sort(list);
		//System.out.println(SortForm.isSorted(list));
		//SortForm.show(list);
		
		//System.out.println(Quicker.findMedian(intList,0,2));
		
		//Integer x = 5;
		//Integer y = 5;
		//System.out.println(x.compareTo(y));
		
		//Random rand = new Random();
		//List<Date> dateList = new ArrayList<Date>();
		//int N =100;
		//for (int i = 0; i < N; i++) {
			//dateList.add(new Date(rand.nextInt(2022)+1,rand.nextInt(12)+1,rand.nextInt(28)+1));
		//}
		
		
		//System.out.println(dateList.size());
		//Quick.sort(dateList);
		Date x = new Date(2005,11,11);
		Date y = new Date(1967,12,3);
		Date z = new Date(2005,10,17);
		Date w = new Date(1967,12,5);
		Date[] dateList = {x,y,z,w};
		
		Quick.sort(dateList);
		System.out.println(Quick.isSorted(dateList));
		for (int i = 0; i < 4; i++) {
			System.out.println(dateList[i].toString());
		}
		
		
	}
}
