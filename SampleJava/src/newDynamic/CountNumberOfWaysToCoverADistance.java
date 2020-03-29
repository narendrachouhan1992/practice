package newDynamic;

public class CountNumberOfWaysToCoverADistance {
	int getNumberOfWays(int n)
	{
		int[] ways = new int[n+1];
		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 2;
		ways[3] = 4;
		for(int i=4;i<=n;i++)
		{
			ways[i] = ways[i-1]+ways[i-2]+ ways[i-3];
		}
		return ways[n];
	}
	public static void main (String[] args) 
    {
        CountNumberOfWaysToCoverADistance obj = new CountNumberOfWaysToCoverADistance();
        System.out.println(obj.getNumberOfWays(10));
    }
}
