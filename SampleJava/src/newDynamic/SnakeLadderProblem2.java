package newDynamic;

import java.util.LinkedList;
import java.util.Queue;

class Block
{
	int stepNum;
	int position;
}
public class SnakeLadderProblem2 {
	int getMin(int[] moves)
	{
		int size = moves.length;
		Queue<Block> q = new LinkedList<Block>();
		Block b = new Block();
		b.position = 0;
		b.stepNum = 0;
		q.add(b);
		boolean[] visited = new boolean[size];
		visited[0] = true;
		while(!q.isEmpty())
		{
			b = q.poll();
			if(b.position == size-1)
			{
				break;
			}
			for(int i = b.position+1;i<= b.position+6 && i<size;i++)
			{
				if(!visited[i])
				{
					Block nb = new Block();
					nb.stepNum = b.stepNum+1;
					if(moves[i] != -1)
					{
						nb.position = moves[i];
					}
					else
					{
						nb.position = i;
					}
					q.add(nb);
				}
				
				
			}
		}
		return b.stepNum;
	}
	public static void main(String[] args) {
		SnakeLadderProblem2 obj = new SnakeLadderProblem2();
		int N = 30;
		int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;
 
        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;
 
        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
 
        System.out.println("Min Dice throws required is " + 
                          obj.getMin(moves));
	}
}
