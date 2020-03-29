package newDynamic;

public class FindWaterInAGlass {
	float getWater(int i, int j, float X)
	{
		if(j>i)
		{
			System.out.println("incorrect glass");
			return 0;
		}
		else
		{
			int numOfGlass = i*(i+1)/2;
			float[] glasses = new float[numOfGlass];
			int index = 0;
			glasses[index] = X;
			for(int row = 1;row<= i;row++)
			{
				for(int col = 1;col<=row;col++, index++)
				{
					X = glasses[index];
					glasses[index] = X<1? X: 1;
					X = X-glasses[index];
					if(X!= 0)
					{
						glasses[index+row] += X/2;
						glasses[index+row+1] += X/2;
					}
				}
			}
			return glasses[i*(i-1)/2+ j-1];
		}
		
	}
	public static void main(String[] args) {
		FindWaterInAGlass obj = new FindWaterInAGlass();
		System.out.println(obj.getWater(2, 2, 2));
		
	}
}
