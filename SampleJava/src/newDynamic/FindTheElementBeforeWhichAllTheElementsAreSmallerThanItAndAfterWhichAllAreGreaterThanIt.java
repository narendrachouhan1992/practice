package newDynamic;

public class FindTheElementBeforeWhichAllTheElementsAreSmallerThanItAndAfterWhichAllAreGreaterThanIt {
	int getElement(int[] arr)
	{
		int length = arr.length;
		int[] leftMax = new int[length];
		int rightMin = Integer.MAX_VALUE;
		leftMax[0] = Integer.MIN_VALUE;
		for(int i=1;i<length;i++)
		{
			leftMax[i] = Integer.max(arr[i-1], leftMax[i-1]);
		}
		for(int i=length-1;i>=0;i--)
		{
			if(arr[i]<rightMin && leftMax[i]<arr[i])
				return arr[i];
			rightMin = Integer.min(rightMin, arr[i]);
		}
		return -1;
	}
	public static void main(String[] args) {
		 int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		 FindTheElementBeforeWhichAllTheElementsAreSmallerThanItAndAfterWhichAllAreGreaterThanIt obj = new FindTheElementBeforeWhichAllTheElementsAreSmallerThanItAndAfterWhichAllAreGreaterThanIt();
		 System.out.println(obj.getElement(arr));
	}
}
