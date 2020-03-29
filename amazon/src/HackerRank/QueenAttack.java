package HackerRank;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QueenAttack {
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

		int numberOfMoves = 0;
		int qr = r_q;
		int qc = c_q;
		Set<String> ob = new HashSet<String>();
		for(int i=0;i<obstacles.length;i++)
		{
			ob.add(Integer.toString(obstacles[i][0])+"-"+Integer.toString(obstacles[i][1]));
		}
		
		
		while(isSafe(qr+1, qc+1, n, ob))
		{
			numberOfMoves++;
			qr++;
			qc++;
		}
		
		qc = c_q;
		qr = r_q;
		while(isSafe(qr+1, qc-1, n, ob))
		{
			numberOfMoves++;
			qr++;
			qc--;
		}
		qc = c_q;
		qr = r_q;
		while(isSafe(qr-1, qc+1, n, ob))
		{
			numberOfMoves++;
			qr--;
			qc++;
		}
		qc = c_q;
		qr = r_q;
		while(isSafe(qr-1, qc-1, n, ob))
		{
			numberOfMoves++;
			qr--;
			qc--;
		}
		 qr = r_q;
		 qc = c_q;
		while(isSafe(qr+1, qc, n, ob))
		{
			numberOfMoves++;
			qr++;
		}
		 qr = r_q;
		 qc = c_q;
		while(isSafe(qr, qc+1, n, ob))
		{
			numberOfMoves++;
			qc++;
		}
		 qr = r_q;
		 qc = c_q;
		while(isSafe(qr-1, qc, n, ob))
		{
			numberOfMoves++;
			qr--;
		}
		 qr = r_q;
		 qc = c_q;
		while(isSafe(qr, qc-1, n, ob))
		{
			numberOfMoves++;
			qc--;
		}
		
		
		return numberOfMoves;
    }
	static boolean isSafe(int r, int c, int n, Set<String> obstacles)
	{
		if(r>n || c>n || r<1 || c<1| obstacles.contains(Integer.toString(r)+"-"+Integer.toString(c)))
		{
			return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		int[][] ob = {{5,5},{4,2},{2,3}};
		System.out.println(queensAttack(5, 3, 4, 3, ob));
	}
}
