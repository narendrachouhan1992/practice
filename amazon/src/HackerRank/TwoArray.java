package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class TwoArray {
	public static int getTotalX(List<Integer> a, List<Integer> b) {
		
		int lcmS=a.size()>1?lcm(a.get(0), a.get(1)):a.get(0);
		for (int i = 2; i < a.size(); i++) {
			lcmS = lcm(lcmS, a.get(i));
		}
		int hcfE = b.size()>1?gcd(b.get(0), b.get(1)):b.get(0);
		for(int i=2;i<b.size();i++)
		{
			hcfE = gcd(hcfE, b.get(i));
		}
		int count = 0;
		for(int i=lcmS;i<=hcfE;i++ )
		{
			if(i%lcmS==0 && hcfE%i == 0)
				count++;
		}
		return count;
		// Write your code here

	}

	static int gcd(int x, int y) {
		while (x != y) {
			if (x > y)
				x -= y;
			else
				y -= x;
		}
		return x;
	}
	static int lcm(int x, int y)
	{
		int gcd = gcd(x, y);
		return ((x*y)/gcd);
	}
	public static void main(String[] args) {
		List<Integer> s = new ArrayList<Integer>();
		s.add(2);
		s.add(4);
		List<Integer> e = new ArrayList<Integer>();
		e.add(16);
		e.add(32);
		e.add(96);
		System.out.println(getTotalX(s, e));
	}
}
