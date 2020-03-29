package GeeksForGeeks;

public class NutritionSamsung {
	void findFit(int[][] list, int a, int b, int c)
	{
		
		findFitUntill(list, a,b,c, 0, "");
	}
	void findFitUntill(int[][] list, int a,int b, int c, int pos, String sol)
	{
		if(pos==list.length)
			return;
		if(list[pos][0]==a && list[pos][1]==b && list[pos][2]==c)
		{
			System.out.println(sol+" "+(pos+1));
		}
		else if(list[pos][0]<=a && list[pos][1]<=b && list[pos][2]<=c)
		{
			findFitUntill(list, a,b,c, pos+1, sol);
			a-=list[pos][0];
			b-=list[pos][1];
			c-=list[pos][2];
			findFitUntill(list, a,b,c, pos+1, sol+" "+(pos+1));
		}else
		findFitUntill(list, a,b,c, pos+1, sol);
	}
	public static void main(String[] args) {
		int[][] list = {{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9},
		{9, 18, 12},
		{5, 7, 9}};
		int[] res = {11,13,15};
		NutritionSamsung obj = new NutritionSamsung();
		obj.findFit(list, 11,13,15);
	}
}
