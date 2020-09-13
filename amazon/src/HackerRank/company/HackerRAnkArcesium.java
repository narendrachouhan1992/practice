package HackerRank.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Player
{
	private String name;
	private float height;
	private float bmi;
	private int score;
	private int defend;
	public Player(String name, String height, String bmi, String score, String defend) {
		super();
		this.name = name;
		this.height = Float.parseFloat(height);
		this.bmi = Float.parseFloat(bmi);
		this.score = Integer.parseInt(score);
		this.defend = Integer.parseInt(defend);
	}
	public String getName() {
		return name;
	}
	public float getHeight() {
		return height;
	}
	public float getBmi() {
		return bmi;
	}
	public int getScore() {
		return score;
	}
	public int getDefend() {
		return defend;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(bmi);
		result = prime * result + defend;
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (Float.floatToIntBits(bmi) != Float.floatToIntBits(other.bmi))
			return false;
		if (defend != other.defend)
			return false;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
}
public class HackerRAnkArcesium {

    public static List<List<String>> getSelectionStatus1(List<List<String>> applications) 
    {
    	for (List<String> list : applications) {
			for (String s : list) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
    	List<Player> players = new ArrayList<Player>();
    	for (List<String> p: applications) {
			Player plyr = new Player(p.get(0), p.get(1), p.get(2), p.get(3), p.get(4));
			players.add(plyr);
		}
    	List<Player> elegible = players.stream().filter(s->checkElegible(s)).collect(Collectors.toList());
    	List<Player> strikers = elegible.stream().filter(s->isStricker(s)).collect(Collectors.toList());
    	List<Player> defenders = elegible.stream().filter(s->isDefender(s)).collect(Collectors.toList());
    	Collections.sort(strikers, (a,b)-> a.getScore()>b.getScore()?-1:1);
    	Collections.sort(defenders, (a,b)-> a.getDefend()>b.getDefend()?-1:1);
    	Map<Player, Character> selected = new HashMap<Player, Character>();
    	
    	for(int i=0;i<Integer.min(strikers.size(), defenders.size());i++)
    	{
    		selected.put(strikers.get(i), 'S');
    		selected.put(defenders.get(i), 'D');
    	}
    	
    	List<List<String>> out = new ArrayList<List<String>>();
    	for (Player player : players) {
    		if(selected.containsKey(player))
    		{
    			if(selected.get(player)=='S')
    				out.add(flatPlayer(player, true, false));
    			else
    				out.add(flatPlayer(player, true, true));
    		}
    		else
    		{
    			out.add(flatPlayer(player, false, false));
    		}
		}
    	return out;
    }	
    public static List<List<String>> getSelectionStatus(List<List<String>> applications) 
    {
    	for (List<String> list : applications) {
			for (String s : list) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
    	List<Player> players = new ArrayList<Player>();
    	for (List<String> p: applications) {
			Player plyr = new Player(p.get(0), p.get(1), p.get(2), p.get(3), p.get(4));
			players.add(plyr);
		}
    	List<Player> elegible = players.stream().filter(s->checkElegible(s)).collect(Collectors.toList());
    	List<Player> strikers = elegible.stream().filter(s->isStricker(s)).collect(Collectors.toList());
    	List<Player> defenders = elegible.stream().filter(s->isDefender(s)).collect(Collectors.toList());
    	Map<Player, Character> selected = new HashMap<Player, Character>();
    	
    	int diff = Math.abs(strikers.size()-defenders.size());
    	if(strikers.size()>defenders.size())
    	{
    		for (Player p : defenders) {
				if(diff!=0 && strikers.contains(p))
				{
					strikers.remove(p);
					diff--;
				}
			}
    	}
    	else
    	{
    		for (Player p : strikers) {
				if(diff!=0 && defenders.contains(p))
				{
					defenders.remove(p);
					diff--;
				}
			}
    	}
    	for(int i=0;i<Integer.min(strikers.size(), defenders.size());i++)
    	{
    		selected.put(strikers.get(i), 'S');
    		selected.put(defenders.get(i), 'D');
    	}

    	List<List<String>> out = new ArrayList<List<String>>();
    	for (Player player : players) {
    		if(selected.containsKey(player))
    		{
    			if(selected.get(player)=='S')
    				out.add(flatPlayer(player, true, false));
    			else
    				out.add(flatPlayer(player, true, true));
    		}
    		else
    		{
    			out.add(flatPlayer(player, false, false));
    		}
		}
    	return out;
    }	
    private static List<String> flatPlayer(Player player, boolean selected, boolean defender)
    {
    	List<String> res = new ArrayList<String>();
    	res.add(player.getName());
    	res.add(selected?"SELECT":"REJECT");
    	res.add(selected?(defender?"DEFENDER":"STRIKER"):"NA");
    	return res;
    }
    private static boolean checkElegible(Player player)
    {
    	if(player==null || player.getHeight()<5.8 || player.getBmi() >23)
    		return false;
    	return true;
    }
    private static boolean isStricker(Player player)
    {
    	if (player==null || player.getScore()<50) 
    		return false;
    	return true;
    }
    private static boolean isDefender(Player player)
    {
    	if (player==null || player.getDefend()<30) 
    		return false;
    	return true;
    }
    public static void main(String[] args) {
		List<List<String>> in = new ArrayList<List<String>>();
		in.add(Arrays.asList("Boateng 6.1 22 24 45".split(" ")));
		in.add(Arrays.asList("Kaka 6 22 1 1".split(" ")));
		in.add(Arrays.asList("Ramos 6.3 22 67 70".split(" ")));
		System.out.println(getSelectionStatus(in));
	}
}
