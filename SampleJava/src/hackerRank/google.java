package hackerRank;

Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.
Q1
Hi
1)
Class Node
{
	Boolean visited = false;
	Int distRoot;
	List<Integer> distance;
	List<Node> nodes;
}

Class TimeFinder
{
int maxTime = Integer.MIN;

Void findTimeUntil(Node curr, int dist)
{
		if(curr.nodes.isEmpty())
		{
			if(dist>maxTime)
				maxTime=dist;
			return;
		}
		Else
{
	int size = curr.nodes.length();
		for(int i=0;i<size;i++)
{					findTimeUntil(curr.nodes.getAt(i), curr.distances.getAt(i)+dist)
		}

}
		
}
Void findTime(Node curr)
{
	int size = curr.nodes.length();
	for(int i=0;i<size;i++)
{
		findTimeUntil(curr.nodes.getAt(i), curr.distances.getAt(i))
	}
	Return max;
}

}




Q2
Hi
Class Node
{
	Int distRoot=Integer.Max;
	List<Integer> distance;
	List<Node> nodes;
}

Class TimeFinder
{
Int max = integer.min;

Void findTimeUntil(Node curr, int dist)
{
	int size = curr.nodes.length();
		if(curr.distRoot>dist)
{
	curr.distRoot=dist;
for(int i=0;i<size;i++)
{
findTimeUntil(curr.nodes.getAt(i), curr.distances.getAt(i)+dist)
	}
}
		
}
int findTime(Node curr)
{
	int size = curr.nodes.length();
	for(int i=0;i<size;i++)
{
		findTimeUntil(curr.nodes.getAt(i), curr.distances.getAt(i))
	}
	Return maxDist = getMax(curr);
}
	Int getMax(curr)
	{
		if()
}
}



    6         8
X1 -----> X2 ←----X3
|        |       /\
| 2      |4        |
|        |        | 9
\/       \/       |
X6 ----> X5 ----> X4
   3        5


0---6-->0
|\	 1
2 \2	 |
|   \	 |
\/   \	\/
0<---9--0




