package GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class TopKEkelement {
	static int find(int[] arr, int ele) 
    { 
           for (int i = 0; i < arr.length; i++) 
                if (arr[i] == ele) 
                    return i; 
           return -1; 
    } 
	static void printTopK(int[] arr, int k)
	{
		int[] top = new int[k+1];
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		freq.put(0, 0);
		for(int i=0;i<arr.length;i++)
		{
			int num = arr[i];
			if(freq.containsKey(num))
			{
				freq.put(num, freq.get(num)+1);
				
			}
			else
				freq.put(arr[i], 1);
			
			top[k] = num;
			int j = find(top, top[k]);
			j--;
			while(j>=0)
			{
				if(freq.get(top[j])<freq.get(top[j+1]))
				{
					int temp = top[j];
					top[j] = top[j+1];
					top[j+1] = temp;
				}
				
				else if(freq.get(top[j])==freq.get(top[j+1]) && top[j]>top[j+1])
				{
					int temp = top[j];
					top[j] = top[j+1];
					top[j+1] = temp;
				}
				else 
				{
					break;
				}
			 j--;
			}
			for(int x =0;x<k && top[x]!=0;x++)
				System.out.print(top[x]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[] arr = {5,2,1,3,2};
		printTopK(arr, 4);
	}
}
