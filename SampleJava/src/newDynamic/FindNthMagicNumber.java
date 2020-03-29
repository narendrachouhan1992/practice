package newDynamic;

public class FindNthMagicNumber {
	int getNth(int n)
	{
		int pow = 1;
		int sol = 0;
		while(n!= 0)
		{
			pow*=5;
			if((int)(n&1) == 1)
			{
				sol+= pow;
			}
			n>>= 1;
		}
		return sol;
	}
	public static void main(String[] args) {
		FindNthMagicNumber obj = new FindNthMagicNumber();
		System.out.println(obj.getNth(5));
	}
}
