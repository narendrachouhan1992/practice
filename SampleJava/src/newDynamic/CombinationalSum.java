package newDynamic;

import java.util.List;

public class CombinationalSum {
	void printSol(int[] arr, int sum, int[] sol, int index)
	{
		if(sum == 0)
		{
			for(int i=0;i<index;i++)
			{
				System.out.print(sol[i]+" ");
			}
			System.out.println();
			return;
		}
		else if(sum>0)
		{
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]<=sum)
				{
					sol[index] = arr[i];
					printSol(arr, sum-arr[i], sol, index+1);
				}
			}
		}
		else
		{
			return;
		}
	}
	public static void main(String[] args) {
		CombinationalSum obj = new CombinationalSum();
		int[] arr = {2,4,6,8, 10};
		int[] sol = new int[20];
		obj.printSol(arr, 10, sol, 0);
	}
}
