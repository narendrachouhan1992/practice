package newDynamic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class FindTheNearestSmallerNumbersOnLeftSideInAnArray {
	int[] getNearestSmaller(int[] arr)
	{
		Stack<Integer> st = new Stack<Integer>();
		int size = arr.length;
		int[] sol = new int[size];
		for(int i=0;i<size;i++)
		{
			while(!st.isEmpty() && st.peek() >= arr[i])
				st.pop();
			if(st.isEmpty())
				sol[i] = -1;
			else
				sol[i] = st.peek();
			st.push(arr[i]);
		}
		return sol; 
	}
	public static void main(String[] args) {
		FindTheNearestSmallerNumbersOnLeftSideInAnArray obj = new FindTheNearestSmallerNumbersOnLeftSideInAnArray();
		int[] arr = {1,3, 0, 2, 5};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(obj.getNearestSmaller(arr)));
	}
}
