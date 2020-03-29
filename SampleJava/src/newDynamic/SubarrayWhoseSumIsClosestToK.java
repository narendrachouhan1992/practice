package newDynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SubarrayWhoseSumIsClosestToK {
	static class PrefixSum implements Comparable<PrefixSum>
	{
		int sum;
		int index;
		public PrefixSum(int sum, int index) {
			this.sum = sum;
			this.index = index;
		}
		@Override
		public int compareTo(PrefixSum arg0) {
			if(this.sum>arg0.sum)
				return 1;
			return -1;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String s = "[ index: "+this.index + ", sum: "+this.sum+" ]"; 
			return s;
		}
	}
	void printSubArrayWithSumCloseToZero(int[] arr, int k)
	{
		int length = arr.length;
		PrefixSum[] list = new PrefixSum[length+1];
		
		list[0] = new PrefixSum(k, -1);
		for(int i=1;i<=length;i++)
		{
			list[i] = new PrefixSum(list[i-1].sum+arr[i-1], i-1);
		}
		System.out.println(Arrays.toString(list));
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));
		int minDiff = Integer.MAX_VALUE;
		int indexA = 0;
		int indexB = 1;
		for(int i=0;i<length;i++)
		{
			if((Math.abs(list[i].sum-list[i+1].sum-k))<minDiff)
			{
				minDiff = Math.abs(list[i].sum-list[i+1].sum -k);
				indexA = list[i].index;
				indexB = list[i+1].index;
			}
		}
		System.out.println("sum : "+ minDiff);
		if(indexA>indexB)
		{
			for(int i=indexB+1;i<=indexA;i++)
			{
				System.out.print(arr[i]+ " ");
			}
		} 
		else
		{
			for(int i=indexA+1;i<=indexB;i++)
			{
				System.out.print(arr[i]+ " ");
			}
		}
		
	}
	public static void main(String[] args) {
		SubarrayWhoseSumIsClosestToK obj = new SubarrayWhoseSumIsClosestToK();
		int[] arr ={ -5, 12, -3, 4, -15, 6, 1 };
		int k=2;
		obj.printSubArrayWithSumCloseToZero(arr,  k);
	}
}