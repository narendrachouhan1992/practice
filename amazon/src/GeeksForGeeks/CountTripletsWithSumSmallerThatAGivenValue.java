package GeeksForGeeks;

import java.util.Arrays;

public class CountTripletsWithSumSmallerThatAGivenValue {
	static int getCount(int[] arr, int sum)
	{
		int size = arr.length;
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int count = 0;
		for(int i=0;i<size-2;i++)
		{
			 int j = i + 1, k = size - 1; 
			
			while(j<k)
			{
				if(arr[j]+arr[k]+arr[i]>=sum)
				{
					k--;
					
				}
				else
				{
					count+=(k-j);
					j++;
				}
				
			}
		}
		return count;
	}
	static int countTriplets(int[] arr, int sum) 
    { 
        // Sort input array 
        Arrays.sort(arr); 
       int n = arr.length;
        // Initialize result 
        int ans = 0; 
       
        // Every iteration of loop counts triplet with 
        // first element as arr[i]. 
        for (int i = 0; i < n - 2; i++) 
        { 
            // Initialize other two elements as corner elements 
            // of subarray arr[j+1..k] 
            int j = i + 1, k = n - 1; 
       
            // Use Meet in the Middle concept 
            while (j < k) 
            { 
                // If sum of current triplet is more or equal, 
                // move right corner to look for smaller values 
                if (arr[i] + arr[j] + arr[k] >= sum) 
                    k--; 
       
                // Else move left corner 
                else
                { 
                    // This is important. For current i and j, there 
                    // can be total k-j third elements. 
                    ans += (k - j); 
                    j++; 
                } 
            } 
        } 
        return ans; 
    }
	public static void main(String[] args) {
		int[] arr ={5, 1, 3, 4, 7};
		System.out.println(getCount(arr, 12));
		System.out.println(countTriplets(arr, 12));
	}
}
