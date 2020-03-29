package newDynamic;

public class MinimumStepsToReachADestination {
	int getMinSteps(int source, int dest, int steps)
	{
		if(Math.abs(source) > Math.abs(dest))
		{
			return Integer.MAX_VALUE;
		}
		if(Math.abs(source)== Math.abs(dest))
			return steps;
		int pos = getMinSteps(source+steps+1, dest, steps+1);
		int neg = getMinSteps(source-steps-1, dest, steps+1);
		return Integer.min(pos, neg);
	}
	public static void main(String[] args) {
		MinimumStepsToReachADestination obj = new MinimumStepsToReachADestination();
		System.out.println(obj.getMinSteps(0, 11, 0));
	}
}
