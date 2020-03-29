package newDynamic;

public class MaximumSumSuchThatNoTwoElementsAreAdjacent {
	int getMaxSum(int[] arr)
	{
		int length = arr.length;
		int[] inc = new int[length];
		int[] exc = new int[length];
		inc[0] = arr[0];
		exc[0] = 0;
		for(int i=1;i<length;i++)
		{
			inc[i] = exc[i-1]+arr[i];
			exc[i] = Integer.max(inc[i-1], exc[i-1]);
		}
		return Integer.max(inc[length-1], exc[length-1]);
	}
	public static void main(String[] args) {
		int[] arr = {5, 5, 10, 100, 10, 5};
		MaximumSumSuchThatNoTwoElementsAreAdjacent obj = new MaximumSumSuchThatNoTwoElementsAreAdjacent();
		System.out.println(obj.getMaxSum(arr));
	}
}
