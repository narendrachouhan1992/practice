package newDynamic;

import java.util.ArrayList;
import java.util.List;

public class GivenANumberFindNextSparseNumber {
	int getNext(int num)
	{
		List<Boolean> bits = new ArrayList<Boolean>();
		while(num!= 0)
		{
			if((num&1) == 1)
			{
				bits.add(true);
			} 
			else
			{
				bits.add(false);
			}
				num >>= 1;
		}
		bits.add(false);
		int last_final = 0;
		int n = bits.size();
		for(int i = 1;i<n-1;i++)
		{
			if(bits.get(i) && bits.get(i-1) && !bits.get(i+1))
			{
				bits.set(i+1, true);
				for(int j = i;j>=last_final;j--)
				{
					bits.set(j, false); 
				}
				last_final= i+1;
			}
		}
		int ans = 0;
		for (int i =0; i<n; i++)
		{
			if(bits.get(i))
			{
				ans+= (1<<i);
			}
		}
	    return ans;
	}
	public static void main(String[] args) {
		GivenANumberFindNextSparseNumber obj = new GivenANumberFindNextSparseNumber();
		System.out.println(obj.getNext(38));
	}
}
