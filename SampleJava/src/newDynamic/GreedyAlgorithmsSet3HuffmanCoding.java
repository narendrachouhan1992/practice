package newDynamic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


class HuffmanNode
{
	int freq;
	char character;
	HuffmanNode left;
	HuffmanNode right;
	public HuffmanNode(int freq, char character) {
		super();
		this.freq = freq;
		this.character = character;
	}
	void printCode(String s)
	{
		if(this.character != '-')
		{
			System.out.println("code for char "+this.character + " is "+ s);
		}
		if(this.left!= null)
			this.left.printCode(s+"0");
		if(this.right != null)
			this.right.printCode(s+"1");
	}
	
}
class myComparator implements Comparator<HuffmanNode>
{
	public int compare(HuffmanNode o1, HuffmanNode o2) {
		return o1.freq -o2.freq;
	}
}
public class GreedyAlgorithmsSet3HuffmanCoding {
	void printHuffmanCode(int[] freq, char[] c)
	{
		myComparator mc = new myComparator();
		Queue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(mc);
		int length = freq.length;
		for(int i=0;i<length;i++)
		{
			HuffmanNode temp = new HuffmanNode(freq[i], c[i]);
			q.add(temp);
		}
		
		HuffmanNode root ;
		while(q.size() != 1)
		{
			HuffmanNode a = q.poll();
			HuffmanNode b = q.poll();
			HuffmanNode temp = new HuffmanNode((a.freq+b.freq), '-');
			temp.left = a;
			temp.right = b;
			q.add(temp);
		}
		root = q.poll();
		root.printCode("");
	}
	public static void main(String[] args) {
		GreedyAlgorithmsSet3HuffmanCoding obj = new GreedyAlgorithmsSet3HuffmanCoding();
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        obj.printHuffmanCode(charfreq, charArray);
	}
}
