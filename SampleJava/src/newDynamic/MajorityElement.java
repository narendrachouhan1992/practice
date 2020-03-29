package newDynamic;

public class MajorityElement {
	void printMajority(int[] arr)
	{
		int candidate = findMajority(arr);
		if(isMajority(arr, candidate))
		{
			System.out.println(candidate);
		}
		else
		{
			System.out.println("no element exist");
		}
	}
	boolean isMajority(int[] arr, int candidate)
	{
		int count = 0;
		for(int i = 0;i<arr.length;i++)
		{
			if(candidate == arr[i])
				count++;
		}
		if(count >(arr.length/2))
			return true;
		else
			return false;
	}
	int findMajority(int[] arr)
	{
		int majority_ind = 0;
		int count = 1;
		for(int i =0;i<arr.length;i++)
		{
			if(arr[majority_ind] == arr[i])
				count++;
			else
				count--;
			if(count == 0)
			{
				majority_ind = i;
				count= 1;
			}
		}
		return arr[majority_ind];
	}
	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		int arr[] = new int[]{1, 3, 3, 1, 2};
		obj.printMajority(arr);
	}
}
