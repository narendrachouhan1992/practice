package hackerRank;

public class KangarooJump {
	 static String kangaroo(int x1, int v1, int x2, int v2) 
	 {
		 int reletiveDistance = x2-x1;
		 int relativeVelocity = v2-v1;
		 float time = reletiveDistance/relativeVelocity;
		 if(time<0 &&(time%1 == 0))
		 {
			 return "YES";
			 
		 }
		 return "NO";
	 }
	 public static void main(String[] args) {
		
		System.out.println(kangaroo(0, 2, 5, 3));
		
	}
}
