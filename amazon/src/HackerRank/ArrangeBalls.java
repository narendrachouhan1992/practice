package HackerRank;

import java.util.Arrays;

public class ArrangeBalls {
	 static String organizingContainers(int[][] container) {
		int count = container.length;
		 int[] capacity= new int[count];
		 int[] balltypeCount = new int[count];
		 for(int i=0;i<count;i++)
		 {
			 for(int j=0;j<count;j++)
			 {
				 capacity[i]+=container[i][j];
				 balltypeCount[j]+=container[i][j];
			 }
		 }
		 Arrays.sort(capacity);
		 Arrays.sort(balltypeCount);
		 for(int i=0;i<count;i++)
		 {
			 if(capacity[i]!=balltypeCount[i])
			 {
				 return "Impossible";
			 }
		 }
		 return "Possible";
	 }
}
