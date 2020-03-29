package newDynamic;

public class SubmatrixSumQueries {
	 static final int M = 4;
	 static final int N = 5;
	void preProcess(int mat[][], int aux[][])
    {
         
        // Copy first row of mat[][] to aux[][]
        for (int i = 0; i < N; i++)
            aux[0][i] = mat[0][i];
         
        // Do column wise sum
        for (int i = 1; i < M; i++)
            for (int j = 0; j < N; j++)
                aux[i][j] = mat[i][j] + 
                                aux[i-1][j];
         
        // Do row wise sum
        for (int i = 0; i < M; i++)
            for (int j = 1; j < N; j++)
                aux[i][j] += aux[i][j-1];
        
    }
     
    // A O(1) time function to compute sum 
    // of submatrix between (tli, tlj) and 
    // (rbi, rbj) using aux[][] which is 
    // built by the preprocess function
    int sumQuery(int aux[][], int tli, 
                    int tlj, int rbi, int rbj)
    {
         
        // result is now sum of elements 
        // between (0, 0) and (rbi, rbj)
        int res = aux[rbi][rbj];
     
        // Remove elements between (0, 0) 
        // and (tli-1, rbj)
        if (tli > 0)
            res = res - aux[tli-1][rbj];
     
        // Remove elements between (0, 0) 
        // and (rbi, tlj-1)
        if (tlj > 0)
            res = res - aux[rbi][tlj-1];
     
        // Add aux[tli-1][tlj-1] as elements 
        // between (0, 0) and (tli-1, tlj-1) 
        // are subtracted twice
        if (tli > 0 && tlj > 0)
            res = res + aux[tli-1][tlj-1];
     
        return res;
    }
    public static void main(String[] args) {
		SubmatrixSumQueries obj = new SubmatrixSumQueries();
		 int mat[][] = {{1, 2, 3, 4, 6},
                 {5, 3, 8, 1, 2},
                 {4, 6, 7, 5, 5},
                 {2, 4, 8, 9, 4}};
		 int aux[][] = new int[M][N];
		 obj.preProcess(mat, aux);
		 int tli = 2, tlj = 2, rbi = 3, rbj = 4;
	        System.out.print("\nQuery1: "
	            + obj.sumQuery(aux, tli, tlj, rbi, rbj));
	         
	        tli = 0; tlj = 0; rbi = 1; rbj = 1;
	        System.out.print("\nQuery2: "
	            + obj.sumQuery(aux, tli, tlj, rbi, rbj));
	         
	        tli = 1; tlj = 2; rbi = 3; rbj = 3;
	        System.out.print("\nQuery3: "
	            + obj.sumQuery(aux, tli, tlj, rbi, rbj));
	}
}
