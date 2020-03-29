package test;
interface cars
{
	int getPrice();
	void setPrice(int price);
}
class bus
{
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
public class InterfaceAbsTest extends bus implements cars {
	
}
