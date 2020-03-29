package newDynamic;

public class FindSmallestRangeContainingElementsFromKLists {
	void getMinrange(int[][] arr)
	{
		int k = arr.length;
		int minel = 0;;
		int maxel = 0;;
		int n = arr[0].length;
		int[] ptr = new int[k];
		boolean flag = false;
		int minValue = Integer.MAX_VALUE;
		int minINdex = -1;
		int maxValue = Integer.MIN_VALUE;
		int minRnge = Integer.MAX_VALUE;
		while(true)
		{
			for(int i=0;i< k;i++)
			{
				if(ptr[i] == n)
				{
					flag = true;
					break;
				}
				if(ptr[i]<n && arr[i][ptr[i]]<minValue)
				{
					minValue = arr[i][ptr[i]];
					minINdex = i;
				}
				if(ptr[i]<n && arr[i][ptr[i]]>maxValue)
				{
					maxValue = arr[i][ptr[i]];
				}
			}
			if(flag)
			{
				break;
			}
			ptr[minINdex]++;
			if((maxValue-minValue) < minRnge)  
	         {
	             minel = minValue;
	             maxel = maxValue;
	             minRnge = maxel - minel;
	         }
		}
		System.out.println("min range is "+ minRnge+ " between "+ minel +" and "+ maxel);
	}
	public static void main(String[] args) {
		FindSmallestRangeContainingElementsFromKLists obj = new FindSmallestRangeContainingElementsFromKLists();
		 int arr[][] = {
                 {4, 7, 9, 12, 15},
                 {0, 8, 10, 14, 20},
                 {6, 12, 16, 30, 50}
                 };
		obj.getMinrange(arr);
	}
}
