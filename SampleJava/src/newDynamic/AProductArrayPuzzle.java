package newDynamic;

public class AProductArrayPuzzle {
	void printProductArray(int[] arr)
	{
		
		int temp = 1;
		int length = arr.length;
		int[] productArray = new int[length];
		for(int i=0;i<length;i++)
		{
			System.out.print(arr[i]+ ", ");
		}
		System.out.println();
		for(int i=0;i<length;i++)
		{
			productArray[i] = 1;
		}
		for(int i=0;i<length;i++)
		{
			productArray[i] *= temp;
			temp *= arr[i];
		}
		temp = 1;
		for(int i=length -1;i>=0;i--)
		{
			productArray[i] *= temp;
			temp *= arr[i];
		}	
		for(int i=0;i<length;i++)
		{
			System.out.print(productArray[i]+ ", ");
		}
	}
	public static void main(String[] args) {
		AProductArrayPuzzle obj = new AProductArrayPuzzle();
		int[] arr = {10, 3, 5, 6, 2};
		obj.printProductArray(arr);
	}
}
