package newDynamic;

public class ReplaceEveryElementWithTheGreatestOnRightSide {
	void nextGreatest(int[] arr) 
	{
		int length = arr.length;
		int max_right = arr[length-1];
		arr[length-1] = -1;
		for(int i=length-2; i>=0;i--) 
		{
			int temp = arr[i];
			arr[i] = max_right;
			if(temp>max_right)
			{
				max_right = temp;
			}
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		int arr[] = {16, 17, 4, 3, 5, 2};
		ReplaceEveryElementWithTheGreatestOnRightSide obj = new ReplaceEveryElementWithTheGreatestOnRightSide(); 
		obj.nextGreatest(arr);
	}
}
