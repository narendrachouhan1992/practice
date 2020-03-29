package newDynamic;

public class CountNumbersFirstLastDigits {
	int getFirstdigit(int n)
	{
		if(n<10)
			return n;
		while(n/10 >10)
			n/=10;
		return n;
	}
	int getNumOfDigitFrom1ToN(int n)
	{
		if(n<10)
			return n;
		int sum = n/10;
		sum+= 9;
		int first = getFirstdigit(n);
		int last = n%10;
		if(last<first)
		{
			sum--;
		}
		return sum;
	}
	int getNumBetweenStartAndEnd(int start, int end)
	{
		return getNumOfDigitFrom1ToN(end)-getNumOfDigitFrom1ToN(start);
	}
	public static void main(String[] args) {
		CountNumbersFirstLastDigits obj = new CountNumbersFirstLastDigits();
		System.out.println(obj.getNumBetweenStartAndEnd(5, 40));
	}
}	
