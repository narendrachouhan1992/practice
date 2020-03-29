package newDynamic;

public class CountSetBitsInAnInteger {
	int getSetBitCount(int n)
	{
		int count = 0;
		while(n!= 0)
		{
			n &= (n-1);
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		CountSetBitsInAnInteger obj = new CountSetBitsInAnInteger();
		System.out.println(Integer.toBinaryString(19)+" "+ obj.getSetBitCount(19));
		System.out.println(Integer.toBinaryString(-5));
	}
}
