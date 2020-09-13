package HackerRank;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;

public class RankingUp {
	static int[] climbingLeaderboard1(int[] scores, int[] alice) 
	{
		int[] res = new int[alice.length];
		TreeSet<Integer> unique = new TreeSet<Integer>();
		for (int i = 0; i < scores.length; i++)
			unique.add(scores[i]);
		boolean has = true;
		for (int i = 0; i < alice.length; i++) {
			if(unique.contains(alice[i]));
				has = true;
			
			unique.add(alice[i]);

			res[i] = unique.size()-unique.headSet(alice[i]).size();
			if(!has)
			{
				unique.remove(alice[i]);
				has = true;
			}
		}
		return res;		
	}
	static int[] climbingLeaderboard2(int[] scores, int[] alice) 
	{
		int[] res = new int[alice.length];
		TreeSet<Integer> unique = new TreeSet<Integer>();
		for (int i = 0; i < scores.length; i++)
			unique.add(scores[i]);
		Integer[] nums = unique.stream().toArray(Integer[]:: new);
		for (int i = 0; i < alice.length; i++) 
		{
			int curr = nums.length-1;
			while (curr>=0 && nums[curr]>alice[i]) 
			{
				curr--;
			}
			if (curr==-1 || nums[curr]==alice[i]) {
				res[i] = unique.size() - curr;
			}
			else
			{
				res[i] = unique.size() - curr;
			}
		}
		return res;		
	}
	static int[] climbingLeaderboard(int[] scores, int[] alice) 
	{
		Stack<Integer> st = new Stack<Integer>();
		int[] res = new int[alice.length];
		for (int i = 0; i < scores.length; i++) {
			if(st.size()==0 || scores[i] != st.peek())
				st.push(scores[i]);
		}
		for (int i = 0; i < alice.length; i++) {
			while(st.size()>0 && st.peek()<=alice[i])
				st.pop();
			res[i] = st.size()+1;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {100, 100, 50, 40, 40, 20, 10};
		int[] alis = {5, 25, 50, 120};
		System.out.println(Arrays.toString(climbingLeaderboard(arr, alis)));
	}
}
