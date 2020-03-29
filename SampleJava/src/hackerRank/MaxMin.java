package hackerRank;

import java.util.Scanner;

public class MaxMin {
	static void printMaxMin(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<5;i++)
        {
        	if(arr[i]<min)
        		min = arr[i];
        	if(arr[i]>max)
        		max = arr[i];
        	sum+= arr[i];
        }
        System.out.println((sum-max)+" "+(sum-min));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        printMaxMin(arr);
    }
}
