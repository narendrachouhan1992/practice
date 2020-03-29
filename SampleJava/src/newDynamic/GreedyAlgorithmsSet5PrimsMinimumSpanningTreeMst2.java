package newDynamic;

public class GreedyAlgorithmsSet5PrimsMinimumSpanningTreeMst2 {
	int minKey(int[] key, boolean[] mstSet)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < key.length; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
	void printMST(int[] parent, int n, int[][] arr)
	{
		for (int i = 0; i < parent.length; i++) {
			System.out.println(parent[i]+" - "+ i +" = "+arr[parent[i]][i]);
		}
	}
	void getMST(int[][] arr)
	{
		int n = arr.length;
		int[] parent = new int[n];
		int[] key = new int[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++)
        {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
		key[0] = 0;
		parent[0] = -1;
		for(int i=0;i<n;i++)
		{
			int u = minKey(key, visited);
			visited[u] = true;
			for(int v=0;v<n;v++)
			{
				if(arr[u][v] != 0 && !visited[v] && arr[u][v]< key[u])
				{
					parent[v] = u;
					key[v] = arr[u][v];
				}
			}
		}
		printMST(parent, n, arr);
	}
	public static void main(String[] args) {
		GreedyAlgorithmsSet5PrimsMinimumSpanningTreeMst2 obj = new GreedyAlgorithmsSet5PrimsMinimumSpanningTreeMst2();
		 /* Let us create the following graph
        2    3
     (0)--(1)--(2)
     |    / \   |
     6| 8/   \5 |7
     | /      \ |
     (3)-------(4)
          9          */
     int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                 {2, 0, 3, 8, 5},
                                 {0, 3, 0, 0, 7},
                                 {6, 8, 0, 0, 9},
                                 {0, 5, 7, 9, 0},
                                };

     // Print the solution
                                obj.getMST(graph);
	}
}
