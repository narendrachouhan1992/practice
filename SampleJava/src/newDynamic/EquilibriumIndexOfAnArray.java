package newDynamic;

public class EquilibriumIndexOfAnArray {
	int getEqIndex(int[] arr)
	{
		int sum = 0;
		int lsum = 0;
		int size = arr.length;
		for(int i= 0;i<size;i++)
		{
			sum+= arr[i];
		}
		for(int i= 0;i<size;i++)
		{
			sum -= arr[i];
			if(lsum == sum)
			{
				return i;
			}
			lsum+= arr[i];
			
		}
		return -1;
	}
	public static void main(String[] args) {
		EquilibriumIndexOfAnArray obj = new EquilibriumIndexOfAnArray();
		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
		if(obj.getEqIndex(arr) != -1)
		{
			System.out.println("equilibrium index is "+ obj.getEqIndex(arr));
		}
		else
		{
			System.out.println("no equilibrium index");
		}
	}
}
