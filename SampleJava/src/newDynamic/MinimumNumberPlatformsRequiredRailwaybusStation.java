package newDynamic;

import java.util.Arrays;

public class MinimumNumberPlatformsRequiredRailwaybusStation {
	int getNumberOfPlatform(int[] arrival, int[] departure)
	{
		int length = arrival.length;
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int i =0;
		int j = 0;
		int res = 0;
		int curr_bus = 0;
		while(i!= length && j!=length)
		{
			if(arrival[i]<=departure[j])
			{
				curr_bus++;
				i++;
				res = Integer.max(curr_bus, res);
			}
			else
			{
				curr_bus--;
				j++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		MinimumNumberPlatformsRequiredRailwaybusStation obj = new MinimumNumberPlatformsRequiredRailwaybusStation();
		int[] arrival = {900, 940, 950, 1100, 1500, 1800};
	    int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
	    System.out.println(obj.getNumberOfPlatform(arrival, departure));
	}
}
