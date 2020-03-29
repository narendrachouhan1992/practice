package newDynamic;

public class DevideSetIntoTwoSubsetWithMinDiffRec {
	int getMinimumSum(int[] arr,int i,int sumtillNow, int sumtotal)
	{
		if(i==0)
		{
			return Math.abs(sumtotal -2*sumtillNow);
		}
		return Math.min(getMinimumSum(arr, i-1, sumtillNow, sumtotal), getMinimumSum(arr, i-1, sumtillNow+arr[i-1], sumtotal));
		
	}
	int getMinimumdiff(int[] arr)
	{
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return getMinimumSum(arr, arr.length,0, sum);
	}
	public static void main(String[] args) 
    {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        DevideSetIntoTwoSubsetWithMinDiffRec obj = new DevideSetIntoTwoSubsetWithMinDiffRec();
        System.out.print("The minimum difference"+
                        " between two sets is " + 
                         obj.getMinimumdiff(arr));
    }
}
