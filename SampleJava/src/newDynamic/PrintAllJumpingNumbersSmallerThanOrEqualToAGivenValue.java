package newDynamic;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAllJumpingNumbersSmallerThanOrEqualToAGivenValue {
	void print(int x,int k)
	{
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		while(!q.isEmpty())
		{
			int num = q.poll();
			if(num<k)
			{	
				System.out.print(num+ " ");
				int lastDigit = num%10;
				if(lastDigit == 0)
				{
					q.add(num*10 + 1);
				}
				else if(lastDigit == 9)
				{
					q.add(num*10 + 8);
				}
				else
				{
					q.add(num*10 + lastDigit+1);
					q.add(num*10 + lastDigit-1);
				}
			}
		}
	}
	void printAll(int k)
	{
		System.out.print(0+" ");
		for(int i=1;i<10;i++)
		{
			print(i, k);
		}
	}
	public static void main(String[] args) {
		PrintAllJumpingNumbersSmallerThanOrEqualToAGivenValue obj = new PrintAllJumpingNumbersSmallerThanOrEqualToAGivenValue();
		obj.printAll(40);
	}
}
