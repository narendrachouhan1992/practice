import java.util.Scanner;

public class Validator {
	static void validate(String s) throws AlphaNeumericException, StringException
	{
		Scanner 
		if(s.matches(".*\\d.*"))
			{
			
			};
		try
		{
			Double.parseDouble(s)
			Integer.parseInt(s);
		} catch(NumberFormatException e){
			return false;
		}
		if(s==null)
		throw new AlphaNeumericException("");
		
		throw new StringException("");
	}
}
