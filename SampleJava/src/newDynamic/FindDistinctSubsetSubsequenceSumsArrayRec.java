package newDynamic;

import java.util.HashSet;
import java.util.Set;

public class FindDistinctSubsetSubsequenceSumsArrayRec {
	void printAllSum(int[] arr, int curr, int sum, Set<Integer> set)
	{
		if(curr==arr.length)
		{
			set.add(sum);
			return ;
		}
		printAllSum(arr, curr+1, sum+arr[curr], set);
		printAllSum(arr, curr+1, sum, set);
	}
	void print(int[] arr)
	{
		Set<Integer> set = new HashSet<Integer>();
		printAllSum(arr, 0, 0, set);
		for (Integer num : set) {
			System.out.println(num);
		}
	}
	public static void main(String[] args) {
		FindDistinctSubsetSubsequenceSumsArrayRec obj = new FindDistinctSubsetSubsequenceSumsArrayRec();
		int[] arr = {2, 3, 4, 5, 6};
		obj.print(arr);
	}
}
