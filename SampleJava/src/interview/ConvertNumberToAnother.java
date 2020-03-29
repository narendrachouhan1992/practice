package interview;

public class ConvertNumberToAnother {
	static int findMaxNum(int x, int y, int z) {
		int diff = x-y;
		if(z<Math.abs(diff))
			return -1;
		int remainAfterReaching = z-Math.abs(diff);
		if(remainAfterReaching%2 == 1)
		{
			remainAfterReaching--;
		}
		if(x>y)
		{
			return (x+ (remainAfterReaching/2));
		} else
		{
			return (y+ (remainAfterReaching/2));
		}
    }
	public static void main(String[] args) {
		System.out.println(findMaxNum(2,3, 7));
	}
}
