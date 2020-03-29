package newDynamic;

import java.util.HashSet;
import java.util.Set;

class Job implements Comparable<Job>
{
	int start;
	int end;
	int weight;
	public Job(int start, int end, int weight) {
		this.end = end;
		this.start = start;
		this.weight = weight;
	}
	public Job() {
	}
	@Override
	public int compareTo(Job compareJob) {

		int compareWeight = compareJob.weight;
		if(this.weight>=compareWeight)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
public class WeightedJobSchedulingDyn {
	int[] dp;
	int findLastNotConflicting(Job[] arr, int i)
	{
		for(int j = i-1;j>=0;j--)
		{
			if(arr[j].end<=arr[i].start)
			{
				return j;
			}
		}
		return -1;
	}
	int findMax(Job[] arr)
	{
		int size = arr.length;
		dp = new int[size];
		dp[0]= arr[0].weight;
		for(int i=1;i<size;i++)
		{
			int inc = arr[i].weight;
			int l = findLastNotConflicting(arr, i);
			if(l!=-1)
			{
				inc+=dp[l];
			}
			dp[i] = Integer.max(dp[i-1], inc);
		}
		
		return dp[size-1];
	}
	
	public static void main(String[] args) {
		Job[] arr = {new Job(3, 10, 20), new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200)};
		WeightedJobSchedulingDyn obj = new WeightedJobSchedulingDyn();
		System.out.println(obj.findMax(arr));
	}
	
}
