package newDynamic;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
	int getLargestConsicutiveSequence(int[] arr)
	{
		Set<Integer> set = new HashSet<Integer>();
		int length = arr.length;
		int ans = 1;
		for(int i=0;i<length;i++)
		{
			set.add(arr[i]);
		}
		for(int i=0;i<length;i++)
		{
			if(!set.contains(arr[i]-1))
			{
				int j = arr[i];
				while(set.contains(j))
				{
					j++;
				}
				ans = Integer.max(ans, (j-arr[i]));
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int arr[] =  {1, 9, 3, 10, 4, 20, 2};
		LongestConsecutiveSubsequence obj = new LongestConsecutiveSubsequence();
		System.out.println(obj.getLargestConsicutiveSequence(arr));
	}
}
