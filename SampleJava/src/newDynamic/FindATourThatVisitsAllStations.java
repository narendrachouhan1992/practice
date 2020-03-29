package newDynamic;
class PetrolPump
{
	int petrol;
	int distance;
	public PetrolPump(int petrol, int distance) {
		super();
		this.petrol = petrol;
		this.distance = distance;
	}
}
public class FindATourThatVisitsAllStations {
	int getStart(PetrolPump[] arr, int n)
	{
		int start = 0;
		int end = 1;
		int curr_petrol = arr[start].petrol-arr[start].distance;
		while(end!= start || curr_petrol<0)
		{
			while(curr_petrol<0)
			{
				curr_petrol-= (arr[start].petrol-arr[start].distance);
				start = (start+1)%n;
				if(start == 0)
					return -1;
			}
			curr_petrol+= arr[end].petrol-arr[end].distance;
			end = (end+1)%n;
		}
		
		return start;
	}
	public static void main(String[] args) {
		FindATourThatVisitsAllStations obj = new FindATourThatVisitsAllStations();
		PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};
		int start = obj.getStart(arr, 3);
		if(start == -1)
		{
			System.out.println("no solution possible");
		}
		else
		{
			System.out.println("starting point is "+start);
		}
	}
}
