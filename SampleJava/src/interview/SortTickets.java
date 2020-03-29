package interview;

import java.util.HashMap;
import java.util.Map;

public class SortTickets {
	static String sort_tickets(String[] tickets) {
		Map<String, String> sdMap = new HashMap<String, String>();
		Map<String, String> dsMap = new HashMap<String, String>();
		for(int i=0;i<tickets.length;i++)
		{
			String src = tickets[i].split(" ")[0];
			String dest = tickets[i].split(" ")[1];	
			sdMap.put(src, dest);
			dsMap.put(dest, src);
		}
		String res = tickets[0].split(" ")[0];
		String lastSrs = tickets[0].split(" ")[0];
		String lastDest = tickets[0].split(" ")[0];
		while(sdMap.get(lastSrs)!= null)
		{
			res += (" "+sdMap.get(lastSrs));
			lastSrs = sdMap.get(lastSrs);
		}
		while(dsMap.get(lastDest)!= null)
		{
			res = (dsMap.get(lastDest) + " ") + res;
			lastDest = dsMap.get(lastDest);
		}
		return res;
    }
	public static void main(String[] args) {
		String[] tickets = { "goa bengaluru","delhi mumbai","bengaluru chennai", "mumbai goa" };
		System.out.println(sort_tickets(tickets));
	}
}
