package HackerRank.greedy;

import java.util.Arrays;

public class GreedyFlorist {
	static int getMinimumCost(int k, int[] c) {
		Arrays.sort(c);
		int cost = 0;
		int i=c.length-1;
		int mult = 1;
		int initK = k;
		while(i>=0)
		{
			k = initK;
			while(i>=0 && k>0)
			{
				cost+=(c[i--]*mult);
				k--;
			}
			mult++;
				
		}
		return cost;
	}
	public static void main(String[] args) {
		
	}
}
