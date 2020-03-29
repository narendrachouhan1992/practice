package hackerRank;

public class ImpressTheBoss {
	static String canModify(int[] a) {
        /*
         * Write your code here.
         */
		// find out if there is only one consicutive decreas
		int dInd = -1;
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]>a[i+1])
			{
				if(dInd== -1)
				{
					dInd = i;
				}
				else
					dInd = Integer.MAX_VALUE;
			}
		}
		if(dInd == -1)
			return "YES";
		else if(dInd == Integer.MAX_VALUE)
			return "NO";
		else
		{
			if(dInd == 0 || dInd == a.length -2 || a[dInd-1]<=a[dInd+1] || (a[dInd-1] >= a[dInd+1] && a[dInd+2]>=a[dInd-1]))
				return "YES";
			else
			{
				return "NO";
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1980, 95, 95, 1980};
		System.out.println(canModify(arr));
	}
}
