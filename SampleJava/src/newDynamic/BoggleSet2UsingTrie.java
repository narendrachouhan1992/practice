package newDynamic;

import org.w3c.dom.css.ViewCSS;

class Trie
{
	Trie[] next = new Trie[26];
	char c;
	boolean isLeaf = false;
	public Trie(char c, boolean isLeaf) {
		this.c = c;
		this.isLeaf = isLeaf;
	}
}
public class BoggleSet2UsingTrie {
	Trie root = new Trie(' ', false);
	void printWords(char[][] boggle, String[] words)
	{
		for(int i=0;i<words.length;i++)
		{
			Trie curr = root;
			int j = 0;
			for( j=0;j<words[i].length()-1;j++)
			{
				if(curr.next[words[i].charAt(j) - 'A'] == null)
				{
					curr.next[words[i].charAt(j) - 'A'] = new Trie(words[i].charAt(j), false);	
				}
				curr = curr.next[words[i].charAt(j) - 'A'];
			}
			if(curr.next[words[i].charAt(j) - 'A'] == null)
			{
				curr.next[words[i].charAt(j) - 'A'] = new Trie(words[i].charAt(j), true);
			}
			else
			{
				curr.next[words[i].charAt(j) - 'A'].isLeaf = true;
			}
		}
		findWordsUntil(boggle);
	}
	void findWordsUntil(char[][] boggle)
	{
		boolean[][] visited = new boolean[boggle.length][boggle[0].length];
		for(int i=0;i<boggle.length;i++)
		{
			for(int j=0;j>boggle[0].length;j++)
			{
				Trie curr = root;
				if(curr.next[boggle[i][j]-'A']!= null)
				{
					printAllWords(boggle, visited, i, j, curr.next[boggle[i][j]-'A'], Character.toString(boggle[i][j]));
				}
			}
		}
	}
	boolean isSafe(boolean[][] visited, int i, int j, char[][] boggle, Trie curr)
	{
		if(i<visited.length && j<visited[0].length && i>=0 && j>= 0 && !visited[i][j])
		{
			if(curr.next[boggle[i][j] - 'A']!= null)
				return true;
		}
		return false;
	}
	void printAllWords(char[][] boggle,boolean[][] visited, int i, int j, Trie curr, String res)
	{
		visited[i][j] = true;
		res = res + Character.toString(boggle[i][j]); 
		if(curr.isLeaf)
		{
			System.out.println(res);
		}
		if(isSafe(visited, i+1, j, boggle, curr))
		{
			printAllWords(boggle, visited, i+1, j, curr, res);
		}
		if(isSafe(visited, i+1, j+1, boggle, curr))
		{
			printAllWords(boggle, visited, i+1, j+1, curr, res);
		}
		if(isSafe(visited, i, j+1, boggle, curr))
		{
			printAllWords(boggle, visited, i, j+1, curr, res);
		}
		if(isSafe(visited, i-1, j+1, boggle, curr))
		{
			printAllWords(boggle, visited, i-1, j+1, curr, res);
		}
		if(isSafe(visited, i-1, j, boggle, curr))
		{
			printAllWords(boggle, visited, i-1, j, curr, res);
		}
		if(isSafe(visited, i-1, j-1, boggle, curr))
		{
			printAllWords(boggle, visited, i-1, j-1, curr, res);
		}
		if(isSafe(visited, i, j-1, boggle, curr))
		{
			printAllWords(boggle, visited, i, j-1, curr, res);
		}
		if(isSafe(visited, i+1, j-1, boggle, curr))
		{
			printAllWords(boggle, visited, i+1, j-1, curr, res);
		}
	}
	public static void main(String[] args) {
		BoggleSet2UsingTrie obj = new BoggleSet2UsingTrie();
		char[][] boggle = {{'G','I','Z'},
		        {'U','E','K'},
		        {'Q','S','E'}
		};
		String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GEE"};
		obj.printWords(boggle, dictionary);
	}
}
