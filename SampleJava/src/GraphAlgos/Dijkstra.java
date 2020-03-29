package GraphAlgos;

public class Dijkstra {
	int[][] graph;
	int V;
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
	void printSolution(int[] dist)
	{
		System.out.println("vertex      distance from source");
		for(int i=0;i<dist.length;i++)
		{
			System.out.println(i+"      "+ dist[i]);
		}
	}
	void dijkstra(int src)
	{
		int[] dist = new int[V];
		for(int i=0;i<V;i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		boolean[] added = new boolean[V];
		for(int count = 0;count<V-1;count++)
		{
			int u = getMinDist(dist, added);
			added[u] = true;
			for(int v=0;v<V;v++)
			{
				if(!added[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE && dist[v]>dist[u]+graph[u][v])
				{
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		printSolution(dist);
	}
	public Dijkstra(int[][] graph) {
		this.V = graph.length;
		this.graph = graph;
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
		Dijkstra g = new Dijkstra(graph);
		g.dijkstra(0);
	}
}
