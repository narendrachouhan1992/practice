package interview;

import java.util.Arrays;

public class RepetationOfChar {
	static int[] solve(int N, int Q, String ss, char[] type, char[] ch, int[] x) {
        // Write your code  and print values for each query here
		int sol[] = new int[Q];
		for(int i=0;i<Q;i++)
		{
			int sIndex = 0;
			int count =0;
			while(sIndex<N && count< x[i])
			{
				if(ss.charAt(sIndex) == ch[i])
					count++;
				sIndex++;
			}
			if(type[i]=='S')
			{
				sol[i] = sIndex;
			}
			else
			{
				while(sIndex<N && ss.charAt(sIndex)!= ch[i])
				{
					sIndex++;
				}
				sol[i] = sIndex;
			}
		}
		return sol;
    }
	public static void main(String[] args) {
		String s = "abaaba";
		char[] type = {'L'};
		char[] ch = {'a'};
		int[] x = {1};
		System.out.println(Arrays.toString(solve(6, 1, s,type , ch, x)));
	}
}
