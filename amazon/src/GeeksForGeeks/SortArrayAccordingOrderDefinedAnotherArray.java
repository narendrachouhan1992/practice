package GeeksForGeeks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortArrayAccordingOrderDefinedAnotherArray {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static Comparator<Integer> c = (o1, o2)-> {
			boolean a = map.containsKey(o1);
			boolean b = map.containsKey(o2);
			
			if(a&& b)
				return map.get(o1)- map.get(o2);
			else if(a || b)
			{
				return a?-1:1;
					
			}
			return (o1-o2);
		};
	static void sort(Integer[] arr, int[] samp)
	{
		for(int i=0;i<samp.length;i++)
		{
			map.put(samp[i], i);
		}
		Arrays.sort(arr, c);
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		Integer A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 }; 
	    int A2[] = { 2, 1, 8, 3 }; 
	    sort(A1, A2);
	}
}
