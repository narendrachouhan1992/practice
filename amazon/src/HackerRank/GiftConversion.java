package HackerRank;

import java.math.BigInteger;

public class GiftConversion {
	public static long taumBday(int b, int w, int bc, int wc, int z) {
	
		
		
		
		long res = 0;
	if(Math.abs(wc-bc)<=z)
	{
		res+= b*bc;
		res+=w*wc;
	}
	else
	{
		if(wc<bc)
		{
			res+=wc*w;
			res+=(wc+z)*b;
		}
		else
		{
			res+=bc*b;
			res+=(bc+z)*w;
		}
	}
	return res;
	}
	public static long taumBday1(int b, int w, int bc, int wc, int z)
	{
		bc = bc>wc? ((bc-wc>z)? wc+z : bc) : bc;
        wc = wc>bc? ((wc-bc>z)? bc+z : wc) : wc;
        long res = b*bc;
        res+= w*wc;
        return res;
	}
	public static void main(String[] args) {
		System.out.println(taumBday(27984, 1402,619246 , 615589, 247954));
	}
	//18192035842
}
