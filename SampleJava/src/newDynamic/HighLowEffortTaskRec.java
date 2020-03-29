package newDynamic;

public class HighLowEffortTaskRec {
	int getMax(int[] max, int min[], int n)
	{
		if(n<=0)
		{
			return 0;
		}
		return (Integer.max((max[n-1]+getMax(max, min, n-2)), (min[n-1]+getMax(max, min, n-1))));
	}
	public static void main(String[] args) {
		 int[] high = {3, 6, 8, 7, 6};
		 int[] low = {1, 5, 4, 5, 3};
		 HighLowEffortTaskRec obj = new HighLowEffortTaskRec();
		 System.out.println(obj.getMax(high, low, 5));
	}
}
