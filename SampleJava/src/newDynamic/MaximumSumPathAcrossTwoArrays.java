package newDynamic;

public class MaximumSumPathAcrossTwoArrays {
	int getMinpath(int[] arr1, int[] arr2)
	{
		int length1 = arr1.length;
		int length2 = arr2.length;
		int res = 0;
		int i =0;
		int j = 0;
		int sum1 = 0;
		int sum2 = 0;
		while(i<length1 && j<length2)
		{
			if(arr1[i]<arr2[j])
			{
				sum1+= arr1[i++];
			}
			else if(arr1[i]>arr2[j])
			{
				sum2+= arr2[j++];
			}
			else
			{
				res+= Integer.max(sum1, sum2);
				sum1 = 0;
				sum2 = 0;
				while(i<length1 && j < length2 && arr1[i] == arr2[j])
				{
					res+= arr1[i++];
					j++;
				}
			}
		}
		while(i<length1)
		{
			res+= arr1[i++];
		}
		while(j<length2)
		{
			res+= arr2[j++];
		}
		return res;
	}
	public static void main(String[] args) {
		MaximumSumPathAcrossTwoArrays obj = new MaximumSumPathAcrossTwoArrays();
		  int arr1[] = {2, 3, 7, 10, 12, 15, 30, 34};
	      int arr2[] = {1, 5, 7, 8, 10, 15, 16, 19};
	      System.out.println(obj.getMinpath(arr1, arr2));
	}
}
