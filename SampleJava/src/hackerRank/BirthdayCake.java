package hackerRank;

import java.util.List;

public class BirthdayCake {
    static int birthday(List<Integer> s, int d, int m) {
    	if(s==null || s.size()==0 || s.size()<m)
    	{
    		return 0;
    	}
    	int sol=0;
    	int sum =0;
    	for(int i=0;i<m;i++)
    	{
    		sum+=s.get(i);
    	}
    	
    	if(sum==d)
    		sol++;
    	for(int i= m;i<s.size();i++)
    	{
    		sum+=s.get(i);
    		sum-=s.get(i-m);
    		if(sum==d)
    			sol++;
    	}
    	return sol;
    }
}
