package newDynamic;

public class CountTotalSetBitsInAllNumbersFrom1ToN {
	int getNumberOfBitUsed(int n)
	{
		int i=1;
		while(Math.pow(2, i)<n)
		{
			i++;
		}
		return i;
	}
	int getSetBitCount(int n)
	{
		int numberOdBitUsed = getNumberOfBitUsed(n);
		int setBitsCount = 0;
		for(int i = 0;i<=numberOdBitUsed;i++)
		{
			if(((int)(n/Math.pow(2, i))) %2 == 1)
			{
				setBitsCount++;
			}
		}
		return setBitsCount;
	}
	public static void main(String[] args) {
		int n = 0;
		CountTotalSetBitsInAllNumbersFrom1ToN obj = new CountTotalSetBitsInAllNumbersFrom1ToN();
		while(n<100)
		{
			System.out.print(Integer.toBinaryString(n));
			System.out.print("  ");
			System.out.println(obj.getSetBitCount(n));
			n++;
		}
		
	}
}
