package newDynamic;

public class DifferenceBetweenEvenAndOddDigitIsOne {
	static int[][][][] lookup = new int[50][1000][1000][2];
	static int getFinalCountRec(int digits, int eSum, int oSum, int isOdd, int n)
	{
		int ans =0;
		if(digits==n)
		{
			return (eSum-oSum==1)?1:0;
		}
		if(lookup[digits][eSum][oSum][isOdd]!=-1)
		{
			return lookup[digits][eSum][oSum][isOdd];
		}
		if (isOdd==1)
		{
			for (int i = 0; i <= 9; i++)
		          ans += getFinalCountRec(digits+1, eSum, oSum+i, 0, n);
		}     
		else // Add to even sum and recur
		{
			for (int i = 0; i <= 9; i++)
				ans += getFinalCountRec(digits+1, eSum+i, oSum, 1, n);
		}
		return lookup[digits][eSum][oSum][isOdd] = ans;
	}
	static int getFinalCount(int n)
	{
		int oddSum = 0;
		int evenSum = 0;
		
		int digit = 0;
		int ans = 0;
		for (int i = 0; i < lookup.length; i++) {
			for (int j = 0; j < lookup[i].length; j++) {
				for (int j2 = 0; j2 < lookup[i][j].length; j2++) {
					for (int k = 0; k < lookup[i][j][j2].length; k++) {
						lookup[i][j][j2][k]=-1;
					}
				}
			}
		}
		for(int i=1;i<10;i++)
		{
			ans+= getFinalCountRec(digit+1, evenSum + i, oddSum, 1, n);
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(getFinalCount(3));
		
	}
}
