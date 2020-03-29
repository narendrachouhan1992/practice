package newDynamic;

public class CountEvenLengthBinarySequencesWithSameSumOfFirstAndSecondHalfBits {
	int getCount(int n, int diff)
	{
		if(Math.abs(diff)> n)
			return 0;
		if(n==1 && diff == 0)
			return 2;
		if(n == 1 && Math.abs(diff) == 1)
			return 1;
		return (2*getCount(n-1, diff) + getCount(n-1, diff+1)+ getCount(n-1, diff-1));
	}
	int getSol(int n)
	{
		return getCount(n, 0);
	}
	public static void main(String[] args) {
		CountEvenLengthBinarySequencesWithSameSumOfFirstAndSecondHalfBits obj = new CountEvenLengthBinarySequencesWithSameSumOfFirstAndSecondHalfBits();
		System.out.println(obj.getSol(2));
	}
}
