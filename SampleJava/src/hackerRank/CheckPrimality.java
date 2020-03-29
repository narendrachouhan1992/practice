package hackerRank;

public class CheckPrimality {
	static String primality(int n) {
		if(n<=1)
			return "Not prime";
		if(n==2 || n==3)
			return "Prime";
		if(n%2 == 0 || n%3 == 0)
			return "Not prime";
		for(int i=5; i*i<n; i = i+6)
		{
			if(n%i== 0 || n%(i+2) == 0)
				return "Not prime";
		}
		return "Prime";
    }
	public static void main(String[] args) {
		System.out.println(primality(12));
	}
}
