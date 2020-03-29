package newDynamic;

public class PrintUniqueRows {
	class NodeB
	{
		NodeB[] child = new NodeB[2];
	}
	void printUnique(boolean[][] arr)
	{
		NodeB tri = new NodeB();
		NodeB temp = tri;
		for(int i =0;i<arr.length;i++)
		{
			for(int j =0;j<arr[0].length;j++)
			{
				if(arr[i][j])
				{
					if(temp.child[1] == null)
						temp.child[1] = new NodeB();	
					temp = temp.child[1];
				}
				else
				{
					if(temp.child[0] == null)
						temp.child[0] = new NodeB();	
					temp = temp.child[0];
				}
			}
			temp = tri;
		}
		int length = arr[0].length;
		
		printUniqueFromtri(tri, 0, length, "");
	}
	void printUniqueFromtri(NodeB tri,int curr,int max, String res)
	{
		if(curr == max)
		{
			System.out.println(res);
		}
		if(tri.child[0]!= null)
		{
			printUniqueFromtri(tri.child[0], curr+1, max, res+0);
		}
		if(tri.child[1]!= null)
		{
			printUniqueFromtri(tri.child[1], curr+1, max, res+1);
		}
	}
	public static void main(String[] args) {
		PrintUniqueRows obj = new PrintUniqueRows();
		boolean[][] arr = {{false, true, false, false, true},
		        {true, false, true, true, false},
		        {false, true, false, false, true},
		        {true, false, true, false, false}
		    };
		obj.printUnique(arr);
	}
}
