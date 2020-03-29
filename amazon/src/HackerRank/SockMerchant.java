package HackerRank;

import java.util.HashSet;
import java.util.Set;

public class SockMerchant {
	static int sockMerchant(int n, int[] ar) {
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		for(int i=0;i<n;i++)
		{
			if(set.contains(ar[i]))
			{
				count++;
				set.remove(ar[i]);
			}
			else
			{
				set.add(ar[i]);
			}
		}
		return count;
    }
}
