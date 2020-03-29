package newDynamic;
class Temple
{
	int R= -1;
	int L = -1;;
}
public class TempleOfferings {
	
	int getOffering(int[] arr)
	{
		int n = arr.length;
		Temple[] chainSize = new Temple[n];
		for (int i = 0; i <n; i++) {
			chainSize[i]= new Temple();
		}
		chainSize[0].L=1;
		chainSize[n-1].R=1;
		for(int i=1;i<n;i++)
		{
			if(arr[i]>arr[i-1])
				chainSize[i].L= chainSize[i-1].L+1;
			else
				chainSize[i].L=1;
		}
		for(int i=n-2;i>=0;i--)
		{
			if(arr[i]>arr[i+1])
			{
				chainSize[i].R = chainSize[i+1].R+1;
			}
			else
				chainSize[i].R = 1;
		}
		int sum =0;
		for(int i=0;i<n;i++)
		{
			sum+=Integer.max(chainSize[i].L, chainSize[i].R);
		}
		return sum;
	}
	public static void main(String[] args) {
		int arr1[] = {1, 2, 2};
		int arr2[] = {1, 4, 3, 6, 2, 1};
		TempleOfferings obj = new TempleOfferings();
		System.out.println(obj.getOffering(arr1));
		System.out.println(obj.getOffering(arr2));
	}
}
