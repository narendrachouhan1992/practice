	package newDynamic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
class CharactorAndCount implements Comparator<CharactorAndCount>
{
	char charactor;
	int freq;
	
    public CharactorAndCount(char charactor, int freq) {
		super();
		this.charactor = charactor;
		this.freq = freq;
	}
    public CharactorAndCount() {
    	super();
    }
	@Override
    public int compare(CharactorAndCount arg0, CharactorAndCount arg1) {
        if(arg0.freq > arg1.freq)
            return -1;
        else
            return 1;
    }
}
public class RearrangeCharactersStringNoTwoAdjacent {
	
	String rearrange(String str)
	{
		CharactorAndCount cc = new CharactorAndCount();
		Queue<CharactorAndCount> pq = new PriorityQueue<CharactorAndCount>(cc);
		int[] count = new int[26];
		int length = str.length();
		for(int i =0;i<length;i++)
		{
			count[str.charAt(i)-'a']++;
		}
		for(char i ='a';i<'z';i++)
		{
			if(count[i-'a']!= 0)
			{
				pq.add(new CharactorAndCount(i, count[i - 'a']));
			}
		}
		CharactorAndCount prev = new CharactorAndCount('#', -1);
		String res ="";
		while(!pq.isEmpty())
		{
			CharactorAndCount temp = pq.peek(); 
			res+= temp.charactor;
			pq.poll();
			if(prev.freq>0)
				pq.add(prev);
			temp.freq--;
			prev = temp;				
		}
		if(str.length()!= length)
		{
			return "";
		}
		return res;
	}
	public static void main(String[] args) {
		RearrangeCharactersStringNoTwoAdjacent obj = new RearrangeCharactersStringNoTwoAdjacent();
		 String str = "bbbaa" ;
		 System.out.println(obj.rearrange(str));
	}
}
