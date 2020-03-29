package hackerRank;

import java.util.Scanner;

public class HashStaircases {
	static void getRes(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0; j < n-i-1;j++)
			{
				System.out.print(" ");
			}
			for(int j=0; j <= i;j++)
			{
				System.out.print("#");
			}
			if(i!=n-1)
			{
				System.out.println();
			}
		}
	}
		public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        getRes(n);
	        
	    }
}
