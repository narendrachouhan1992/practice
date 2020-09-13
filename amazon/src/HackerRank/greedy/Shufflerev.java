package HackerRank.greedy;

public class Shufflerev {
	static String reverseShuffleMerge(String s) {
		char[] map = new char[26];
		for(int i=0;i<s.length();i++)
		{
			map[s.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++)
			map[i]/=2;
		

		return null;
	}
}
