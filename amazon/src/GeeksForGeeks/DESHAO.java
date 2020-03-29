package GeeksForGeeks;

import java.util.List;
import java.util.stream.Collectors;

public class DESHAO {
	 public static int maxProduct(List<Integer> nums)
	    {   
		 nums = nums.stream().filter(s-> s!=0).collect(Collectors.toList());
		 int negativeCount = 0;
		 int largestNeg = Integer.MAX_VALUE;;
		 for (int i=0;i<nums.size();i++) {
			if(nums.get(i)<0 )
			{
				negativeCount++;
				if(0-nums.get(i) <largestNeg)
				{
					largestNeg = i;
		 		}
			}
		 }	      
	    if(negativeCount%2!= 0)
	    {
	    	nums.remove(largestNeg);
	    }
	    int prod = 1;
	    for (Integer i : nums) {
			prod*=i;
		}
	    return prod;
    }
	 }

