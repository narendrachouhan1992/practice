package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class ContinueouSubStringSumN {
	static int countSubSequence(List<Integer> inputSeq, int targetSum) {
		int count = 0;
		int currSum = 0;
		int initIndex = 0;
		int n = inputSeq.size();
		if(n==0)
			return 0;
		currSum = inputSeq.get(0);
		
		for(int i=1;i<n;i++)
		{
			while(currSum>targetSum && initIndex<i-1)
			{
				currSum-=inputSeq.get(initIndex++);
			}
			if(currSum==targetSum)
			{
				count++;
				currSum-=inputSeq.get(initIndex++);
			}
			
			if(currSum<targetSum)
			{
				currSum+=inputSeq.get(i);
			}
		}
		while(initIndex<n && currSum>targetSum)
		{
			currSum-=inputSeq.get(initIndex++);
		}
		if(currSum==targetSum)
			count++;
		return count;
    }
	static int countSubSequence2(List<Integer> inputSeq, int targetSum) {
		int count = 0;
		int currSum = 0;
		int initIndex = 0;
		int n = inputSeq.size();
		if(n==0)
			return 0;
		currSum = inputSeq.get(0);
		int i =1;
		while(i<n)
		{
			if(currSum==targetSum)
				count++;
			if(currSum>=targetSum)
			{
				currSum-=inputSeq.get(initIndex++);
			}
			if(currSum<targetSum)
			{
				currSum+=inputSeq.get(i++);
			}
		}
		while(initIndex<n && currSum>targetSum)
		{
			currSum-=inputSeq.get(initIndex++);
		}
		if(currSum==targetSum)
			count++;
		
		return count;
    }
	static int countSubSequence1(List<Integer> inputSeq, int targetSum) {
		int curr_sum = inputSeq.get(0), start = 0, i; 
		  int n = inputSeq.size();
	        // Pick a starting point 
	        for (i = 1; i <= n; i++)  
	        { 
	            // If curr_sum exceeds the sum, then remove the starting elements 
	            while (curr_sum > targetSum && start < i-1) 
	            { 
	                curr_sum = curr_sum - inputSeq.get(start); 
	                start++; 
	            } 
	              
	            // If curr_sum becomes equal to sum, then return true 
	            if (curr_sum == targetSum)  
	            { 
	                int p = i-1; 
	                System.out.println("Sum found between indexes " + start 
	                        + " and " + p); 
	                return 1; 
	            } 
	              
	            // Add this element to curr_sum 
	            if (i < n) 
	            curr_sum = curr_sum + inputSeq.get(i); 
	              
	        } 
	  
	        System.out.println("No subarray found"); 
	        return 0; 
    }
	
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(6);
		l.add(6);
		l.add(6);
		l.add(6);
		l.add(6);
		
		System.out.println(countSubSequence(l, 12));
	}
}
