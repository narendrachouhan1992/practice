package hackerRank;

import java.util.Scanner;

public class PlusMinus {
	static float[] getResult(int[] arr)
	{
		int size = arr.length;
		int positive=0;
		int negetive=0;
		int zero=0;
		float[] res = new float[3];
		for(int i=0;i<size;i++)
		{
			if(arr[i]>0)
				positive++;
			else if (arr[i]<0)
				negetive++;
			else
				zero++;
		}
		res[0] = positive;
		res[0] /=size;
		res[1] = negetive;
		res[1] /=size;
		res[2] = zero;
		res[2] /=size;
		return res;
	}
	 public static void main(String[] args) {
	        int arr[] = {-4, 3, -9, 0, 4, 1};
	       
	        float[] res = getResult(arr);
	        System.out.println(res[0]);
	        System.out.println(res[1]);
	        System.out.println(res[2]);
	    }
}
