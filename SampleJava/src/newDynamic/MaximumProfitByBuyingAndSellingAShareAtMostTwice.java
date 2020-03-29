package newDynamic;

public class MaximumProfitByBuyingAndSellingAShareAtMostTwice {
	int getMaxProfit(int[] arr)
	{
		int length = arr.length;
		int[] profit = new int[length];
		int max_price = arr[length-1];
		
		for(int i =length-2;i>=0;i--)
		{
			if(arr[i]>max_price)
				max_price=arr[i];
			
			profit[i] = Integer.max(profit[i+1], max_price-arr[i]);
		}
		
		int min_price = arr[0];
		for(int i = 1;i<length;i++)
		{
			if(arr[i]<min_price)
				min_price=arr[i];
			profit[i] = Integer.max(profit[i-1], arr[i]-min_price + profit[i]);
		}
		
		return profit[length-1];
	}
	public static void main(String[] args) {
		int[] price = {2, 30, 15, 10, 8, 25, 80};
		MaximumProfitByBuyingAndSellingAShareAtMostTwice obj = new MaximumProfitByBuyingAndSellingAShareAtMostTwice();
		System.out.println(obj.getMaxProfit(price));
	}
}
