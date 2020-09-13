package HackerRank.Sort;

import java.util.Arrays;

public class MarkAndToy {
	
	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			if(k>prices[i])
			{
				k-=prices[i];
				res++;
			}
			else
				break;
		}
		return res;
    }
	public static void main(String[] args) {
		int[] i = {1 ,12, 5, 111, 200, 1000, 10};
		maximumToys(i, 5);
	}
}
