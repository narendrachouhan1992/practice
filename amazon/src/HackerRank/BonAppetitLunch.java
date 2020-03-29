package HackerRank;

import java.util.List;

public class BonAppetitLunch{
	static void bonAppetit(List<Integer> bill, int k, int b) {
		int annaShare = 0;
		for(int i=0;i<bill.size();i++)
		{
			if(i!=k)
			{
				annaShare+=bill.get(i);
			}
		}
		annaShare/=2;
		if(b==annaShare)
		{
			System.out.println("Bon Appetit");
		}
		else
		{
			System.out.println(b-annaShare);
		}
	}
}
