package hackerRank;

public class recortBreaker {
	static int[] breakingRecords(int[] scores) {
		if(scores==null || scores.length==0)
		{
			int[] arr = {0,0};
			return arr;
		}
		int min = scores[0];
		int max = scores[0];
		int minCount=0;
		int maxCount=0;
		for(int i=1;i<scores.length;i++)
		{
			if(min>scores[i])
			{
				min=scores[i];
				minCount++;
			}
			if(max<scores[i])
			{
				max=scores[i];
				maxCount++;
			}
		}
		int[] arr = {maxCount, minCount};
		return arr;
    }
}
