package newDynamic;

import java.util.Arrays;
import java.util.Comparator;

public class GivenAnArrayOfNumbersArrangeTheNumbersToFormTheBiggestNumber {
	String getMaxNum(String[] arr)
	{
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				return s1.compareTo(s2)>0?-1:1;
			}
		});
		return String.join("", arr);
		
	}
	public static void main(String[] args) {
		GivenAnArrayOfNumbersArrangeTheNumbersToFormTheBiggestNumber obj = new GivenAnArrayOfNumbersArrangeTheNumbersToFormTheBiggestNumber();
		String[] arr= {"54", "546", "548", "60"};
		String[] arr2= {"34", "3", "98", "9", "76", "45", "4"};
		System.out.println(obj.getMaxNum(arr));
		System.out.println(obj.getMaxNum(arr2));
	}
	
}
