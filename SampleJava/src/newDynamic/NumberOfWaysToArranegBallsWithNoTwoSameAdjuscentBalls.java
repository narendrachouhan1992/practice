package newDynamic;

public class NumberOfWaysToArranegBallsWithNoTwoSameAdjuscentBalls {
	int getCount(int p, int q, int r, int last)
	{
		if(p<0 || q<0 || r<0)
			return 0;
		if(q==1 && q==0 && r==0 && last ==0)
			return 1;
		if(q==0 && q==1 && r==0 && last ==1)
			return 1;
		if(q==0 && q==0 && r==1 && last ==2)
			return 1;
		if(last == 0)
		{
			return (getCount(p-1, q, r, 1)+ getCount(p-1, q, r, 2));
		}
		if(last == 1)
		{
			return (getCount(p, q-1, r, 0)+ getCount(p, q-1, r, 2));
		}
		if(last ==2)
		{
			return (getCount(p, q, r-1, 0)+ getCount(p, q, r-1, 1));
		}
		return 0;
	}
	int countUntill(int p, int q, int r)
	{
		return (getCount(p, q, r, 0) + getCount(p, q, r, 1) + getCount(p, q, r, 2));
	}
	public static void main(String[] args) {
		NumberOfWaysToArranegBallsWithNoTwoSameAdjuscentBalls obj = new NumberOfWaysToArranegBallsWithNoTwoSameAdjuscentBalls();
		System.out.println(obj.countUntill(1, 1, 1));
	}
}
