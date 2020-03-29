package newDynamic;

import java.util.Arrays;

public class FindPythagoreanTripletInAnUnsortedArray {
	void printThereTriplet(int[] arr)
	{
		int length = arr.length;
		for(int i=0;i<length;i++)
		{
			arr[i] = arr[i]*arr[i];
		}
		Arrays.sort(arr);
		for(int i =length-1;i>=2;i--)
		{
			int s = 0;
			int e = i-1;
			while(s<e)
			{
				if(arr[s]+arr[e] == arr[i])
				{
					System.out.println(arr[i] +" "+ arr[s]+" "+arr[e]);
					e--;
					s++;
				}	
				else if(arr[s]+arr[e] < arr[i])
					s++;
				else
				{
					e--;
				}
			}
		}
	}
	public static void main(String[] args) {
		FindPythagoreanTripletInAnUnsortedArray obj = new FindPythagoreanTripletInAnUnsortedArray();
		int arr[] = {3, 1, 4, 6, 5};
		obj.printThereTriplet(arr);
		
	}
}
