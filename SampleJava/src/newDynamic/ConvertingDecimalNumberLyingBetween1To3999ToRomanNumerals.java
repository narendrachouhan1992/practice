package newDynamic;

public class ConvertingDecimalNumberLyingBetween1To3999ToRomanNumerals {
	String convertRoman(int num)
	{
		String res = "";
		int mul = 0;;
		int rem = 0;;
		if(num == 0)
			return "";
		if(num>=1000)
		{
			mul = num/1000;
			rem = num%1000;
			for(int i=0;i<mul ;i++)
				res+= "M";
			num = rem;
		}
		if(num>=500)
		{
			if(num>900)
			{
				res+= "CM";
				num = num-900;
			}
			else
			{
				mul = num/500;
				rem = num%500;
				for(int i=0;i<mul ;i++)
					res+= "D";
				num = rem;
			}
			
		}
		if(num>=100)
		{
			if(num>400)
			{
				res += "CD";
				num -= 400;
			}
			else
			{
				mul = num/100;
				rem = num%100;
				for(int i=0;i<mul ;i++)
					res+= "C";
				num = rem;
			}
			
		}
		if(num>=50)
		{
			if(num>90)
			{
				res+="XC";
				num -= 90;
			}
			else
			{
				mul = num/50;
				rem = num%50;
				for(int i=0;i<mul ;i++)
					res+= "L";
				num = rem;
			}
			
		}
		if(num>=10)
		{
			if(num>40){
				res+= "XL";
				num -= 40;
			}
			else
			{
				mul = num/10;
				rem = num%10;
				for(int i=0;i<mul ;i++)
					res+= "X";
				num = rem;
			}
		}
		if(num >= 5 )
		{
			if(num == 9)
			{
				res+= "IX";
				num -= 9;
			}
			else
			{
				res+= "V";
				num -= 5;
			}
		}
		if(num>=1)
		{
			if(num == 4)
			{
				res+= "IV";
			}
			else
			{
				for(int i=0;i<num;i++)
				{
					res+= "I";
				}
			}
			
		}
		return res;
	}
	public static void main(String[] args) {
		ConvertingDecimalNumberLyingBetween1To3999ToRomanNumerals obj = new ConvertingDecimalNumberLyingBetween1To3999ToRomanNumerals();
		System.out.println(obj.convertRoman(591));
		System.out.println(obj.convertRoman(581));
		System.out.println(obj.convertRoman(5541));
		System.out.println(obj.convertRoman(511));
	}
}
