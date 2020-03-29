package HackerRank;

public class EncodeDecode {
	static String secureChannel(int operation, String message, String key) {
        StringBuffer out = new StringBuffer(); 
        System.out.println("operation:"+ operation+", message:"+message+" key:"+key);
        if(message==null || message.isEmpty() || key==null || key.isEmpty() || operation<1 || operation>2)
            return "-1";
        if(operation==1)
        {
            int keyLength = key.length();
            for(int i=0;i<message.length();i++)
            {
                int count = i<keyLength?key.charAt(i)-'0':10;
                char a = message.charAt(i);
                if(!Character.isAlphabetic(a) || count>10 ||count<1)
                   return "-1";
                    out.append(a);
                for(int j=1;j<count && count!=10;j++)
                {
                    a = message.charAt(i);
                   if(Character.isAlphabetic(a));
                           out.append(a);
                }
                
            }
        }
        else
        {
            int keyLength = key.length();
            for(int i=0;i<message.length();i++)
            {
                int count = out.length()<keyLength?key.charAt(out.length())-'0':10;
               char a = message.charAt(i);
                if(!Character.isAlphabetic(a)||  count>10 ||count<1)
                       return "-1";
                out.append(a);
                for(int j=1;j<count && count!=10;j++)
                {
                    if(i+j<message.length() && message.charAt(i) != message.charAt(i+j-1))
                        return "-1";
                    i++;
                }
                
            }
        }
        if(out.toString().isEmpty())
            return "-1";
        return out.toString();
        
    }
	 public static void main(String[] args) {
		System.out.println(secureChannel(2, "Oppeeennnn", "1234"));
	}
}
