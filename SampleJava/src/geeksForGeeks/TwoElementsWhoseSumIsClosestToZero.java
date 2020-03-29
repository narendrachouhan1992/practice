package geeksForGeeks;

import java.util.Arrays;

public class TwoElementsWhoseSumIsClosestToZero {
	void printElements(int[] arr)
	{
		Arrays.sort(arr);
		int n = arr.length;
		int sol = Integer.MAX_VALUE;
		int l=0;
		int r = n-1;
		int currSol;
		while(l!=r)
		{
			currSol=arr[l]+arr[r];
			if(Math.abs(currSol)<sol)
				sol=Math.abs(currSol);
			if(currSol==0)
			{
				System.out.println(0);
				return;
			}
			if(currSol>0)
			{
				r--;
			}
			else
				l++;
		}
		System.out.println(sol);
	}
	public static void main(String[] args) {
		int arr[] = {1, 60, -10, 70, -80, 85}; 
		TwoElementsWhoseSumIsClosestToZero obj = new TwoElementsWhoseSumIsClosestToZero();
		obj.printElements(arr);
	}
}
