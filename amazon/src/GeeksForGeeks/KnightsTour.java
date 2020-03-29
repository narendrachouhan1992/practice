package GeeksForGeeks;

public class KnightsTour {
	static int N = 8;
	public static void solvekt() {
		int[][] sol = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				sol[i][j] = -1;
			}
		}
		sol[0][0] = 0;

		int[] moveX = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int[] moveY = { 1, 2, 2, 1, -1, -2, -2, -1 };

		if (!solveKTUtil(0, 0, 1, sol,moveX, moveX)) {
			System.out.println("no sol found");
		} else {
			printSol(sol);
		}
	}
	static boolean solveKT() { 
        int sol[][] = new int[8][8]; 
  
        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++) 
            for (int y = 0; y < N; y++) 
                sol[x][y] = -1; 
  
       /* xMove[] and yMove[] define next move of Knight. 
          xMove[] is for next value of x coordinate 
          yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
  
        // Since the Knight is initially at the first block 
        sol[0][0] = 0; 
  
        /* Start from 0,0 and explore all tours using 
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) { 
            System.out.println("Solution does not exist"); 
            return false; 
        } else
        	printSol(sol); 
  
        return true; 
    } 
	private static boolean solvekt(int[][] sol, int x, int y, int num, int[] moveX, int[] moveY) {

		if (num == 64)
			return true;
		for (int i = 0; i < 8; i++) {
			if (isSafe(sol, x + moveX[i], y + moveY[i])) {
				sol[x + moveX[i]][y + moveY[i]] = num;
				if (solvekt(sol, x + moveX[i], y + moveY[i], num + 1, moveX, moveX)) {
					return true;
				} else {
					sol[x + moveX[i]][y + moveY[i]] = -1;
				}
			}
		}

		return false;
	}

	static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
		int k, next_x, next_y;
		if (movei == 64)
			return true;

		/*
		 * Try all next moves from the current coordinate x, y
		 */
		for (k = 0; k < 8; k++) {
			next_x = x + xMove[k];
			next_y = y + yMove[k];
			if (isSafe(sol, next_x, next_y )) {
				sol[next_x][next_y] = movei;
				if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove))
					return true;
				else
					sol[next_x][next_y] = -1;// backtracking
			}
		}

		return false;
	}

	private static boolean isSafe(int[][] sol, int x, int y) {
		 return (x >= 0 && x < 8 && y >= 0 && 
	                y < 8 && sol[x][y] == -1); 
	}

	private static void printSol(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j]);
				if (j != 7) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		solvekt();
		solveKT();
	}
}
