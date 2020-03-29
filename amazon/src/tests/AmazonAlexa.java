package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class FreqSet implements Comparable<FreqSet>
{
	String name;
	int freq;
	public FreqSet(String name, int freq) {
		this.name=name;
		this.freq=freq;
	}
	@Override
	public int compareTo(FreqSet o) {
		if(this.freq>o.freq)
			return -1;
		return 1;
	}
}
public class AmazonAlexa {
	public ArrayList<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
			int numReviews, List<String> reviews) {
		

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String copatitor : competitors) {
			map.put(copatitor, 0);
		}
		for (String review : reviews) {
			String[] ws = review.split(" ");
			for (int i = 0; i < ws.length; i++) {
				if(map.containsKey(ws[i]))
				{
					map.put(ws[i], map.get(ws[i])+1);
				}
			}
		}
		Queue<FreqSet> fs = new PriorityQueue<FreqSet>();
		map.forEach((k,v)->{
			FreqSet obj = new FreqSet(k, v);
			fs.add(obj);
		});
		
		ArrayList<String> freqW = new ArrayList<String>();
		
		for(int i=0;i<topNCompetitors;i++)
		{
			freqW.add(fs.poll().name);
		}
		return freqW;
	}
	public static void main(String[] args) {
		AmazonAlexa obj = new AmazonAlexa();
		ArrayList<String> comp = new ArrayList<String>();
		comp.add("abc");
		comp.add("ab");
		comp.add("aby");
		
	}
}
