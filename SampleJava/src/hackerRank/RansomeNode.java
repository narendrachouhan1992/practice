package hackerRank;

import java.util.*;

public class RansomeNode {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomeNode(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();
        String[] magazineWords = magazine.split(" ");
        for (String word : magazineWords) {
			if(magazineMap.get(word)==null)
				magazineMap.put(word, 1);
			else
				magazineMap.put(word, magazineMap.get(word)+1);
		}
        String[] noteWords = note.split(" ");
        for (String word : noteWords) {
			if(noteMap.get(word)==null)
				noteMap.put(word, 1);
			else
				noteMap.put(word, noteMap.get(word)+1);
		}
    }
    
    public boolean solve() {
    	Set<String> keys = noteMap.keySet();
    	for (String key : keys) {
			if(magazineMap.get(key) == null || magazineMap.get(key) < noteMap.get(key))
			{
				return false;
			} 
			else {
				magazineMap.put(key, magazineMap.get(key)-noteMap.get(key));
			}
		}
        return true;
    }

    public static void main(String[] args) {
        RansomeNode s = new RansomeNode("two times three is not four", "two times two is four");
      
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
