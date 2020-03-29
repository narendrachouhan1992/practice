package interview;

import java.util.Arrays;

public class SubArrayLnegth {
	static long[] Solve(long K, long[] arr, int n) {
        // // write code here
		long[] sol = new long[n];
		for(int i=0;i<n;i++)
		{
			int currSum = 0;
			int end = 0;
			while(end != i+1)
			{
				currSum += arr[end++];
			}
			int start = 0;
			while(end!= n)
			{
				if(currSum<= K)
				{
					sol[i]++;
				}
				currSum += arr[end++];
				currSum -= arr[start++];
			}
			if(currSum<= K)
			{
				sol[i]++;
			}
		}
			
		return sol;
    }
	public static void main(String[] args) {
		long[] in = {2, 1, 3, 4};
		int k = 12;
		System.out.println(Arrays.toString(Solve(12, in, 4)));
	}
}
