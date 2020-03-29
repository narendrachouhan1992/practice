package newDynamic;

public class Replace05InputInteger {
	int getNewNumUntil(int num)
	{
		if(num ==0)
			return 0;
		int degit = num%10;
		if(degit == 0)
			degit = 5;
		return (getNewNumUntil(num/10))*10 + degit;	
	}
	int getNumReplaced(int num)
	{
		if(num == 5)
			return 5;
		return getNewNumUntil(num);
	}
	public static void main(String[] args) {
		Replace05InputInteger obj = new Replace05InputInteger();
		System.out.println(obj.getNumReplaced(10120));
	}
}
