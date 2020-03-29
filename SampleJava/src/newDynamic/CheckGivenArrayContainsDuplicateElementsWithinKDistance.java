package newDynamic;

import java.util.HashSet;

public class CheckGivenArrayContainsDuplicateElementsWithinKDistance {
	boolean checkIfExist(int[] arr, int k)
	{
		int length = arr.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<length;i++)
		{
			if(set.contains(arr[i]))
			{
				return true;
			}
			set.add(arr[i]);
			if(i>=k)
			{
				set.remove(arr[i-k]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int arr[] = {10, 5, 3, 4, 3, 5, 6};
		CheckGivenArrayContainsDuplicateElementsWithinKDistance obj = new CheckGivenArrayContainsDuplicateElementsWithinKDistance();
		if(obj.checkIfExist(arr, 3))
			System.out.println("yes");
		else
			System.out.println("No");
	}
}
