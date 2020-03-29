package newDynamic;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEqualNumberOf0sAnd1s {
	void getMaxLength(int[] arr)
	{   
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max_length = 0;
		int endingIndex = 0;
		for(int i =0;i<arr.length;i++)
		{
			arr[i] = arr[i] == 0? -1:1;
		}
		for(int i =0;i<arr.length;i++)
		{
			sum+= arr[i];
			if(sum == 0)
			{
				max_length = i+1;
				endingIndex = i;
				
				
			}
			if(map.containsKey(sum))
			{
				if(max_length< i-map.get(sum))
				{
					max_length = i-map.get(sum);
					endingIndex = i;
				}
			}
			else
			{
				map.put(sum, i);
			}
		}
		int start = endingIndex-max_length+1;
		System.out.println("from index "+ start +" to "+ endingIndex);
	}
	public static void main(String[] args) {
		LargestSubarrayWithEqualNumberOf0sAnd1s obj = new LargestSubarrayWithEqualNumberOf0sAnd1s();
		int arr[] = {1, 0, 0, 1, 0, 1, 1};
		obj.getMaxLength(arr);
	}
}
