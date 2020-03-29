package newDynamic;

public class CheckIfANumberCanBeExpressedAsXyXRaisedToPowerY {
	boolean canExpressed(int num)
	{
		for(int i=2;i<=Math.sqrt(num);i++) {
			int p = i;
			while(p <= num )
			{
				if(p== num)
					return true;
				p = p*i;	
			}
		}
		return false;
	}
	public static void main(String[] args)
    {
		CheckIfANumberCanBeExpressedAsXyXRaisedToPowerY obj = new CheckIfANumberCanBeExpressedAsXyXRaisedToPowerY();
        for (int i = 2; i < 100; i++)
            if (obj.canExpressed(i))
                System.out.print(i + " ");
    }
}	
