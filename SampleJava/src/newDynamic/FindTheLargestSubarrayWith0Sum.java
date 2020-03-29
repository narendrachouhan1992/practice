package newDynamic;

import java.util.HashMap;
import java.util.Map;

public class FindTheLargestSubarrayWith0Sum {
	int getMaxLen(int[] arr)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max_len = 0;
		int sum = 0;
		for(int i = 0;i<arr.length;i++)
		{
			sum+= arr[i];
			if(arr[i] == 0 && max_len== 0)
			{
				max_len = 1;
			}
			if(sum == 0)
			{
				max_len = i+1;
			}
			
			Integer pre_ind = map.get(sum);
			if(pre_ind != null)
			{
				max_len = Integer.max(max_len, i-pre_ind);
			}
			else
			{
				map.put(sum, i);
			}
		}
		return max_len;
	}
	public static void main(String[] args) {
		FindTheLargestSubarrayWith0Sum obj = new FindTheLargestSubarrayWith0Sum();
		 int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		System.out.println(obj.getMaxLen(arr));
	}
}
