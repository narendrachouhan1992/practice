package newDynamic;

public class FindZeroesToBeFlippedSoThatNumberOfConsecutive1sIsMaximized {
	void printMax(int[] arr, int m)
	{
		int wL = 0, wR = 0; 
	      
        // Left index and size of the widest window 
        int bestL = 0, bestWindow = 0; 
      
        // Count of zeroes in current window
        int zeroCount = 0;
        while(wR< arr.length)
        {
        	if(zeroCount<=m)
        	{
        		if(arr[wR]== 0)
        		{
        			zeroCount++;
        		}
        		wR++;
        	}
        	if (zeroCount > m)
            {
                if (arr[wL] == 0)
                  zeroCount--;
                wL++;
            }
        	if (wR-wL > bestWindow)
            {
                bestWindow = wR-wL;
                bestL = wL;
            }
        	
        }
        for (int i=0; i<bestWindow; i++)
        {
            if (arr[bestL+i] == 0)
               System.out.print(bestL+i + " ");
        }
	}
	public static void main(String[] args) {
		FindZeroesToBeFlippedSoThatNumberOfConsecutive1sIsMaximized obj = new FindZeroesToBeFlippedSoThatNumberOfConsecutive1sIsMaximized();
		int[] arr = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
		obj.printMax(arr, 2);
	}
}
