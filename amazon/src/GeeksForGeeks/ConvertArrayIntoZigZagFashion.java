package GeeksForGeeks;

import java.util.Arrays;
import java.util.Collection;

public class ConvertArrayIntoZigZagFashion {
	int[] getZigZag(int[] arr)
	{
		
		boolean flag = true;
		int n = arr.length;
		for(int i=0;i<n-2;i++)
		{
			if(flag)
			{
				if(arr[i]>arr[i+1])
				{
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]=temp;
				}
			}
			else
			{
				if(arr[i]<arr[i+1])
				{
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]=temp;
				}
			}
			flag = !flag;
		}
		return arr;
	}
	public static void main(String[] args) {
		int  arr[] = {4, 3, 7, 8, 6, 2, 1}; 
		ConvertArrayIntoZigZagFashion obj = new ConvertArrayIntoZigZagFashion();
		System.out.println(Arrays.toString(obj.getZigZag(arr)));
	}
}
