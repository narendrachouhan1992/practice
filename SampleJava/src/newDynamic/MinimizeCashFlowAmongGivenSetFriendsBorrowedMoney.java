package newDynamic;

import java.util.Arrays;

public class MinimizeCashFlowAmongGivenSetFriendsBorrowedMoney {
	int getMax(int[] balance)
	{
		int max = Integer.MIN_VALUE;
		int ind = -1;
		for(int i=0;i<balance.length;i++)
			if(max<balance[i])
			{
				max = balance[i];
				ind = i;
			}
		return ind;
	}
	int getMin(int[] balance)
	{
		int min = Integer.MAX_VALUE;
		int ind = -1;
		for(int i=0;i<balance.length;i++)
			if(min>balance[i])
			{
				min = balance[i];
				ind = i;
			}
		return ind;
	}
	void printMinimumCashFlowRec(int[] balance)
	{
		int maxInd = getMax(balance);
		int minInd = getMin(balance);
		if(balance[minInd] == balance[maxInd] && balance[maxInd] == 0)
			return;
		int transfered = Integer.min(-balance[minInd], balance[maxInd]);
		balance[minInd]+= transfered;
		balance[maxInd]-= transfered;
		System.out.println(minInd +" gives "+ transfered +" ammount to " + maxInd);
		printMinimumCashFlowRec(balance);
	}
	void printMinimumCashFlow(int[][] mat)
	{
		int[] balance = new int[mat.length];
		for(int i=0;i<mat.length;i++)
			for(int k = 0;k<mat.length;k++)
			{
				balance[i] += (mat[k][i]-mat[i][k]);
			}
		
		printMinimumCashFlowRec(balance);
	}
	public static void main(String[] args) {
		MinimizeCashFlowAmongGivenSetFriendsBorrowedMoney obj = new MinimizeCashFlowAmongGivenSetFriendsBorrowedMoney();
		int graph[][] = { {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0},};
		obj.printMinimumCashFlow(graph);
	}
}
