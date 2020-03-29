package HackerRank;

public class Bivalued {
	 public int solution(int[] A) {
		 int a=0;
		 int aC=0;
		 int b=0;
		 int bC=0;
		 int num = 0;
		 int maxLength = 0;
				 int  start = 0;
		 int currLnegth = 0;
		 for(int i=0;i<A.length;i++)
		 {
			 if(num ==0)
			 {
				 a=A[i];
				 aC=1;
				 num =1;
				 currLnegth++;
			 }
			 else if(num==1)
			 {
				 b = A[i];
				 bC=1;
				 num =2;
				 currLnegth++;
			 }
			 else
			 {
				 if(a==A[i] || b== A[i])
				 {
					 if(a==A[i])
						 aC++;
					 else
						 bC++;
					 
					 currLnegth++;
				 }
				 else
				 {
					 maxLength = Integer.max(currLnegth, maxLength);
					 while(num!=1)
					 {
						 if(a==A[start])
						 {
							 aC--;
							 if(aC==0)
							 {
								 num=1;
								 a=b;
								 aC=bC;
							 }
						 }
						 else
						 {
							 bC--;
							 if(bC==0)
								 num=1;
						 }
						 start++;
						 currLnegth--;
					 }
					 i--;
				 }
			 }
		 }
		 return Integer.max(maxLength, currLnegth);
	 }
	 public static void main(String[] args) {
		Bivalued obj = new Bivalued();
		int[] A = {4, 2, 2, 4, 2};
		System.out.println(obj.solution(A));
	}
}
