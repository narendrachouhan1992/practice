package newDynamic;

public class FindTheRowWithMaximumNumber1s {
	int getRow(boolean[][] arr)
	{
		int rows = arr.length;
		int cols = arr[0].length;
		int i;
		for(i = 0;i<cols;i++)
		{
			if(arr[0][i])
			{
				break;
			}
		}
		int res = 0;
		for(int j = 0;j<rows;j++)
		{
			while (arr[j][i] &&  i != 0 && arr[j][i-1] )
			{
				i--;
				res = j;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		boolean mat[][] = { {false, false, false, true},
			                {false, true, true, true},
			                {true, true, true, true},
			                {false, false, false, false}};
		FindTheRowWithMaximumNumber1s obj = new FindTheRowWithMaximumNumber1s();
		System.out.println(obj.getRow(mat));
	}
}
