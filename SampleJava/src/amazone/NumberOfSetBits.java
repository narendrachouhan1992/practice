package amazone;

public class NumberOfSetBits {
	int getNumberOfSetBits(int n)
	{
		int count = 0;
		int i=0;
		while((1<<i)<=n)
		{
			int k = 1<<i; 
			if((n/k)%2 == 1)
			{
				count++;
			}
			i++;
		}
		return count;
	}
	void getAllSet(int n)
	{
		
		for(int i=1;i<=n;i++)
		{
			System.out.println(Integer.toBinaryString(i));
			System.out.println(getNumberOfSetBits(i));
		}
	}
	public static void main(String[] args) {
		NumberOfSetBits obj = new NumberOfSetBits();
		obj.getAllSet(17);
	}
}
