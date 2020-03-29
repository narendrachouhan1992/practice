package newDynamic;

public class FloodFillAlgorithmImplementFillPaint {
	int[][] screen = {{1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
           };
	void fillFlood(int i, int j, int prevC, int newC)
	{
		if(i<0 || j<0 || i>= screen.length || j>= screen[0].length)
			return;
		if(screen[i][j] == prevC)
		{
			screen[i][j] = newC;
			fillFlood( i+1, j, prevC, newC);
			fillFlood( i, j+1, prevC, newC);
			fillFlood( i, j-1, prevC, newC);
			fillFlood( i-1, j, prevC, newC);
		}	
	}
	void printMat()
	{
		for (int[] is : screen) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	void fillFloodAll(int i, int j, int newC)
	{
		fillFlood(i, j, screen[i][j], newC);
	}
	public static void main(String[] args) {
		FloodFillAlgorithmImplementFillPaint obj = new FloodFillAlgorithmImplementFillPaint();
		
		obj.fillFloodAll(4, 4, 3);
		obj.printMat();
	}
}
