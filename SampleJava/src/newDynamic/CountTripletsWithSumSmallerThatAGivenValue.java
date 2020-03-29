package newDynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountTripletsWithSumSmallerThatAGivenValue {
	int getTriplet(int[] arr, int sum)
	{
		int res = 0;
		int size = arr.length;	
		Arrays.sort(arr);
		for(int i=0;i<size-2;i++)
		{
			int j = i+1;
			int k = size-1;
			while(j<k)
			{
				if(arr[i]+arr[j]+ arr[k]>=sum)
				{
					k--;
				} 
				else
				{
					res+= (k-j);
					j++;
				}
			}
		}
		return res; 
	}
	public static void main(String[] args) {
		CountTripletsWithSumSmallerThatAGivenValue obj = new CountTripletsWithSumSmallerThatAGivenValue();
		int sum = 12;
		int[] arr = {5, 1, 3, 4, 7};
		System.out.println(obj.getTriplet(arr, sum));
		
	}
}
