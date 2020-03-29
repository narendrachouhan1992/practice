package newDynamic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PerfectSumProblemPrintSubsetsGivenSum {
	void printAllSubset(int[] arr, int sum)
	{
		List<Integer> ls = new ArrayList<Integer>(); 
		printUntill(arr, arr.length-1, sum, ls);
	}
	void printUntill(int[] arr, int n, int sum, List<Integer> ls)
	{
		if(n<0)
			return;
		
		if(sum == 0)
		{
			for (Integer i : ls) {
				System.out.print(i+", ");
			}
			System.out.println();
		}
		else
		{
			printUntill(arr, n-1, sum, ls);
			if(arr[n]<sum)
			{
				List<Integer> ls1 = new ArrayList<Integer>(ls);
				ls1.add(arr[n]);
				printUntill(arr, n-1, sum-arr[n], ls1);
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5};
		int sum = 10;
		PerfectSumProblemPrintSubsetsGivenSum obj = new PerfectSumProblemPrintSubsetsGivenSum();
		obj.printAllSubset(arr, sum);
	}
	
}
