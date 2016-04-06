import java.util.*;
public class Solution_twoSum {
	public int[] twoSum(int[] numbers, int target) {
		// write your code here
		if(numbers == null || numbers.length < 2) {
			return null;
			}
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++){
			hs.put(numbers[i], i+1);
			}       
		
		int[] a = new int[2];
		
		for(int i=0; i<numbers.length ; i++){
			if ( hs.containsKey( target - numbers[i] )){
				int index1 = i+1;
				System.out.printf("first ind %d ", index1);
				int index2 = hs.get(target - numbers[i]);
				System.out.printf("second ind %d ", index2);
				if (index1 == index2){
					continue;
					}
				a[0] = index1;
				a[1] = index2;
				return a;
				}
			}
		return a;
    }
}
