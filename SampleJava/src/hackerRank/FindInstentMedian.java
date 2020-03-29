package hackerRank;

import java.util.Scanner;

public class FindInstentMedian {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 10;
        int[] a = new int[n];
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int a_i=0; a_i < n; a_i++){
            a = sort(a, a_i, input[a_i]);
            if(a_i%2==1)
            {
            	int median_1 = a_i/2;
            	int median_2 = a_i/2+1;
            	float ans = (a[median_1]+a[median_2]);
            	ans = ans/2;
            	System.out.println(ans);
            } else
            {
            	float ans = a[a_i/2];
            	System.out.println(ans);
            }
        }
    }
	static int[] sort(int[] arr, int length, int num)
	{
		if(length == 0)
		{
			arr[0] = num;
			return arr;
		}
		int i = 0;
		for(i=0;i<length;i++)
		{
			if(arr[i]>num)
			{
				break;
			}
		}
		for(int j=length-1;j>=i;j++)
		{
			arr[j+1] = arr[j];
		}
		arr[i] = num;
		return arr;
	}
}
