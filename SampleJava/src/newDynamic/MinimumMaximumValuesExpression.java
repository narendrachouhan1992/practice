package newDynamic;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class MinimumMaximumValuesExpression {
	boolean isOperator(char op)
	{
	    return (op == '+' || op == '*');
	}
	void printMaxMin(String expression)
	{
		ArrayList<Character> op = new ArrayList<Character>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		String temp = "";
		int length = expression.length();
		for(int i=0;i<length;i++)
		{
			if(isOperator(expression.charAt(i)))
			{
				op.add(expression.charAt(i));
				num.add(Integer.parseInt(temp));
				temp = "";
			}
			else{
				temp+= expression.charAt(i);
			}
		}
		num.add(Integer.parseInt(temp));
		
		int len = num.size();
		int[][] minVal = new int[len][len];
		int[][] maxVal = new int[len][len];
		
		for(int i =0;i<len;i++)
			for(int j =0;j<len;j++)
			{
				minVal[i][j] = Integer.MAX_VALUE;
				maxVal[i][j] = 0;
				if(i==j)
				{
					minVal[i][j] = maxVal[i][j] = num.get(i);
				}
			}
		for(int L =2;L<=len;L++)
		{
			for(int i =0;i<len-L+1;i++)
			{
				int j = i+L-1;
				for(int k = i;k<j;k++)
				{
					int minTmp = 0;
					int maxTmp = 0;
					if(op.get(k) == '+')
					{
						minTmp = minVal[i][k]+ minVal[k+1][j];
						maxTmp = maxVal[i][k]+ maxVal[k+1][j];
					}
					else if(op.get(k) == '*')
					{
						minTmp = minVal[i][k]* minVal[k+1][j];
						maxTmp = maxVal[i][k]* maxVal[k+1][j];
					}
					
					if(minTmp<minVal[i][j])
					{
						minVal[i][j] = minTmp;
					}
					if(maxTmp>maxVal[i][j])
					{
						maxVal[i][j] = maxTmp;
					}
				}
			}
		}
		
		
		System.out.println("min is :"+ minVal[0][len-1]);
		System.out.println("max is :"+ maxVal[0][len-1]);
	}
	public static void main(String[] args) {
		String expression = "1+2*3+4*5";
		MinimumMaximumValuesExpression obj = new MinimumMaximumValuesExpression();
		obj.printMaxMin(expression);
	}
}
