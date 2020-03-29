package javaPractice;

public class CloneTester {
	public static void main(String[] args) {
		CloneSample obj = new CloneSample();
		obj.setNumber(123);
		obj.setName("asdfg");
		obj.setId(123456667);
		try {
			CloneSample obj1 = (CloneSample)obj.clone();
			System.out.println("base Object "+obj.getName() + " "+ obj.getNumber() +" " + obj.getId());
			System.out.println("base Object "+obj1.getName() + " "+ obj1.getNumber() +" " + obj.getId());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
