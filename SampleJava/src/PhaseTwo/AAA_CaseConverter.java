package PhaseTwo;

public class AAA_CaseConverter {
	static String convertCase(String str)
	{
		String[] str1 = str.split("-");
		String answer = "";
		for (String s : str1) {
			answer += Character.toUpperCase(s.charAt(0)) + s.substring(1);
		}
		
		return (answer+"_p2");
	}
	public static void main(String[] args) {
		System.out.println(convertCase("position-of-rightmost-set-bit"));
		System.out.println(convertCase("print-possible-strings-can-made-placing-spaces"));
		System.out.println(convertCase("a-boolean-matrix-question"));
		System.out.println(convertCase("numbers-unique-distinct-digits"));
	}	
}
