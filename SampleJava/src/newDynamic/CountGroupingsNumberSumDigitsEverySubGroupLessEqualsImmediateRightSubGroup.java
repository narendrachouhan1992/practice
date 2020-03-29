package newDynamic;

public class CountGroupingsNumberSumDigitsEverySubGroupLessEqualsImmediateRightSubGroup {
	int getCount(int position, int previousSum, int length, char[] num)
	{
		if(length==position)
			return 1;
		int res=0;
		int sum = 0;
		
		for(int i = position;i<length;i++)
		{
			sum += (num[i] - '0');
			
			if(sum>=previousSum)
			{
				res+= getCount(i+1, sum, length, num);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		char[] num = "1119".toCharArray();
		CountGroupingsNumberSumDigitsEverySubGroupLessEqualsImmediateRightSubGroup obj = new CountGroupingsNumberSumDigitsEverySubGroupLessEqualsImmediateRightSubGroup();
		System.out.println(obj.getCount(0, 0, num.length, num));
	}
}
