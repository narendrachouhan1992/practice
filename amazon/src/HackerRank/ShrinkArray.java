package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class ShrinkArray {
	public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < inputArray.size(); i++) {
			String in = inputArray.get(i);
			String out = "";
			int j = 0;
			if(in.length()==0 || in.length()==1)
			{
				res.add(in);
			}
			else {
				for (j = 0; j < in.length() - 1; j++) {
					if (in.charAt(j) == in.charAt(j + 1)) {
						char curr = in.charAt(j);
						int count = 2;
						j++;
						while (j < in.length() - 1 && curr == in.charAt(j + 1)) {
							count++;
							j++;
						}
						if (count < burstLength) {
							while (count != 0) {
								out += curr;
							}
						}
					} else {
						out += in.charAt(j);
					}
				}
				if(in.charAt(in.length()-1)!=in.charAt(in.length()-2))
				{
					out+=in.charAt(j);
				}
				res.add(out);
			}
			

		}
		return res;
	}
	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("abcddd");
		System.out.println(getShrunkArray(s, 3).toString());
	}
}
