package HackerRank;

public class StringEncryption {
	static String encryption(String s) {
		s = String.join("", s.split(" "));
		int size = s.length();
		int rows = (int) Math.floor(Math.sqrt(size));
		int cols = (int) Math.ceil(Math.sqrt(size));
		if(size>rows*cols)
		{
			rows=cols;
		}
		char[][] res = new char[rows][cols];
		int x=0;
		boolean done = false;
		for(int i=0;i<rows && !done;i++)
		{
			for(int j=0;j<cols && !done;j++)
			{
				
				if(s.length()==x)
				{
					done = true;
					break;
				}
				res[i][j] = s.charAt(x++);
				
			}
		}
		String resStr = "";
		for(int i=0;i<cols;i++)
		{
			for(int j=0;j<rows;j++)
			{
				if(res[j][i] != ' ' && res[j][i] != 0)
					resStr+=res[j][i];
			}
			resStr+=' ';
		}
//		while(resStr.charAt(resStr.length()-1)== ' ' || resStr.charAt(resStr.length()-1)== '\n' || resStr.charAt(resStr.length()-1)== '\r' || resStr.charAt(resStr.length()-1)== 0)
//		{
//			resStr =  resStr.substring(0, resStr.length()-1);
//		}
		return resStr;		
    }
	public static void main(String[] args) {
		System.out.println(encryption("feedthedog"));
	}
//imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau

}
