package hackerRank;

import java.util.Arrays;

public class LeftRotation {
	static int[] leftRotate(int[] arr, int d)
	{
		int n = arr.length;
		int[] out = new int[n];
		for(int i=0;i<n;i++)
		{
			out[i] = arr[(i+d)%n];
		}
		return out;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(Arrays.toString(leftRotate(arr, 4)));
	}
}
