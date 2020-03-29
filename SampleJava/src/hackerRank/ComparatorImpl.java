package hackerRank;

import java.util.Comparator;
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}
public class ComparatorImpl {

	class Checker implements Comparator<Player>
	{

		@Override
		public int compare(Player a, Player b)
	    {
	        if(a.score==b.score)
	        {
	            return a.name.compareTo(b.name);
	        }
	        else 
	        {
	        	return ((Integer)a.score).compareTo(((Integer)b.score));
	        }
	    }
	   
	}
}
