package hackerRank;

import java.util.Arrays;

public class CoinChange {
	static int ways(int n, int[] coins) {
		 //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] table = new int[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<coins.length; i++)
            for (int j=coins[i]; j<=n; j++)
                table[j] += table[j-coins[i]];
 
        return table[n];
    }
	public static void main(String[] args) {
		int[] coins = {1,2,3};
		System.out.println(ways(4, coins));
	}
}
