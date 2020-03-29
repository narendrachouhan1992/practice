package newDynamic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockBuySell {
	class Intervel
	{
		int buy;
		int sell;
	}
	void findmaxProfit(int[] arr)
	{

		List<Intervel> sols = new ArrayList<Intervel>();
		int length = arr.length;
		int i =0;
		while(i<length)
		{
			while(i<length && (arr[i + 1] <= arr[i]))
				i++;
			Intervel e = new Intervel();
			e.buy = i++;
			while(i<length && (arr[i] >= arr[i - 1]))
				i++;
			e.sell = i-1;
			sols.add(e);
		}
		for (Intervel sol : sols) {
			{
				System.out.println("buy at "+arr[sol.buy]+" sell at "+arr[sol.sell]);
			}
			
		}
	}
	public static void main(String[] args) {
		StockBuySell obj = new StockBuySell();
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		obj.findmaxProfit(price);
	}
}
