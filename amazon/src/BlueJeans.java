import java.util.Arrays;

//Rotate an array in place to the right 
//Eg: Rotate by 2, k=2 Input arr = {-1, -100, 3, 99} Output {3,99,-1,-100}
public class BlueJeans {
	static int[] rotate(int[] arr, int r)
	{
		if(arr==null)
			return null;
		
		int oldPos= 0;
		int oldData = arr[0];
		for(int i=0;i<arr.length;i++)
		{
			int newPos = (oldPos+r)%arr.length;
			int temp = newPos;
			int tempD = arr[newPos];;
			arr[newPos] = oldData;
			oldPos = temp;
			oldData = tempD;
		}
		
		
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5, 6, 7};
		System.out.println(Arrays.toString(rotate(arr, 1)));
	}
}
