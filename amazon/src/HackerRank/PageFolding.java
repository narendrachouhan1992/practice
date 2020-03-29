package HackerRank;

public class PageFolding {
	static int pageCount(int n, int p) {
		if(p<n/2)
		{
			if(p%2==1)
			{
				return ((p-1)/2);
			}
			else
			{
				return p/2;
			}
		}
		else
		{
			p = n-p;
			if(p%2==1)
			{
				return ((p-1)/2);
			}
			else
			{
				return p/2;
			}
		}
    }
}
