package GeeksForGeeks;

public class Zeta {
	static int getMaxremainingSUm(int[] arr, int k)
	 {
	     int n = arr.length;
	     if(n<=k)
	        return 0;
	     
	     int currSum =0;
	     for(int i=0;i<n-k;i++)
	     {
	    	 currSum+=arr[i];
	     }
	     int maxSum = currSum;
	     int end=n-k;
	     int start=-1;
	     for(int j=0;j<k;j++)
	     {
	    	 currSum+=arr[end+j];
	    	 currSum-=arr[++start];
	    	 maxSum=Integer.max(maxSum, currSum);
	     }
	     return maxSum;
	 }
//	public static void main(String[] args) {
//		int[] arr = 1, 2, 19, 20;
//	}
}
