package HackerRank;

public class VirusAdvertisement {
	 static int viralAdvertising(int n) {
		 int like =2;
		 if(n==1)
			 return 2;
		 int curr = 2;
		 for(int i=2;i<=n;i++)
		 {
			 curr= (3*curr/2);
			 like +=curr;
		 }
		 return like;
    }
	 public static void main(String[] args) {
		System.out.println(viralAdvertising(3));
	}
}
