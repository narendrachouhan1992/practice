package newDynamic;

public class MaximumSumAlternatingSubsequenceSum {
	int getMax(int[] arr)
	{
		int length = arr.length;
		if(length == 1)
		{
			return arr[0];
		}
		int[] dec = new int[length];
		int[] inc = new int[length];
		boolean flag = false;
		inc[0]= dec[0]= arr[0];
		for(int i =1;i<length;i++)
		{
			for(int j = 0;j<i;j++)
			{
				if(arr[i]<arr[j])
				{
					dec[i] = Math.max(dec[i], arr[i]+ inc[j]);
					flag=  true;
				}
				if(arr[i]> arr[j] && flag)
				{
					inc[i] = Math.max(inc[i], arr[i]+ dec[j]);
				}
			}
		}
		int result = 0;
		for(int i=0;i<length;i++)
		{
			if(result<inc[i])
				result = inc[i];
			if(result<dec[i])
				result = dec[i];
		}
		
		return result;
	}
	public static void main(String[] args) {
		 int[] arr= {8, 2, 3, 5, 7, 9, 10};
		 MaximumSumAlternatingSubsequenceSum obj = new MaximumSumAlternatingSubsequenceSum();
	        System.out.println("Maximum sum = " + obj.getMax(arr));
	}
}
