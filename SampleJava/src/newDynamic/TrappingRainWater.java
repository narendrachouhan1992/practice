package newDynamic;

public class TrappingRainWater {
	int getWaterVol(int[] arr)
	{
		int lenth = arr.length;
		int low = 0;
		int high = lenth-1;
		int max_left = 0;
		int max_right = 0;
		int res = 0;
		while(low<=high)
		{
			if(arr[low]<arr[high])
			{
				if(arr[low]>max_left)
				{
					max_left = arr[low];
				}
				else
				{
					res+= (max_left - arr[low]);
					low++;
				}
			}
			else
			{
				if(arr[high]>max_right)
				{
					max_right = arr[high];
				}
				else
				{
					res+= (max_right - arr[high]);
					high--;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		int arr[] = {0, 1, 0, 2, 1, 0, 1,
                3, 2, 1, 2, 1};
		System.out.println(obj.getWaterVol(arr));
	}
}
