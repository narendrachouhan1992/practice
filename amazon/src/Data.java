public class Data implements Comparable<Data>
{
	int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int compareTo(Data o) {
		if (this.num> ((Data)o).num)
			return 1;
		return -1;

	}

	@Override
	public String toString() {
		return "[" + num + "]";
	}

	public Data(int num) {
		super();
		this.num = num;
	}
}