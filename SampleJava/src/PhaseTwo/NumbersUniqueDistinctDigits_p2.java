package PhaseTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.prefs.BackingStoreException;

public class NumbersUniqueDistinctDigits_p2 {
	void printNum(int l, int r)
	{
		String curr="";
		for(int i=1;i<10;i++)
		{
			boolean[] hash = new boolean[10];
			hash[i]=true;
			printUntill(l,r,curr+i, hash);
		}
		
	}
	private void printUntill(int l, int r, String curr,  boolean[] hash)
	{
		int currNum = Integer.parseInt(curr);
		if(currNum<=r)
		{
			if(currNum>=l)
			{
				System.out.println(curr);
			}
			for(int i=0;i<10;i++)
			{
				if(!hash[i])
				{
					boolean[] hashN = hash.clone();
					hashN[i]=true;
					printUntill(l, r, curr+i, hashN);
				}
			}
		}
	}
	public static void main(String[] args) {
		NumbersUniqueDistinctDigits_p2 obj = new NumbersUniqueDistinctDigits_p2();
		obj.printNum(1, 20);
		solve(new int[5],new int[5], 5);
		solve(new int[10]);
	}
	
	static int solve(int[] water, int[] capacity, int n)
	{
		int[] bapacity = {1,3,5,78,9};
		Arrays.parallelSort(bapacity);
		System.out.println(Arrays.toString(bapacity));
		System.out.println();
		return 0;
	}
	static ArrayList<Integer>[] solve(int[] arr)
	{
		int numberOfDisks = arr.length;
		ArrayList[] res = new ArrayList[numberOfDisks];
		ArrayList<Integer>[] res1 = new ArrayList[5];
		Queue<Integer> q = new PriorityQueue<Integer>((Integer i, Integer j)->j.compareTo(i));
		int currLargest = numberOfDisks;
		
		for(int i=0;i<numberOfDisks;i++)
		{
			ArrayList<Integer> al = new ArrayList<Integer>();
			if(arr[i]== currLargest)
			{
				al.add(arr[i]);
				currLargest--;
				while (currLargest==q.peek())
				{
					al.add(q.poll());
					currLargest--;
				}
			}
			else
			{
				q.add(arr[i]);
			}
			res[i] = al;
		}

		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
