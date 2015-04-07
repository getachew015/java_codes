package listImplementation;

public class Puppy implements Comparable<Puppy> {
	
	private String name;
	private int weight;
	
	public Puppy(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public boolean equals(Puppy aPuppy) {
		return name.equalsIgnoreCase(aPuppy.name) && (weight == aPuppy.weight);
	}

	@Override
	public int compareTo(Puppy arg0) {
		if (this.weight < arg0.weight)
			return -1;
		else if (this.weight == arg0.weight)
			return 0;
		else
			return 1;
	}
}
