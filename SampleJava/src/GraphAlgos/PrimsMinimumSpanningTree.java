package GraphAlgos;

public class PrimsMinimumSpanningTree {
	int V;
	int[][] graph;
	public PrimsMinimumSpanningTree(int[][] graph) {
		this.graph = graph;
		this.V = graph.length;
		// TODO Auto-generated constructor stub
	}
	int getMinDist(int[] dist,boolean[] added)
	{
		int min = Integer.MAX_VALUE;
		int index = -1; 
		for(int i=0;i<V;i++)
		{
			if(dist[i]<min && !added[i])
			{
				min = dist[i];
				index = i;
			}
		}
		return index;
	}
	private void printMST(int parent[])
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
    }
	void getMST(int src)
	{
		int[] dist = new int[V];
		int[] parent = new int[V];
		for(int i=0;i<V;i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[src] = 0;
		parent[src] = -1;
		boolean[] added = new boolean[V];
		for(int count = 0;count<V-1;count++)
		{
			int u = getMinDist(dist, added);
			added[u] = true;
			for(int v=0;v<V;v++)
			{
				if(!added[v] && graph[u][v]!=0 &&
                         dist[v]>graph[u][v])
				{
					dist[v] =graph[u][v];
					parent[v] = u;
				}
			}
		}
		printMST(parent);
	}
	public static void main(String[] args) {
		int graph[][] = new int[][] {{0, 2, 0, 6, 0},
						            {2, 0, 3, 8, 5},
						            {0, 3, 0, 0, 7},
						            {6, 8, 0, 0, 9},
						            {0, 5, 7, 9, 0},
           };
           /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
		PrimsMinimumSpanningTree obj = new PrimsMinimumSpanningTree(graph);
		obj.getMST(0);
		
	}
}
