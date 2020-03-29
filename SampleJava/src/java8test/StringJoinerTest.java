package java8test;

//importing StringJoiner class  
import java.util.StringJoiner;

public class StringJoinerTest {
	public static void main(String[] args) {
		StringJoiner joinNames = new StringJoiner(",", "[", "]"); // passing
																	// comma(,)
																	// and
																	// square-brackets
																	// as
																	// delimiter

		// Adding values to StringJoiner
		joinNames.add("Rahul");
		joinNames.add("Raju");
		joinNames.add("Peter");
		joinNames.add("Raheem");

		StringJoiner joinname2 = new StringJoiner(", ", "{", "}");
		joinname2.add("narendra");
		joinname2.add("Kajol");
		System.out.println(joinNames);
		System.out.println(joinname2);
		joinname2.merge(joinNames);
		System.out.println(joinname2);

	}
}