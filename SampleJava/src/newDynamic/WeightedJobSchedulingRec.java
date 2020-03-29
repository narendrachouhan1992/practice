package newDynamic;

import java.util.Arrays;
class JobRec implements Comparable<JobRec>
{
	int start;
	int end;
	int weight;
	public JobRec(int start, int end, int weight) {
		this.end = end;
		this.start = start;
		this.weight = weight;
	}
	public JobRec() {
	}
	@Override
	public int compareTo(JobRec compareJob) {

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
public class WeightedJobSchedulingRec {
	static int latestNonConflict(JobRec arr[], int i)
	{
	    for (int j=i-1; j>=0; j--)
	    {
	        if (arr[j].end <= arr[i-1].start)
	            return j;
	    }
	    return -1;
	}
	static int findMaxProfitRec(JobRec[] arr, int n)
	{
		if (n == 1) return arr[n-1].weight;
		 
	    // Find profit when current job is inclueded
	    int inclProf = arr[n-1].weight;
	    int i = latestNonConflict(arr, n);
	    if (i != -1)
	      inclProf += findMaxProfitRec(arr, i+1);
	 
	    // Find profit when current job is excluded
	    int exclProf = findMaxProfitRec(arr, n-1);
	 
	    return Integer.max(inclProf,  exclProf);

	}
	static int getMaxProfit(JobRec[] arr)
	{
		Arrays.sort(arr);
		int n = arr.length;
		return findMaxProfitRec(arr, n);
	}
	static int findMaxProfitDynamic(JobRec[] arr)
	{
		Arrays.sort(arr);
		int n = arr.length;
	    int[] table = new int[n];
	    table[0] = arr[0].weight;
	 
	    // Fill entries in M[] using recursive property
	    for (int i=1; i<n; i++)
	    {
	        // Find profit including the current job
	        int inclProf = arr[i].weight;
	        int l = latestNonConflict(arr, i);
	        if (l != -1)
	            inclProf += table[l];
	 
	        // Store maximum of including and excluding
	        table[i] = Integer.max(inclProf, table[i-1]);
	    }
	 
	    // Store result and free dynamic memory allocated for table[]
	    int result = table[n-1];	 
	    return result;
	}
	public static void main(String[] args) {
		JobRec[] arr = {new JobRec(3, 10, 20), new JobRec(1, 2, 50), new JobRec(6, 19, 100), new JobRec(2, 100, 200)};
		System.out.println(getMaxProfit(arr));
	}
}
