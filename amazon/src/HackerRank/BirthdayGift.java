package HackerRank;

public class BirthdayGift {
	public static int findDamagedToy(int N, int T, int D) {
		if(T==0)
		return -1;
		
		if(T>N)
		{
			T%=N;
		}
		int i=D;
		T--;
		while(T!=0)
		{
			i++;
			T--;
			if(i==N+1)
			{
				i=1;
			}
		}
		return i;
    }
}
