package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude)
    {
    	Map<String, Integer> counts = new HashMap<>();
    	Set<String> exc = new HashSet<String>();
    	for (String word : wordsToExclude) {
    
			exc.add(word.toLowerCase());
		}
    	literatureText = literatureText.replaceAll("[^A-Za-z]", " ");
    	String[] inWords = literatureText.split(" ");
    	
    	for(int i=0;i<inWords.length;i++)
    	{
    		if(exc.contains(inWords[i].toLowerCase()))
    		{
    			continue;
    		}
    		if(counts.containsKey(inWords[i].toLowerCase()))
    		{
    			int freq = counts.get(inWords[i].toLowerCase());
    			counts.put(inWords[i].toLowerCase(), freq+1);
    		}
    		else
    		{
    			counts.put(inWords[i].toLowerCase(), 1);
    		}
    	}
    	if(counts.containsKey(""))
    	{
    	    counts.remove("");
    	}
    	int max = 0;
    	for (Map.Entry<String, Integer> entry : counts.entrySet())
    	{
    	    max = Integer.max(entry.getValue(), max);
    	}
    	List<String> res = new ArrayList<String>();
    	for (Map.Entry<String, Integer> entry : counts.entrySet())
    	{
    	    if(max == entry.getValue())
    	    	res.add(entry.getKey());
    	}
    	return res;
    }
    public static void main(String[] args) {
		Solution obj = new Solution();
		List<String> ex = new ArrayList<String>();
		ex.add("and");
		ex.add("he");
		ex.add("the");
		ex.add("to");
		ex.add("is");
//		ex.add("is");
//		ex.add("are");
//		ex.add("a");
		System.out.println(obj.retrieveMostFrequentlyUsedWords("Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.", ex));
//		System.out.println(obj.retrieveMostFrequentlyUsedWords("Rose is a flower red rose are flower", ex));
	}
    // METHOD SIGNATURE ENDS
}
