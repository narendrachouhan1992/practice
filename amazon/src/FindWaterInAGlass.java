
public class FindWaterInAGlass {
	static float getWater(int W, int row, int col)
	{
		if(col>row)
			return -1;
		
		int glasses = Math.round(row*(row+1));
		float[] water = new float[glasses+2];
		int index = 1;
		water[index] = W;
		
		for(int i=1;i<=row;i++)
		{
			for(int j=1;j<=i;j++, index++)
			{
				float X = water[index];
				water[index] = X<1?X:1;
				X = X<1?0:X-1;
				water[i+j]+=X/2;
				water[i+j+1] += X/2;
			}
		}
		return water[(int)(row * (row - 1) / 2 + col - 1)];
	}
	public static void main(String[] args) {
		System.out.println(getWater(2, 2, 2));
	}
}
