package newDynamic;

public class MaximumSumLengthsNonOverlappingSubarraysKMaxElement {
	int getLength(int[] arr, int k)
	{
		int res = 0;
		int length = arr.length;
		int i =0;
		while(i<length)
		{
			 int count = 0;
			 boolean foundK = false;
			 
			 while(i<length && arr[i]<=k)
			 {
				 count++;
				 if(arr[i]== k)
					 foundK = true;
				 i++;
			 }
			 if(foundK)
			 {
				 res+= count;
			 }
			 while(i<length && arr[i]>k)
			 {
				 i++;
			 }
		}
		return res;
	}
	public static void main(String[] args) {
		MaximumSumLengthsNonOverlappingSubarraysKMaxElement obj = new MaximumSumLengthsNonOverlappingSubarraysKMaxElement();
		 int[] arr = { 4, 5, 7, 1, 2, 9, 8, 4, 3, 1 };
		 System.out.println(obj.getLength(arr, 4));
	}
}
