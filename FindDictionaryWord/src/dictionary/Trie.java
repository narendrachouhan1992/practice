package dictionary;

class DcNode
{
	char c;
	boolean isComplete = false;
	DcNode[] path = new DcNode[256];
}
public class Trie {
	private static Trie dc;
	DcNode tree = new DcNode();
	private Trie() {
		// TODO Auto-generated constructor stub
	}
	public static Trie getDict()
	{
		if(dc == null)
		{
			dc = new Trie();
		}
		return dc;
	}
	void addWord(String word)
	{
		DcNode temp = tree;
		for(int i=0;i<word.length(); i++)
		{
			if(temp.path[word.charAt(i)] == null )
			{
				temp.path[word.charAt(i)] = new DcNode();
				temp.path[word.charAt(i)].c = word.charAt(i);
			}
			temp = temp.path[word.charAt(i)];
		}
		temp.isComplete = true;
	}
	boolean findWord(String str)
	{
		DcNode temp = tree;
		for(int i=0;i<str.length();i++)
		{
			if(temp.path[str.charAt(i)] == null)
			{
				return false;
			}
			temp = temp.path[str.charAt(i)];
		}
		return temp.isComplete;
		
	}
}
