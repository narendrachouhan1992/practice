package GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class FindTheLargestSubarrayWith0Sum {
	String a;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FindTheLargestSubarrayWith0Sum other = (FindTheLargestSubarrayWith0Sum) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		return true;
	}
	static int printLargestSubarray(int[] arr)
	{ 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int maxLength = 0;
		int sum = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			int curr_sum = 0;
			
			if(arr[i]==0 && maxLength == 0)
				maxLength=1;
			if(sum==0)
				maxLength=i+1;
			Integer prev = map.get(sum);
				
			if(prev!=null)
				maxLength = Math.max(maxLength, i-prev);
			else
				map.put(sum, i);
		}
		return maxLength;
	}
}
